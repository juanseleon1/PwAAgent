
package com.besa.PwAAgent.agent.goals.action;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.ServiceGoal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.besa.PwAAgent.agent.PwAService;
import com.besa.PwAAgent.agent.tasks.MusicoTerapia.ReproduccionCancion;
import com.besa.PwAAgent.agent.tasks.MusicoTerapia.SeleccionarCancion;
import com.besa.PwAAgent.agent.tasks.Retroalimentacion.RecibirRetroalimentacionCancion;
import com.besa.PwAAgent.agent.utils.PwAUtil;
import com.besa.PwAAgent.db.model.ActXPreferencia;
import com.besa.PwAAgent.db.model.userprofile.PwAMedicalContext;
import com.besa.PwAAgent.db.model.userprofile.PwAPreferenceContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import rational.RationalRole;
import rational.mapping.Believes;
import rational.mapping.Plan;
import rational.mapping.Task;

public class MusicoTerapia extends ServiceGoal<MusicoTerapiaContext> {

    private static String descrip = "MusicoTerapia";

    public static MusicoTerapia buildGoal() {
        SeleccionarCancion sCancion = new SeleccionarCancion();
        ReproduccionCancion rCancion = new ReproduccionCancion();
        RecibirRetroalimentacionCancion retro = new RecibirRetroalimentacionCancion();

        List<Task> tarea;
        Plan rolePlan = new Plan();

        rolePlan.addTask(sCancion);
        tarea = new ArrayList<>();
        tarea.add(sCancion);
        rolePlan.addTask(rCancion, tarea);

        tarea = new ArrayList<>();
        tarea.add(rCancion);
        rolePlan.addTask(retro, tarea);

        RationalRole musicTherapyRole = new RationalRole(descrip, rolePlan);
        MusicoTerapia b = new MusicoTerapia(MotivationAgent.getPlanID(), musicTherapyRole);
        return b;
    }

    public MusicoTerapia(int id, RationalRole role) {
        super(id, role, descrip, 0, new MusicoTerapiaContext());
    }

    @Override
    public double evaluateViability(Believes believes) throws KernellAgentEventExceptionBESA {
        // System.out.println("Meta MusicoTerapia evaluateViability");
        return 1;
    }

    @Override
    public double detectGoal(Believes believes) throws KernellAgentEventExceptionBESA {
        System.out.println("Meta MusicoTerapia detectGoal");
        BeliefAgent blvs = (BeliefAgent) believes;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        PwAMedicalContext medicalContext = (PwAMedicalContext) miPerfil.getUserMedicalContext();
        PwAPreferenceContext prefContext = (PwAPreferenceContext) miPerfil.getUserContext().getPreferenceContext();
        double valor = PwAUtil.getGustoActividad(PwAService.MUSICOTERAPIA, prefContext);

        Map<String, Double> emotions = blvs.getInteractionState().getCurrentInteraction(currUser).getUserEmotions();
        String maxEmotion = findMaxEmotionName(emotions);
        double max = emotions.get(maxEmotion);

        if (!(maxEmotion.equalsIgnoreCase("sorrow") || maxEmotion.equalsIgnoreCase("anger"))) {
            max *= -1;
        }

        if (medicalContext.getFast() <= 4) {
            return (0.4 + valor) * (1 + max);
        }
        return 0;
    }

    private String findMaxEmotionName(Map<String, Double> emotions) {
        double max = 0;
        String maxEmotion = "";
        for (Map.Entry<String, Double> entry : emotions.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxEmotion = entry.getKey();
            }
        }
        return maxEmotion;
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
        List<ActXPreferencia> listaAct = prefContext.getActXPreferenciaList();
        double valor = 0;
        for (ActXPreferencia act : listaAct) {
            if (act.getActividadPwa().getNombre().equalsIgnoreCase(PwAService.MUSICOTERAPIA.name())) {
                valor = act.getGusto();
                break;
            }
        }
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
        Map<String, Double> emotions = blvs.getInteractionState().getCurrentInteraction(currUser).getUserEmotions();
        String maxEmotion = findMaxEmotionName(emotions);

        return !(maxEmotion.equalsIgnoreCase("sorrow") || maxEmotion.equalsIgnoreCase("anger"));
    }

    @Override
    public double calculateCriticality(Believes believes) {
        return 0;
    }
}
