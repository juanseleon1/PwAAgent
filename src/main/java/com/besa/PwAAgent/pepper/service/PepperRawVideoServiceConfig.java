package com.besa.PwAAgent.pepper.service;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.services.sensing.rawvideo.RawVideoServiceConfig;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public class PepperRawVideoServiceConfig extends RawVideoServiceConfig{

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
    public RobotData translateGetRawVideoAction(ServiceDataRequest arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'translateGetRawVideoAction'");
    }

    @Override
    public DataBESA translateGetRawVideoResponse(RobotData arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'translateGetRawVideoResponse'");
    }

}
