package com.besa.PwAAgent.pepper.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.besa.PwAAgent.pwa.PwAEmotionalModel.Emotion;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.Log.ReportBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.services.sensing.emotionextractor.EmotionExtractorServiceConfig;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.EmotionalDataType;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotion;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotionalData;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;
import rational.data.InfoData;

public class PepperEmotionExtractorServiceConfig extends EmotionExtractorServiceConfig {

    @Override
    public DataBESA translateOtherActionsToDataBesa(RobotData data) {
        return new InfoData("null");
    }

    @Override
    public RobotData translateOtherActionsToRobotData(ServiceDataRequest data) {
        return new RobotData(0, "null", "null", null);
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
        Map<String, Object> expression = (Map<String, Object>) ret.get("expressions");
        Map<String, Object> aux = null;

        aux = (Map<String, Object>) ret.get("attention");
        double atval = (double) aux.get("value");

        Map<String, Object> auxEmo = (Map<String, Object>) expression.get("joy");
        double joyval = (double) auxEmo.get("value");
        auxEmo = (Map<String, Object>) expression.get("sorrow");
        double sowval = (double) auxEmo.get("value");
        auxEmo = (Map<String, Object>) expression.get("anger");
        double angval = (double) auxEmo.get("value");
        auxEmo = (Map<String, Object>) expression.get("excitement");
        double excval = (double) auxEmo.get("value");
        auxEmo = (Map<String, Object>) expression.get("calm");
        double calmval = (double) auxEmo.get("value");
        auxEmo = (Map<String, Object>) expression.get("surprise");
        double surval = (double) auxEmo.get("value");
        auxEmo = (Map<String, Object>) expression.get("laughter");
        double lauval = (double) auxEmo.get("value");
        List<UserEmotion> emotions = new ArrayList<>();

        emotions.add(new UserEmotion(Emotion.calm.name(), calmval));
        emotions.add(new UserEmotion(Emotion.anger.name(), angval));
        emotions.add(new UserEmotion(Emotion.joy.name(), joyval));
        emotions.add(new UserEmotion(Emotion.sorrow.name(), sowval));
        emotions.add(new UserEmotion(Emotion.laughter.name(), lauval));
        emotions.add(new UserEmotion(Emotion.excitement.name(), excval));
        emotions.add(new UserEmotion(Emotion.surprise.name(), surval));
        emotions.add(new UserEmotion(Emotion.attention.name(), atval));
        //ReportBESA.debug("Emotions: " + emotions.size());

        return new UserEmotionalData(userID, EmotionalDataType.FACE, emotions);
    }

}
