package com.besa.PwAAgent.pepper.service;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.agent.guard.RobotReplyData;
import BESA.SocialRobot.ServiceProvider.services.interfaces.mail.MailServiceConfig;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public class PepperMailServiceConfig extends MailServiceConfig{

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
    public RobotData translateSendMailAction(ServiceDataRequest arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'translateSendMailAction'");
    }

    @Override
    public RobotReplyData translateSendMailResponse(RobotData arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'translateSendMailResponse'");
    }

}
