package com.besa.PwAAgent.agent.goals.action;

import com.besa.PwAAgent.db.model.PreferenciaXBaile;
import com.besa.PwAAgent.db.model.PreferenciaXCancion;

import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ServiceContext;
import rational.data.InfoData;

public class MusicoTerapiaContext extends ServiceContext{

    @Override
    public boolean update(InfoData arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public void setCancionActual(PreferenciaXCancion cancionSelected) {
    }

    public PreferenciaXCancion getCancionActual() {
        return null;
    }

    public boolean isEstaBailando() {
        return false;
    }

    public void setBaileActual(PreferenciaXBaile baileSelected) {
    }

    public PreferenciaXBaile getBaileActual() {
        return null;
    }

    public boolean isVideoHasEnded() {
        return false;
    }

    public String getRetroalimentacionValue() {
        return null;
    }

    public void feedbackActivity(Double respuestaRetroalimentacion) {
    }

}
