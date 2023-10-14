package com.besa.PwAAgent.agent.goals.action;

import java.util.List;

import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ServiceContext;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import rational.data.InfoData;

public class LeerBibliaContext extends ServiceContext {

    private boolean quiereParar = false;
    private List<String> frases;
    private int index = 0;

    public boolean getYaQuiereParar() {
        return quiereParar;
    }

    public boolean isQuiereParar() {
        return quiereParar;
    }

    public void setQuiereParar(boolean quiereParar) {
        this.quiereParar = quiereParar;
    }

    @Override
    public LeerBibliaContext clone() {
        LeerBibliaContext cloned = new LeerBibliaContext();
        cloned.quiereParar = quiereParar;
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

    public List<String> getFrases() {
        return frases;
    }

    public void setFrases(List<String> frases) {
        this.frases = frases;
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
        return "Actividad Espiritual";
    }

    

}
