package com.besa.PwAAgent.pepper.service;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.InteractiveAgent.guard.InteractionEventData;
import BESA.SocialRobot.InteractiveAgent.guard.InteractionEventTypes;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.services.speech.speechengine.SpeechEngineServiceConfig;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public class PepperSpeechEngineServiceConfig extends SpeechEngineServiceConfig {

    @Override
    public DataBESA translateOtherActionsToDataBesa(RobotData data) {
        return data;
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
    public RobotData translateNoTalkAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "STOPALL", data.getParams());
    }

    @Override
    public InteractionEventData translateNoTalkResponse(RobotData data) {
        String userId = (String) data.getParameters().get("userID");
        return new InteractionEventData(userId, InteractionEventTypes.VOICE, data.getParameters());
    }

    @Override
    public RobotData translatePauseSoundAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "PAUSESOUND", data.getParams());

    }

    @Override
    public DataBESA translatePauseSoundResponse(RobotData data) {
        return data;
    }

    @Override
    public RobotData translatePlaySoundAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "PLAYSOUND", data.getParams());
    }

    @Override
    public DataBESA translatePlaySoundResponse(RobotData data) {
        return data;
    }

    @Override
    public RobotData translateTalkAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "SAY", data.getParams());
    }

    @Override
    public InteractionEventData translateTalkResponse(RobotData data) {
        String userId = (String) data.getParameters().get("userID");
        return new InteractionEventData(userId, InteractionEventTypes.VOICE, data.getParameters());
    }

    @Override
    public RobotData translateTalkVolumeAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "SETSAYVOLUMN", data.getParams());
    }

    @Override
    public DataBESA translateTalkVolumeResponse(RobotData data) {
        return data;
    }

}
