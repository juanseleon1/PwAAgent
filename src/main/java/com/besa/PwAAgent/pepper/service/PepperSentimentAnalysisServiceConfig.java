package com.besa.PwAAgent.pepper.service;

import java.util.ArrayList;
import java.util.List;

import com.besa.PwAAgent.pwa.PwAEmotionalModel.Emotion;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.services.speech.sentimentanalysis.SentimentAnalysisServiceConfig;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.EmotionalDataType;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotion;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotionalData;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public class PepperSentimentAnalysisServiceConfig extends SentimentAnalysisServiceConfig {

    @Override
    public DataBESA translateOtherActionsToDataBesa(RobotData data) {
        throw new UnsupportedOperationException("Unimplemented method 'translateOtherActionsToDataBesa'");
    }

    @Override
    public RobotData translateOtherActionsToRobotData(ServiceDataRequest data) {
        throw new UnsupportedOperationException("Unimplemented method 'translateOtherActionsToRobotData'");
    }

    @Override
    public RobotData translateOtherCancelActionsToRobotData(ServiceDataRequest data) {
        throw new UnsupportedOperationException("Unimplemented method 'translateOtherCancelActionsToRobotData'");
    }

    @Override
    public RobotData translateActivateSentimentAnalysisAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "ACTIVATEVOICEEMOANAL", data.getParams());

    }

    @Override
    @SuppressWarnings("unchecked")
    public DataBESA translateActivateSentimentAnalysisResponse(RobotData data) {
        float joyval, angval, sowval, calmval;
        String userId = (String) data.getParameters().get("userID");
        List<Object> params = (List<Object>) data.getParameters().get("voiceEmotionRecognized");
        List<Integer> emotList = (List<Integer>) params.get(1);
        calmval = emotList.get(1).intValue();
        angval = emotList.get(2).intValue();
        joyval = emotList.get(3).intValue();
        sowval = emotList.get(4).intValue();
        List<UserEmotion> emotions = new ArrayList<>();
        emotions.add(new UserEmotion(Emotion.calm.name(), calmval));
        emotions.add(new UserEmotion(Emotion.anger.name(), angval));
        emotions.add(new UserEmotion(Emotion.joy.name(), joyval));
        emotions.add(new UserEmotion(Emotion.sorrow.name(), sowval));
        return new UserEmotionalData(userId, EmotionalDataType.VOICE, emotions);
    }

    @Override
    public RobotData translateDeactivateSentimentAnalysisAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "DESACTIVVOICEEMOANAL", data.getParams());

    }

    @Override
    public DataBESA translateDeactivateSentimentAnalysisResponse(RobotData data) {
        return data;
    }

}
