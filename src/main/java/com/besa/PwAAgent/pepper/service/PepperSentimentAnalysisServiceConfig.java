package com.besa.PwAAgent.pepper.service;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.services.speech.sentimentanalysis.SentimentAnalysisServiceConfig;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public class PepperSentimentAnalysisServiceConfig extends SentimentAnalysisServiceConfig{

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
    public RobotData translateOtherCancelActionsToRobotData(ServiceDataRequest arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'translateOtherCancelActionsToRobotData'");
    }

    @Override
    public RobotData translateActivateSentimentAnalysisAction(ServiceDataRequest arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'translateActivateSentimentAnalysisAction'");
    }

    @Override
    public DataBESA translateActivateSentimentAnalysisResponse(RobotData arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'translateActivateSentimentAnalysisResponse'");
    }

    @Override
    public RobotData translateDeactivateSentimentAnalysisAction(ServiceDataRequest arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'translateDeactivateSentimentAnalysisAction'");
    }

    @Override
    public DataBESA translateDeactivateSentimentAnalysisResponse(RobotData arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'translateDeactivateSentimentAnalysisResponse'");
    }

}
