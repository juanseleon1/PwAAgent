package com.besa.PwAAgent.agent.goals.action;

import com.besa.PwAAgent.agent.tasks.DemostrarVida.HacerCosas;
import BESA.BDI.AgentStructuralModel.GoalBDI;
import BESA.BDI.AgentStructuralModel.GoalBDITypes;
import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import rational.RationalRole;
import rational.mapping.Believes;
import rational.mapping.Plan;

public class DemostrarVida extends GoalBDI{

    private static String descrip = "DemostrarVida";

    public static DemostrarVida buildGoal() {
        HacerCosas retro = new HacerCosas();

        Plan rolePlan = new Plan();

        rolePlan.addTask(retro);

        RationalRole role = new RationalRole(descrip, rolePlan);
        DemostrarVida b = new DemostrarVida(MotivationAgent.getPlanID(), role, descrip, GoalBDITypes.NEED);
        return b;
    }

    public DemostrarVida(long id, RationalRole role, String description, GoalBDITypes type) {
        super(id, role, description, type);
    }

    @Override
    public double evaluatePlausibility(Believes beliefs) throws KernellAgentEventExceptionBESA {
        return 1;
    }

    @Override
    public double evaluateViability(Believes beliefs) throws KernellAgentEventExceptionBESA {
        return 1;
}

    @Override
    public boolean goalSucceeded(Believes beliefs) throws KernellAgentEventExceptionBESA {
        return false;
    }

    @Override
    public boolean predictResultUnlegality(StateBDI state) throws KernellAgentEventExceptionBESA {
        return true;
    }

    @Override
    public double detectGoal(Believes beliefs) throws KernellAgentEventExceptionBESA {
        return 1;
    }

    @Override
    public double evaluateContribution(StateBDI state) throws KernellAgentEventExceptionBESA {
        return 1;
    }
    
}
