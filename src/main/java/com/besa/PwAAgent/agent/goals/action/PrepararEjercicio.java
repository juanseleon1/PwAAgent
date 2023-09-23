
package com.besa.PwAAgent.agent.goals.action;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.ServiceGoal;
import rational.RationalRole;
import rational.mapping.Believes;
import rational.mapping.Plan;
import rational.mapping.Task;

import java.util.ArrayList;
import java.util.List;

import com.besa.PwAAgent.agent.tasks.PrepararEjercicio.PreguntarPreparacion;

public class PrepararEjercicio extends ServiceGoal<PrepararEjercicioContext> {

    private static final String DESCRIP = "PrepararEjercicio";

    public static PrepararEjercicio buildGoal(BeliefAgent beliefAgent) {

        PreguntarPreparacion prg = new PreguntarPreparacion("Hola! Voy a hacerte unas preguntas para"
                + "asegurarme que todo esté listo para hacer nuestro ejercicio de hoy!");
        List<Task> tarea;
        tarea = new ArrayList<>();
        Plan rolePlan = new Plan();

        rolePlan.addTask(prg);
        tarea.add(prg);

        RationalRole convEmpRole = new RationalRole(DESCRIP, rolePlan);
        PrepararEjercicio b = new PrepararEjercicio(MotivationAgent.getPlanID(), convEmpRole, beliefAgent);
        return b;
    }

    public PrepararEjercicio(int id, RationalRole role, BeliefAgent beliefAgent) {
        super(id, role, DESCRIP, 0, beliefAgent, new PrepararEjercicioContext());
    }

    @Override
    public double evaluateViability(Believes believes) throws KernellAgentEventExceptionBESA {
        // System.out.println("Meta ConversarEmpaticamente evaluateViability");
        return 1;
    }

    @Override
    public double detectGoal(Believes believes) throws KernellAgentEventExceptionBESA {
        //BeliefAgent blvs = (BeliefAgent) believes;
        //if (!blvs.getbEstadoInteraccion().getPreparadoEjercicio()) {
        //    // System.out.println("Detecté al ejercicio");
        //    return 1;
        //}
        return 0;
    }

    @Override
    public double evaluatePlausibility(Believes believes) throws KernellAgentEventExceptionBESA {
        // System.out.println("Meta ConversarEmpaticamente evaluatePlausibility");
        return 1;
    }

    @Override
    public double evaluateContribution(StateBDI stateBDI) throws KernellAgentEventExceptionBESA {
        // System.out.println("Meta ConversarEmpaticamente evaluateContribution");
        // TODO: Ver que significa esta evaluación de contribución...?
        // BeliefAgent blvs = (BeliefAgent)stateBDI.getBelieves();
        return 1.0;
    }

    @Override
    public boolean predictResultUnlegality(StateBDI agentStatus) throws KernellAgentEventExceptionBESA {
        // System.out.println("Meta ConversarEmpaticamente predictResultUnlegality");
        return true;
    }

    @Override
    public boolean goalSucceeded(Believes believes) throws KernellAgentEventExceptionBESA {
        // System.out.println("Meta ConversarEmpaticamente goalSucceeded");
        // TODO: Verificar que se hayan acertado todas las preguntas.
        //BeliefAgent blvs = (BeliefAgent) believes;
        //blvs.getbEstadoInteraccion().resetPreparacionNegada();
        //if ((blvs.getbEstadoInteraccion().getPreparacionNegada())
        //        || (blvs.getbEstadoInteraccion().getPreparadoEjercicio())) {
        //    blvs.getbEstadoInteraccion().resetPreparacionNegada();
        //    return true;
        //} else {
        //    return false;
        //}
        return true;
        //TODO :ALL
    }

    @Override
    public double calculateCriticality() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateCriticality'");
    }
}
