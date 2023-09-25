package com.besa.PwAAgent.agent.goals.action;

import java.util.Map;

import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ServiceContext;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import rational.data.InfoData;

public class DarMedicamentosContext extends ServiceContext{
    private boolean confirmacionMedicamentos;
    private String wordRecognized;

    @Override
    public boolean update(InfoData data) {
               boolean update = false;
        RobotData robotData = (RobotData) data;
        Map<String, ?> response = robotData.getParameters();
        if (response.containsKey("wordRecognized")) {
            wordRecognized = (String) response.get("retroValue");
            confirmacionMedicamentos= wordRecognized.equals("si");
            update = true;
        }
        return update;
    }


    public boolean isConfirmacionMedicamentos() {
        return confirmacionMedicamentos;
    }

    public void setConfirmacionMedicamentos(boolean confirmacionMedicamentos) {
        this.confirmacionMedicamentos = confirmacionMedicamentos;
    }   
}
