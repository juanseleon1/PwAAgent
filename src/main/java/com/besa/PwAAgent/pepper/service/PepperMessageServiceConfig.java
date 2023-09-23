package com.besa.PwAAgent.pepper.service;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.services.interfaces.message.MessageServiceConfig;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public class PepperMessageServiceConfig extends MessageServiceConfig{

    @Override
    public DataBESA translateOtherActionsToDataBesa(RobotData arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'translateOtherActionsToDataBesa'");
    }

    @Override
    public RobotData translateOtherActionsToRobotData(ServiceDataRequest arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'translateOtherActionsToRobotData'");
    }

    @Override
    public RobotData translateSendMessageAction(ServiceDataRequest arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'translateSendMessageAction'");
    }

    @Override
    public DataBESA translateSendMessageResponse(RobotData arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'translateSendMessageResponse'");
    }

}
