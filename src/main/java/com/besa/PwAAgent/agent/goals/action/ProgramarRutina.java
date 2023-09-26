
package com.besa.PwAAgent.agent.goals.action;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.ServiceGoal;

import java.util.List;

import com.besa.PwAAgent.agent.tasks.ProgramarRutina.ProgramarEjercicios;
import com.besa.PwAAgent.db.model.Ejercicio;
import com.besa.PwAAgent.db.model.userprofile.PwAExerciseProfile;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import rational.RationalRole;
import rational.mapping.Believes;
import rational.mapping.Plan;


public class ProgramarRutina extends ServiceGoal<ProgramarRutinaContext>  {
    private final static String DESCRIPTION = "ProgramarRutina";
    
    public ProgramarRutina(int id, RationalRole role) 
    {
        super(id, role, DESCRIPTION, 0, new ProgramarRutinaContext());
    }

    public static ProgramarRutina buildGoal() 
    {

        ProgramarEjercicios progEjercicios = new ProgramarEjercicios();
        Plan rolePlan= new Plan();
        
        rolePlan.addTask(progEjercicios);
        
        RationalRole rutEjercicioRole = new RationalRole(DESCRIPTION, rolePlan);
        ProgramarRutina b = new ProgramarRutina(MotivationAgent.getPlanID(), rutEjercicioRole);
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
        BeliefAgent blvs = (BeliefAgent) believes;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        
        if (miPerfil.getExerciseProfile() == null)
        {
            System.out.println("No tengo perfil.");
            return 0;
        }
        else
        {
            PwAExerciseProfile miPwAExerciseProfile = miPerfil.getExerciseProfile();
            List<Ejercicio> listaEjercicio = miPwAExerciseProfile.getEjercicioList();
            if (!listaEjercicio.isEmpty())
            {
                System.out.println("La lista no esta vacia");
                return 0;
            }
            return 1;
        }
        
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
        return false;
    }
    @Override
    public double calculateCriticality(Believes believes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateCriticality'");
    }
    
}
