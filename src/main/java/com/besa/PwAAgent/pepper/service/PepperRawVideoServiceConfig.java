package com.besa.PwAAgent.pepper.service;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.RiskDetectionAgent.agent.RawVideoData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.services.sensing.rawvideo.RawVideoServiceConfig;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public class PepperRawVideoServiceConfig extends RawVideoServiceConfig {

    @Override
    public DataBESA translateOtherActionsToDataBesa(RobotData data) {
        RawVideoData dataBESA = new RawVideoData();
        dataBESA.setParams(data.getParameters());
        dataBESA.setUserId((String) data.getParameters().get("userID"));
        return dataBESA;
    }

    @Override
    public RobotData translateOtherActionsToRobotData(ServiceDataRequest data) {
        throw new UnsupportedOperationException("Unimplemented method 'translateOtherActionsToRobotData'");
    }

    @Override
    public RobotData translateGetRawVideoAction(ServiceDataRequest data) {
        throw new UnsupportedOperationException("Unimplemented method 'translateOtherActionsToRobotData'");
    }

    @Override
    public DataBESA translateGetRawVideoResponse(RobotData data) {
        RawVideoData dataBESA = new RawVideoData();
        dataBESA.setParams(data.getParameters());
        dataBESA.setUserId((String) data.getParameters().get("userID"));
        return dataBESA;
    }

}
