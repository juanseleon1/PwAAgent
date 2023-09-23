
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
import com.besa.PwAAgent.db.model.ActXPreferencia;
import com.besa.PwAAgent.db.model.userprofile.PwAMedicalContext;
import com.besa.PwAAgent.db.model.userprofile.PwAPreferenceContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import rational.RationalRole;
import rational.mapping.Believes;
import rational.mapping.Plan;
import rational.mapping.Task;

public class Cuenteria extends ServiceGoal<CuenteriaContext> {

    private static String descrip = "Cuenteria";

    public static Cuenteria buildGoal(BeliefAgent beliefAgent) {
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
        Cuenteria b = new Cuenteria(MotivationAgent.getPlanID(), cuenteriaRole, beliefAgent);
        return b;
    }

    public Cuenteria(int id, RationalRole role, BeliefAgent beliefAgent) {
        super(id, role, descrip, 0, beliefAgent, new CuenteriaContext());
    }

    @Override
    public double evaluateViability(Believes believes) throws KernellAgentEventExceptionBESA {
        // System.out.println("Meta Cuenteria evaluateViability");
        return 1;
    }

    @Override
    public double detectGoal(Believes believes) throws KernellAgentEventExceptionBESA {
        System.out.println("Meta Cuenteria detectGoal");
        BeliefAgent blvs = (BeliefAgent) believes;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);

        PwAMedicalContext medicalContext = (PwAMedicalContext)miPerfil.getUserMedicalContext();
        UserInteractionState interactionContext = blvs.getInteractionState().getCurrentInteraction(currUser);
        Map<String, Double> userEmotions = interactionContext.getUserEmotions();

        if (medicalContext.getFast() <= 5) {
            if (userEmotions.get("atention") < 0.4
                    && userEmotions.get("relaxation") < 0.6) {
                        //TODO: add gusto from db
                return 0.4;

            }
        }
        return 0;
    }

    @Override
    public double evaluatePlausibility(Believes believes) throws KernellAgentEventExceptionBESA {
        // System.out.println("Meta Cuenteria evaluatePlausibility");
        return 1;
    }

    @Override
    public double evaluateContribution(StateBDI stateBDI) throws KernellAgentEventExceptionBESA {
        // System.out.println("Meta Cuenteria evaluateContribution");
        BeliefAgent blvs = (BeliefAgent) stateBDI.getBelieves();
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        PwAPreferenceContext prefContext = (PwAPreferenceContext) miPerfil.getUserContext().getPreferenceContext();
        List<ActXPreferencia> listaAct = prefContext.getActXPreferenciaList();
        double valor = 0;

        for (ActXPreferencia act : listaAct) {
            if (act.getActividadPwa().getNombre().equalsIgnoreCase(PwAService.CUENTERIA.name())) {
                valor = act.getGusto();
            }
        }

        return valor + 1;

    }

    @Override
    public boolean predictResultUnlegality(StateBDI agentStatus) throws KernellAgentEventExceptionBESA {
        // System.out.println("Meta Cuenteria predictResultUnlegability");
        return true;
    }

    @Override
    public boolean goalSucceeded(Believes believes) throws KernellAgentEventExceptionBESA {
        // System.out.println("Meta Cuenteria evaluateViability");
        BeliefAgent blvs = (BeliefAgent) believes;
                String currUser = blvs.getActiveUsers().get(0);

                UserInteractionState interactionContext = blvs.getInteractionState().getCurrentInteraction(currUser);
        Map<String, Double> userEmotions = interactionContext.getUserEmotions();
        if ((userEmotions.get("atention") >= 0.4
                    && userEmotions.get("relaxation") >= 0.6)) {

            return true;
        }
        return false;
    }

    @Override
    public double calculateCriticality() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateCriticality'");
    }
}
