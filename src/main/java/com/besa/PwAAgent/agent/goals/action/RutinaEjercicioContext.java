package com.besa.PwAAgent.agent.goals.action;

import java.util.ArrayList;
import java.util.List;

import com.besa.PwAAgent.db.model.Ejercicio;
import com.besa.PwAAgent.db.model.Historial;

import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ServiceContext;
import rational.data.InfoData;

public class RutinaEjercicioContext extends ServiceContext{
    List<Historial> currHistorialList;

    public RutinaEjercicioContext() {
        super();
        currHistorialList = new ArrayList<>();
    }

    @Override
    public boolean update(InfoData arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public List<Historial> getCurrHistorialList() {
        return currHistorialList;
    }

    public void setCurrEjercicios(List<Ejercicio> misEjercicios) {
    }

    public boolean isEstaMoviendo() {
        return false;
    }

}
