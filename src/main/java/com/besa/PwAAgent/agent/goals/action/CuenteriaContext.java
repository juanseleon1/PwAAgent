package com.besa.PwAAgent.agent.goals.action;

import com.besa.PwAAgent.db.model.Frase;
import com.besa.PwAAgent.db.model.PreferenciaXCuento;

import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ServiceContext;
import rational.data.InfoData;

public class CuenteriaContext extends ServiceContext{

    @Override
    public boolean update(InfoData arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public Frase getCuentoActual() {
        return null;
    }

    public int getIndexCuento() {
        return 0;
    }

    public void setIndexCuento(int i) {
    }

    public String getRetroalimentacionValue() {
        return null;
    }

    public void feedbackActivity(Double respuestaRetroalimentacion) {
    }

    public void setCuentoActual(PreferenciaXCuento cuentoSelected) {
    }

}
