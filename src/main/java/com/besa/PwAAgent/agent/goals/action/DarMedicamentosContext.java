package com.besa.PwAAgent.agent.goals.action;

import java.util.List;

import com.besa.PwAAgent.db.model.userprofile.FranjaMedicamento;

import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ServiceContext;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import rational.data.InfoData;

public class DarMedicamentosContext extends ServiceContext {
    private boolean confirmacionMedicamentos;
    private FranjaMedicamento franja;
    private List<String> medicamentos;
    private int index;

    public DarMedicamentosContext() {
        super();
        confirmacionMedicamentos = false;
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

    @Override
    public DarMedicamentosContext clone() {
        DarMedicamentosContext cloned = new DarMedicamentosContext();
        cloned.confirmacionMedicamentos = confirmacionMedicamentos;
        cloned.franja = franja;
        return cloned;
    }

    @Override
    public boolean handleOtherData(InfoData arg0) {
        return false;
    }

    @Override
    public boolean handleRobotData(RobotData arg0) {
        return false;
    }

    public List<String> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<String> medicamentos) {
        this.medicamentos = medicamentos;
        this.index = 0;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String captureRecordData() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Contexto de Dar Medicamentos\n" +
                franja + "\n";
    }

    
    
}
