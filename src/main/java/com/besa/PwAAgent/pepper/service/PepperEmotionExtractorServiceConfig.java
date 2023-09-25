package com.besa.PwAAgent.pepper.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.besa.PwAAgent.pwa.PwAEmotionalModel.Emotion;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.services.sensing.emotionextractor.EmotionExtractorServiceConfig;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.EmotionalDataType;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotion;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotionalData;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public class PepperEmotionExtractorServiceConfig extends EmotionExtractorServiceConfig {

    @Override
    public DataBESA translateOtherActionsToDataBesa(RobotData data) {
        throw new UnsupportedOperationException("Unimplemented method 'translateOtherActionsToDataBesa'");
    }

    @Override
    public RobotData translateOtherActionsToRobotData(ServiceDataRequest data) {
        throw new UnsupportedOperationException("Unimplemented method 'translateOtherActionsToRobotData'");
    }

    @Override
    public RobotData translateGetUserEmotionsAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "GETEMOTIONSTATE", data.getParams());
    }

    @Override
    @SuppressWarnings("unchecked")
    public UserEmotionalData translateGetUserEmotionsResponse(RobotData data) {
        String userID = (String) data.getParameters().get("userID");
        Map<String, Object> ret = (Map<String, Object>) data.getParameters().get("PersonData");
        Map<String, Object> aux = (Map<String, Object>) ret.get("expressions");

        Map<String, Object> auxEmo = (Map<String, Object>) aux.get("joy");
        float joyval = (float) auxEmo.get("value");
        auxEmo = (Map<String, Object>) aux.get("sorrow");
        float sowval = (float) auxEmo.get("value");
        auxEmo = (Map<String, Object>) aux.get("anger");
        float angval = (float) auxEmo.get("value");
        aux = (Map<String, Object>) ret.get("attention");
        float atval = (float) aux.get("confidence") * (float) aux.get("value");
        auxEmo = (Map<String, Object>) aux.get("excitement");
        float excval = (float) auxEmo.get("value");
        auxEmo = (Map<String, Object>) aux.get("calm");
        float calmval = (float) auxEmo.get("value");
        auxEmo = (Map<String, Object>) aux.get("surprise");
        float surval = (float) auxEmo.get("value");
        auxEmo = (Map<String, Object>) aux.get("laughter");
        float lauval = (float) auxEmo.get("value");
        List<UserEmotion> emotions = new ArrayList<>();

        emotions.add(new UserEmotion(Emotion.calm.name(), calmval));
        emotions.add(new UserEmotion(Emotion.anger.name(), angval));
        emotions.add(new UserEmotion(Emotion.joy.name(), joyval));
        emotions.add(new UserEmotion(Emotion.sorrow.name(), sowval));
        emotions.add(new UserEmotion(Emotion.laughter.name(), lauval));
        emotions.add(new UserEmotion(Emotion.excitement.name(), excval));
        emotions.add(new UserEmotion(Emotion.surprise.name(), surval));
        emotions.add(new UserEmotion(Emotion.attention.name(), atval));

        return new UserEmotionalData(userID, EmotionalDataType.FACE, emotions);
    }

}
