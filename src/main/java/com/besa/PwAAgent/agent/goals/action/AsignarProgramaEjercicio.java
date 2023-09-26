package com.besa.PwAAgent.agent.goals.action;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;

import java.util.ArrayList;
import java.util.List;

import com.besa.PwAAgent.agent.tasks.AsignarProgramaEjercicio.CrearProgramaEjercicio;
import com.besa.PwAAgent.agent.tasks.ProgramarRutina.ProgramarEjercicios;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import rational.RationalRole;
import rational.mapping.Believes;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import rational.mapping.Plan;
import rational.mapping.Task;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.ServiceGoal;

public class AsignarProgramaEjercicio extends ServiceGoal<AsignarProgramaEjercicioContext> {
    private final static String DESCRIPTION = "RutinaEjercicio";

    public AsignarProgramaEjercicio(int id, RationalRole role) {
        super(id, role, DESCRIPTION, 0,  new AsignarProgramaEjercicioContext());
    }

    public static AsignarProgramaEjercicio buildGoal() {
        CrearProgramaEjercicio progRutina = new CrearProgramaEjercicio();
        ProgramarEjercicios progEjercicio = new ProgramarEjercicios();
        Plan rolePlan = new Plan();
        List<Task> taskList;

        rolePlan.addTask(progRutina);

        taskList = new ArrayList<>();
        taskList.add(progRutina);
        rolePlan.addTask(progEjercicio, taskList);

        RationalRole progRutinaRole = new RationalRole(DESCRIPTION, rolePlan);
        AsignarProgramaEjercicio b = new AsignarProgramaEjercicio(MotivationAgent.getPlanID(), progRutinaRole);
        return b;
    }

    @Override
    public double evaluateViability(Believes believes) throws KernellAgentEventExceptionBESA {
        return 1;
    }

    @Override
    public double evaluatePlausibility(Believes believes) throws KernellAgentEventExceptionBESA {
        return 1;
    }

    @Override
    public double detectGoal(Believes believes) throws KernellAgentEventExceptionBESA {
        BeliefAgent blvs = (BeliefAgent) believes;
        String userId = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(userId);
        if (miPerfil.getExerciseProfile() != null)
            return 0;
        return 1;
    }

    @Override
    public double evaluateContribution(StateBDI stateBDI) throws KernellAgentEventExceptionBESA {
        return 1;
    }

    @Override
    public boolean predictResultUnlegality(StateBDI agentStatus) throws KernellAgentEventExceptionBESA {
        return true;
    }

    @Override
    public boolean goalSucceeded(Believes believes) throws KernellAgentEventExceptionBESA {
        BeliefAgent blvs = (BeliefAgent) believes;
        String userId = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(userId);
        AsignarProgramaEjercicioContext context = (AsignarProgramaEjercicioContext) blvs.getServiceContext(AsignarProgramaEjercicio.class);
        return miPerfil.getExerciseProfile() != null || context.getCancelarProgramacionEjercicio();
    }

    @Override
    public double calculateCriticality(Believes believes) {
        //Not Critical as it is done by Carer.
        return 0;
    }
}
