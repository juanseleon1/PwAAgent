package com.besa.PwAAgent.pepper.action;

import java.util.List;

import BESA.SocialRobot.BDIAgent.ActionAgent.ActionRequestData;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.ActionDescriptor;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.ActionExecutor;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.RobotEmotionalConfig;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.RobotResources;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public class PepperActionExecutor extends ActionExecutor{

    public PepperActionExecutor(RobotResources resourceDescriptor, RobotEmotionalConfig configDescriptor,
            ActionDescriptor actionDescriptor) {
        super(resourceDescriptor, configDescriptor, actionDescriptor);
        //TODO Auto-generated constructor stub
    }

    @Override
    public List<ServiceDataRequest> getActionPrimitives(ActionRequestData arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActionPrimitives'");
    }

}
