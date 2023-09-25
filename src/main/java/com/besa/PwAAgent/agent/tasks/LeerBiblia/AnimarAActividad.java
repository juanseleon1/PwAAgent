package com.besa.PwAAgent.agent.tasks.LeerBiblia;

import com.besa.PwAAgent.agent.goals.action.LeerBiblia;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class AnimarAActividad extends SRTask{

    @Override
    public void executeTask(Believes believes) {
        BeliefAgent blvs = (BeliefAgent) believes;
        blvs.getInteractionState().setActiveService(LeerBiblia.class.getName());
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executeTask'");
    }
    
}
