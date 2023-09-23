package com.besa.PwAAgent.agent.goals.action;

import java.util.List;

import com.besa.PwAAgent.db.model.ProgramaEjercicio;

import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ServiceContext;
import rational.data.InfoData;

public class AsignarProgramaEjercicioContext extends ServiceContext{

    public void setExistenPruebasEjercicio(boolean b) {
    }

    public void setCancelarProgramacionEjercicio(boolean b) {
    }

    @Override
    public boolean update(InfoData arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public List<ProgramaEjercicio> getExercisePrograms() {
        return null;
    }

}
