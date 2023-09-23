package com.besa.PwAAgent.agent.goals.action;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;

import java.util.ArrayList;
import java.util.List;

import com.besa.PwAAgent.agent.tasks.AsignarProgramaEjercicio.CrearProgramaEjercicio;
import com.besa.PwAAgent.agent.tasks.ProgramarRutina.ProgramarEjercicios;

import rational.RationalRole;
import rational.mapping.Believes;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import rational.mapping.Plan;
import rational.mapping.Task;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.ServiceGoal;

public class AsignarProgramaEjercicio extends ServiceGoal<AsignarProgramaEjercicioContext>
{
    private final static String DESCRIPTION = "RutinaEjercicio";
    public AsignarProgramaEjercicio(int id, RationalRole role, BeliefAgent beliefAgent) 
    {
        super(id, role, DESCRIPTION, 0, beliefAgent, new AsignarProgramaEjercicioContext());
    }
    public static AsignarProgramaEjercicio buildGoal(BeliefAgent beliefAgent) 
    {

        CrearProgramaEjercicio progRutina = new CrearProgramaEjercicio();
        ProgramarEjercicios progEjercicio = new ProgramarEjercicios();
        Plan rolePlan= new Plan();
        List<Task> taskList;
        
        rolePlan.addTask(progRutina);
        
        taskList = new ArrayList<>();
        taskList.add(progRutina);
        rolePlan.addTask(progEjercicio, taskList);
        
        RationalRole progRutinaRole = new RationalRole(DESCRIPTION, rolePlan);
        AsignarProgramaEjercicio b = new AsignarProgramaEjercicio(MotivationAgent.getPlanID(), progRutinaRole, beliefAgent);
        return b;
    }
    @Override
    public double evaluateViability(Believes believes) throws KernellAgentEventExceptionBESA 
    {
        return 1;
    }
    @Override
    public double evaluatePlausibility(Believes believes) throws KernellAgentEventExceptionBESA {
        //System.out.println("Meta MantenerAtencionPwA evaluatePlausibility");
        return 1;
    }
    @Override
    public double detectGoal(Believes believes) throws KernellAgentEventExceptionBESA 
    {
        //BeliefAgent blvs = (BeliefAgent) believes;
        //PwAProfile miPerfil = blvs.getbPwAProfile().getPerfil();
        //if (miPerfil.getExerciseProfile() != null) return 0;
        return 1;
    }
    @Override
    public double evaluateContribution(StateBDI stateBDI) throws KernellAgentEventExceptionBESA {
        return 1;
    }
    @Override
    public boolean predictResultUnlegality(StateBDI agentStatus) throws KernellAgentEventExceptionBESA {
        //System.out.println("Meta MantenerAtencionPwA predictResultUnlegality");
        return true;
    }
    @Override
    public boolean goalSucceeded(Believes believes) throws KernellAgentEventExceptionBESA 
    {
        //BeliefAgent blvs = (BeliefAgent) believes;
        //PwAProfile miPerfil = blvs.getbPwAProfile().getPerfil();
        //return miPerfil.getExerciseProfile() != null || blvs.getbEstadoInteraccion().getCancelarProgramacionEjercicio();
        return true;
    }
    @Override
    public double calculateCriticality() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateCriticality'");
    } 
}
