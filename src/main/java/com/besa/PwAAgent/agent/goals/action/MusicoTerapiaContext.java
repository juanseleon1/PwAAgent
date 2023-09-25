package com.besa.PwAAgent.agent.goals.action;

import java.util.Map;

import com.besa.PwAAgent.db.model.PreferenciaXBaile;
import com.besa.PwAAgent.db.model.PreferenciaXCancion;

import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ServiceContext;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import rational.data.InfoData;

public class MusicoTerapiaContext extends ServiceContext {

    private PreferenciaXCancion cancionActual;
    private boolean estaBailando;
    private String retroalimentacionValue;
    private PreferenciaXBaile baileActual;
    private boolean videoEnded;

    public MusicoTerapiaContext() {
        super();
        estaBailando = false;
        videoEnded = false;
        cancionActual = null;
        baileActual = null;
        retroalimentacionValue = null;
    }

    @Override
    public boolean update(InfoData data) {
        boolean update = false;
        RobotData robotData = (RobotData) data;
        Map<String, ?> response = robotData.getParameters();
        if (response.containsKey("retroValue")) {
            retroalimentacionValue = (String) response.get("retroValue");
            update = true;
        }

        if (response.containsKey("finishAnim")) {
            estaBailando = (boolean) response.get("finishAnim");
        }

        if (response.containsKey("endVideo")) {
            videoEnded = (boolean) response.get("endVideo");
        }
        return update;

    }

    public void setCancionActual(PreferenciaXCancion cancionSelected) {
        this.cancionActual = cancionSelected;
    }

    public PreferenciaXCancion getCancionActual() {
        return cancionActual;
    }

    public boolean isEstaBailando() {
        return estaBailando;
    }

    public void setBaileActual(PreferenciaXBaile baileSelected) {
        this.baileActual = baileSelected;
    }

    public PreferenciaXBaile getBaileActual() {
        return baileActual;
    }

    public boolean isVideoHasEnded() {
        return videoEnded;
    }

    public String getRetroalimentacionValue() {
        return retroalimentacionValue;
    }

    public void feedbackActivity(Double respuestaRetroalimentacion) {
        //TODO in all contexts with feedback
    }

}
