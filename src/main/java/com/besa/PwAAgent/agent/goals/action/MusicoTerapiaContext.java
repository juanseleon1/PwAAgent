package com.besa.PwAAgent.agent.goals.action;

import java.util.Map;

import com.besa.PwAAgent.agent.utils.UserEvaluableContext;
import com.besa.PwAAgent.db.model.PreferenciaXBaile;
import com.besa.PwAAgent.db.model.PreferenciaXCancion;

import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import rational.data.InfoData;

public class MusicoTerapiaContext extends UserEvaluableContext {

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

        if (response.containsKey("animationEnded")) {
            estaBailando = !(boolean) response.get("animationEnded");
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

    @Override
    public MusicoTerapiaContext clone() {
        MusicoTerapiaContext cloned = new MusicoTerapiaContext();
        cloned.estaBailando = estaBailando;
        cloned.cancionActual = cancionActual == null ? cancionActual
                : new PreferenciaXCancion(cancionActual.getPreferenciaXCancionPK());
        cloned.baileActual = baileActual == null ? baileActual
                : new PreferenciaXBaile(baileActual.getPreferenciaXBailePK());
        return cloned;
    }

    public void setEstaBailando(boolean estaBailando) {
        this.estaBailando = estaBailando;
    }

    public void setRetroalimentacionValue(String retroalimentacionValue) {
        this.retroalimentacionValue = retroalimentacionValue;
    }

    public boolean isVideoEnded() {
        return videoEnded;
    }

    public void setVideoEnded(boolean videoEnded) {
        this.videoEnded = videoEnded;
    }

    @Override
    public void updateTasteForRelatedObjs(double factor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTasteForRelatedObjs'");
    }


    
}
