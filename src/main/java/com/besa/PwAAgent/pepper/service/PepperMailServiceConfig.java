package com.besa.PwAAgent.pepper.service;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.HumanCooperationAgent.guard.InteractionAnswerData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.services.interfaces.mail.MailServiceConfig;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public class PepperMailServiceConfig extends MailServiceConfig{

    @Override
    public DataBESA translateOtherActionsToDataBesa(RobotData data) {
        throw new UnsupportedOperationException("Unimplemented method 'translateOtherActionsToDataBesa'");
    }

    @Override
    public RobotData translateOtherActionsToRobotData(ServiceDataRequest data) {
        throw new UnsupportedOperationException("Unimplemented method 'translateOtherActionsToRobotData'");
    }

    @Override
    public RobotData translateSendMailAction(ServiceDataRequest data) {
        throw new UnsupportedOperationException("Unimplemented method 'translateSendMailAction'");
    }

    @Override
    public InteractionAnswerData translateSendMailResponse(RobotData data) {
        throw new UnsupportedOperationException("Unimplemented method 'translateSendMailResponse'");
    }

}
