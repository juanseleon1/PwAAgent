package com.besa.PwAAgent.agent.goals.action;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.ServiceGoal;
import rational.RationalRole;
import rational.mapping.Believes;

public class LeerBiblia extends ServiceGoal<LeerBibliaContext>{

    public LeerBiblia(long id, RationalRole role, String description, double accountability, BeliefAgent beliefAgent,
            LeerBibliaContext userContext) {
        super(id, role, description, accountability, beliefAgent, userContext);
        //TODO Auto-generated constructor stub
    }

    @Override
    public double detectGoal(Believes arg0) throws KernellAgentEventExceptionBESA {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'detectGoal'");
    }

    @Override
    public double evaluateContribution(StateBDI arg0) throws KernellAgentEventExceptionBESA {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evaluateContribution'");
    }

    @Override
    public double evaluatePlausibility(Believes arg0) throws KernellAgentEventExceptionBESA {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evaluatePlausibility'");
    }

    @Override
    public double evaluateViability(Believes arg0) throws KernellAgentEventExceptionBESA {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evaluateViability'");
    }

    @Override
    public boolean goalSucceeded(Believes arg0) throws KernellAgentEventExceptionBESA {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'goalSucceeded'");
    }

    @Override
    public boolean predictResultUnlegality(StateBDI arg0) throws KernellAgentEventExceptionBESA {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'predictResultUnlegality'");
    }

    @Override
    public double calculateCriticality() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateCriticality'");
    }
    
}
