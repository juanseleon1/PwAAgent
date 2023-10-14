package com.besa.PwAAgent.agent.goals.action;

import java.time.LocalTime;

import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ServiceContext;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import rational.data.InfoData;

public class CuenteriaSupportContext extends ServiceContext {

    private int currentLine;
    private int lastLine;
    private LocalTime waitForAnswer;
    private boolean isDone;
    private boolean canAsk;

    @Override
    public String captureRecordData() {
        return this.toString();
    }

    @Override
    public CuenteriaSupportContext clone() {
        CuenteriaSupportContext clone = new CuenteriaSupportContext();
        clone.currentLine = this.currentLine;
        clone.lastLine = this.lastLine;
        return clone;
    }

    @Override
    public boolean handleOtherData(InfoData data) {
        return false;
    }

    @Override
    public boolean handleRobotData(RobotData data) {
        return false;
    }

    @Override
    public String toString() {
        return "Contexto Preguntar Cuento\n Linea actual del cuento: " + currentLine + "\n Ultima linea del cuento: "
                + lastLine + "\n";
    }

    public int getCurrentLine() {
        return currentLine;
    }

    public void setCurrentLine(int currentLine) {
        this.currentLine = currentLine;
    }

    public int getLastLine() {
        return lastLine;
    }

    public void setLastLine(int lastLine) {
        this.lastLine = lastLine;
    }

    public void reset() {
        this.currentLine = 0;
        this.lastLine = 0;
        this.waitForAnswer = null;
    }

    public LocalTime getWaitForAnswer() {
        return waitForAnswer;
    }

    public void setWaitForAnswer(LocalTime waitForAnswer) {
        this.waitForAnswer = waitForAnswer;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public boolean canAsk() {
        return canAsk;
    }

    public void setCanAsk(boolean value) {
        this.canAsk = value;
    }

}
