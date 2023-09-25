package com.besa.PwAAgent;

import com.besa.PwAAgent.pwa.PwAEmotionalModel;

import BESA.SocialRobot.UserEmotionalInterpreterAgent.agent.UserEmotionalInterpreterState;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.model.UserEmotionalModel;

public class PwAEmotionalInterpreterState extends UserEmotionalInterpreterState {

    @Override
    public UserEmotionalModel retrieveEmotionalModel(String id) {
        PwAEmotionalModel model = new PwAEmotionalModel();
        return model;
    }

}
