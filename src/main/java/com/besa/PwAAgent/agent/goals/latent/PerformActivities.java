package com.besa.PwAAgent.agent.goals.latent;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.BDI.AgentStructuralModel.LatentGoalStructure.LatentGoal;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import rational.mapping.Believes;

public class PerformActivities extends LatentGoal {

    public PerformActivities() {
        super(MotivationAgent.getPlanID());
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
