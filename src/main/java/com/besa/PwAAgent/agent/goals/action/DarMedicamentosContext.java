package com.besa.PwAAgent.agent.goals.action;

import java.util.Map;

import com.besa.PwAAgent.db.model.userprofile.FranjaMedicamento;

import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ServiceContext;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import rational.data.InfoData;

public class DarMedicamentosContext extends ServiceContext {
    private boolean confirmacionMedicamentos;
    private String wordRecognized;
    private FranjaMedicamento franja;

    public DarMedicamentosContext() {
        super();
        confirmacionMedicamentos = false;
        wordRecognized = "";
    }

    @Override
    public boolean update(InfoData data) {
        boolean update = false;
        RobotData robotData = (RobotData) data;
        Map<String, ?> response = robotData.getParameters();
        if (response.containsKey("wordRecognized")) {
            wordRecognized = (String) response.get("wordRecognized");
            confirmacionMedicamentos = wordRecognized.equals("si");
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

    public void setCurrentFranja(FranjaMedicamento franja) {
        this.franja = franja;
    }

    public FranjaMedicamento getCurrentFranja() {
        return franja;
    }

    public String getWordRecognized() {
        return wordRecognized;
    }

    public void setWordRecognized(String wordRecognized) {
        this.wordRecognized = wordRecognized;
    }

    @Override
    public DarMedicamentosContext clone() {
        DarMedicamentosContext cloned = new DarMedicamentosContext();
        cloned.confirmacionMedicamentos = confirmacionMedicamentos;
        cloned.wordRecognized = wordRecognized;
        cloned.franja = franja;
        return cloned;
    }
}
