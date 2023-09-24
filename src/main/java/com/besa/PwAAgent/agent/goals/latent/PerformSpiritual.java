package com.besa.PwAAgent.agent.goals.latent;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.BDI.AgentStructuralModel.LatentGoalStructure.LatentGoal;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import rational.mapping.Believes;

public class PerformSpiritual extends LatentGoal {

    public PerformSpiritual() {
        super(MotivationAgent.getPlanID());
    }

    @Override
    public double detectGoal(Believes beliefs) throws KernellAgentEventExceptionBESA {
        // BeliefAgent beliefAgent = (BeliefAgent) beliefs;
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'detectGoal'");
    }

    @Override
    public double evaluateContribution(StateBDI state) throws KernellAgentEventExceptionBESA {
        // BeliefAgent beliefAgent = (BeliefAgent) state.getBelieves();
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evaluateContribution'");
    }

}
