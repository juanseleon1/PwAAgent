package com.besa.PwAAgent.pepper.service;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.HumanCooperationAgent.guard.InteractionAnswerData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.services.interfaces.message.MessageServiceConfig;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public class PepperMessageServiceConfig extends MessageServiceConfig {

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

        if (data.getParams().containsKey("requests")) {
            data.getParams().put("category", "PERMISSION");
        } else if (data.getParams().containsKey("message")) {
            data.getParams().put("category", "NOTIFICATION");
        }
        return new RobotData(data.getId(), data.getServiceName(), "Message", data.getParams());
    }

    @Override
    public DataBESA translateSendMessageResponse(RobotData data) {
        if (data.getParameters().isEmpty()) {
            return data;
        } else {
            return new InteractionAnswerData((boolean) data.getParameters().get("authorized"),
                    (String) data.getParameters().get("permission"));

        }
    }

}
