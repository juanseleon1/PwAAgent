package com.besa.PwAAgent.pepper.service;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.services.interfaces.message.MessageServiceConfig;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public class PepperMessageServiceConfig extends MessageServiceConfig{

    @Override
    public DataBESA translateOtherActionsToDataBesa(RobotData data) {
        throw new UnsupportedOperationException("Unimplemented method 'translateOtherActionsToDataBesa'");
    }

    @Override
    public RobotData translateOtherActionsToRobotData(ServiceDataRequest data) {
        throw new UnsupportedOperationException("Unimplemented method 'translateOtherActionsToRobotData'");
    }

    @Override
    public RobotData translateSendMessageAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "MSG", data.getParams());
    }

    @Override
    public DataBESA translateSendMessageResponse(RobotData data) {
        return data;
    }

}
