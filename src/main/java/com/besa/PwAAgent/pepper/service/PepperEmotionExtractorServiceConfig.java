package com.besa.PwAAgent.pepper.service;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.services.sensing.emotionextractor.EmotionExtractorServiceConfig;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public class PepperEmotionExtractorServiceConfig extends EmotionExtractorServiceConfig{

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
    public RobotData translateGetUserEmotionsAction(ServiceDataRequest arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'translateGetUserEmotionsAction'");
    }

    @Override
    public DataBESA translateGetUserEmotionsResponse(RobotData arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'translateGetUserEmotionsResponse'");
    }

}
