
package com.besa.PwAAgent.agent.goals.action;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.ServiceGoal;

import java.util.ArrayList;
import java.util.List;

import com.besa.PwAAgent.agent.PwAService;
import com.besa.PwAAgent.agent.tasks.MusicoTerapia.ReproduccionCancion;
import com.besa.PwAAgent.agent.tasks.MusicoTerapia.SeleccionarCancion;
import com.besa.PwAAgent.agent.tasks.Retroalimentacion.RecibirRetroalimentacionCancion;
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

    public static MusicoTerapia buildGoal(BeliefAgent beliefAgent) {
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
        MusicoTerapia b = new MusicoTerapia(MotivationAgent.getPlanID(), musicTherapyRole, beliefAgent);
        return b;
    }

    public MusicoTerapia(int id, RationalRole role, BeliefAgent beliefAgent) {
        super(id, role, descrip, 0, beliefAgent, new MusicoTerapiaContext());
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
                //TODO: Determinar cuando la emocion es negativa.

        if (medicalContext.getFast() <= 5) {
            // TODO: add gusto from db
            return 0.4;
        }
        return 0;
    }

    @Override
    public double evaluatePlausibility(Believes believes) throws KernellAgentEventExceptionBESA {
        // System.out.println("Meta MusicoTerapia evaluatePlausibility");
        return 1;
    }

    @Override
    public double evaluateContribution(StateBDI stateBDI) throws KernellAgentEventExceptionBESA {
        // System.out.println("Meta MusicoTerapia evaluateContribution");
        BeliefAgent blvs = (BeliefAgent) stateBDI.getBelieves();
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        PwAPreferenceContext prefContext = (PwAPreferenceContext) miPerfil.getUserContext().getPreferenceContext();
        List<ActXPreferencia> listaAct = prefContext.getActXPreferenciaList();
        double valor = 0;

        // TODO: change to repository mgmt
        for (ActXPreferencia act : listaAct) {
            if (act.getActividadPwa().getNombre().equalsIgnoreCase(PwAService.MUSICOTERAPIA.name())) {
                valor = act.getGusto();
            }
        }
        return valor;

    }

    @Override
    public boolean predictResultUnlegality(StateBDI agentStatus) throws KernellAgentEventExceptionBESA {
        // System.out.println("Meta MusicoTerapia predictResultUnlegability");
        return true;
    }

    @Override
    public boolean goalSucceeded(Believes believes) throws KernellAgentEventExceptionBESA {
        // System.out.println("Meta MusicoTerapia evaluateViability");
        //BeliefAgent blvs = (BeliefAgent) believes;
        //TODO: Determinar cuando la emocion es positiva.
        return false;
    }

    @Override
    public double calculateCriticality() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateCriticality'");
    }
}
