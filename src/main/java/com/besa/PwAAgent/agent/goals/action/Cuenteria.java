package com.besa.PwAAgent.agent.goals.action;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
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
import com.besa.PwAAgent.agent.tasks.Retroalimentacion.RecibirRetroalimentacionCuento;
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
        RecibirRetroalimentacionCuento retro = new RecibirRetroalimentacionCuento();
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

        RationalRole cuenteriaRole = new RationalRole(descrip, rolePlan);
        Cuenteria b = new Cuenteria(MotivationAgent.getPlanID(), cuenteriaRole);
        return b;
    }

    public Cuenteria(int id, RationalRole role) {
        super(id, role, descrip, 0, new CuenteriaContext());
    }

    @Override
    public double evaluateViability(Believes believes) throws KernellAgentEventExceptionBESA {
        return 1;
    }

    @Override
    public double detectGoal(Believes believes) throws KernellAgentEventExceptionBESA {
        System.out.println("Meta Cuenteria detectGoal");
        BeliefAgent blvs = (BeliefAgent) believes;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);

        PwAMedicalContext medicalContext = (PwAMedicalContext) miPerfil.getUserMedicalContext();
        PwAPreferenceContext prefContext = (PwAPreferenceContext) miPerfil.getUserContext().getPreferenceContext();
        UserInteractionState interactionContext = blvs.getInteractionState().getCurrentInteraction(currUser);
        Map<String, Double> userEmotions = interactionContext.getUserEmotions();

        if (medicalContext.getFast() <= 5) {
            if (userEmotions.get("atention") < 0.4
                    && userEmotions.get("calm") < 0.6) {
                return 0.4 + PwAUtil.getGustoActividad(PwAService.CUENTERIA, prefContext);
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
        PwAPreferenceContext prefContext = (PwAPreferenceContext) miPerfil.getUserContext().getPreferenceContext();
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
        return (userEmotions.get("attention") >= 0.4
                && userEmotions.get("calm") >= 0.6);
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
