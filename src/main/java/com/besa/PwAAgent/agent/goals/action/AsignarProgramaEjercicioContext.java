package com.besa.PwAAgent.agent.goals.action;

import java.util.List;

import com.besa.PwAAgent.db.model.ProgramaEjercicio;

import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ServiceContext;
import rational.data.InfoData;

public class AsignarProgramaEjercicioContext extends ServiceContext{

    private boolean existenPruebasEjercicio;
    private boolean cancelarProgramacionEjercicio;

    public void setExistenPruebasEjercicio(boolean b) {
        this.existenPruebasEjercicio = b;
    }

    public void setCancelarProgramacionEjercicio(boolean b) {
        this.cancelarProgramacionEjercicio = b;
    }

    @Override
    public boolean update(InfoData data) {
        return true;
    }

    public List<ProgramaEjercicio> getExercisePrograms() {
        return null;
    }

    public boolean getCancelarProgramacionEjercicio() {
        return cancelarProgramacionEjercicio;
    }

    public boolean isExistenPruebasEjercicio() {
        return existenPruebasEjercicio;
    }
}
