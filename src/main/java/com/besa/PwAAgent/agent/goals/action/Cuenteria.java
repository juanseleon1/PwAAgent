package com.besa.PwAAgent.agent.goals.action;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.UserInteraction.UserInteractionState;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.ServiceGoal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.besa.PwAAgent.agent.PwAService;
import com.besa.PwAAgent.agent.tasks.Cuenteria.ReproducirCuento;
import com.besa.PwAAgent.agent.tasks.Cuenteria.SeleccionarCuento;
import com.besa.PwAAgent.agent.tasks.Retroalimentacion.RealizarRetroalimentacion;
import com.besa.PwAAgent.agent.tasks.Retroalimentacion.ResponderRetroalimentacion;
import com.besa.PwAAgent.agent.utils.PwAUtil;
import com.besa.PwAAgent.db.model.userprofile.PwAMedicalContext;
import com.besa.PwAAgent.db.model.userprofile.PwAPreferenceContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import rational.RationalRole;
import rational.mapping.Believes;
import rational.mapping.Plan;
import rational.mapping.Task;

public class Cuenteria extends ServiceGoal<CuenteriaContext> {

    private static String descrip = "Cuenteria";

    public static Cuenteria buildGoal() {
        List<String> preguntas = new ArrayList<>();
        CuenteriaContext context = new CuenteriaContext();
        preguntas.add("De uno a cinco, ¿que te parecio la actividad?");
        preguntas.add("De uno a cinco, ¿que tanto te gusto el cuento?");
        preguntas.add("De uno a cinco, ¿como evaluarias mi atención?");
        RealizarRetroalimentacion retro = new RealizarRetroalimentacion(preguntas, "Ahora que se acabo el cuento, quiero conocer tu opinion sobre la actividad.");
        ResponderRetroalimentacion retroR = new ResponderRetroalimentacion();
        SeleccionarCuento recomCuento = new SeleccionarCuento();
        ReproducirCuento rCuento = new ReproducirCuento();

        List<Task> taskList;
        Plan rolePlan = new Plan();

        rolePlan.addTask(recomCuento);

        taskList = new ArrayList<>();
        taskList.add(recomCuento);
        rolePlan.addTask(rCuento, taskList);

        taskList = new ArrayList<>();
        taskList.add(rCuento);
        rolePlan.addTask(retro, taskList);
        
        taskList = new ArrayList<>();
        taskList.add(retro);
        rolePlan.addTask(retroR, taskList);

        RationalRole cuenteriaRole = new RationalRole(descrip, rolePlan);
        Cuenteria b = new Cuenteria(MotivationAgent.getPlanID(), cuenteriaRole, context);
        return b;
    }

    public Cuenteria(int id, RationalRole role, CuenteriaContext context) {
        super(id, role, descrip, 0, context);
    }

    @Override
    public double evaluateViability(Believes believes) throws KernellAgentEventExceptionBESA {
        return 1;
    }

    @Override
    public double detectGoal(Believes believes) throws KernellAgentEventExceptionBESA {
        //ReportBESA.debug("Meta Cuenteria detectGoal");
        BeliefAgent blvs = (BeliefAgent) believes;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);

        PwAMedicalContext medicalContext = (PwAMedicalContext) miPerfil.getUserMedicalContext();
        UserInteractionState interactionContext = blvs.getInteractionState().getCurrentInteraction(currUser);
        Map<String, Double> userEmotions = interactionContext.getUserEmotions();
        //ReportBESA.debug("log user Emotions: " + userEmotions.toString());
        if (medicalContext.getFast() <= 5) {
            if (userEmotions.size() > 0) {
                return userEmotions.get("calm") < 0.6 ? 1 : 0;
            }
        }
        return 0;
    }

    @Override
    public double evaluatePlausibility(Believes believes) throws KernellAgentEventExceptionBESA {
        return 1;
    }

    @Override
    public double evaluateContribution(StateBDI stateBDI) throws KernellAgentEventExceptionBESA {
        BeliefAgent blvs = (BeliefAgent) stateBDI.getBelieves();
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        PwAPreferenceContext prefContext = (PwAPreferenceContext) miPerfil.getPwAPreferenceContext();
        double valor = PwAUtil.getGustoActividad(PwAService.CUENTERIA, prefContext);
        return valor;

    }

    @Override
    public boolean predictResultUnlegality(StateBDI agentStatus) throws KernellAgentEventExceptionBESA {
        return true;
    }

    @Override
    public boolean goalSucceeded(Believes believes) throws KernellAgentEventExceptionBESA {
        BeliefAgent blvs = (BeliefAgent) believes;
        String currUser = blvs.getActiveUsers().get(0);

        UserInteractionState interactionContext = blvs.getInteractionState().getCurrentInteraction(currUser);
        Map<String, Double> userEmotions = interactionContext.getUserEmotions();
        return (userEmotions.get("calm") >= 0.6);
    }

    @Override
    public double calculateCriticality(Believes believes) {
        BeliefAgent blvs = (BeliefAgent) believes;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        PwAMedicalContext medicalContext = miPerfil.getUserMedicalContext();
        double criticality = 0;
        criticality += medicalContext.getFast() / 10d;
        return criticality;
    }
}
