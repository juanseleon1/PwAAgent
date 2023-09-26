package com.besa.PwAAgent.agent.goals.action;

import java.util.Map;

import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ServiceContext;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import rational.data.InfoData;

public class LeerBibliaContext extends ServiceContext{

    private String wordRecognized;
    private boolean quiereParar;

    @Override
    public boolean update(InfoData data) {
        boolean update = false;
        RobotData robotData = (RobotData) data;
        Map<String, ?> response = robotData.getParameters();
        if (response.containsKey("wordRecognized")) {
            wordRecognized = (String) response.get("retroValue");
            quiereParar = wordRecognized.equals("parar") || wordRecognized.equals("no mas");
            update = true;
        }
        return update;
    }

    public boolean getYaQuiereParar() {
        return quiereParar;
    }

    public String getWordRecognized() {
        return wordRecognized;
    }

    public void setWordRecognized(String wordRecognized) {
        this.wordRecognized = wordRecognized;
    }

    public boolean isQuiereParar() {
        return quiereParar;
    }

    public void setQuiereParar(boolean quiereParar) {
        this.quiereParar = quiereParar;
    }

    
    
}
