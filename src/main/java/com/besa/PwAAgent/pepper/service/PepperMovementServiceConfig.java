package com.besa.PwAAgent.pepper.service;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.services.robotstate.movement.MovementServiceConfig;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public class PepperMovementServiceConfig extends MovementServiceConfig{

    @Override
    public DataBESA translateOtherActionsToDataBesa(RobotData data) {
        return data;
    }

    @Override
    public RobotData translateOtherActionsToRobotData(ServiceDataRequest data) {
        throw new UnsupportedOperationException("Unimplemented method 'translateOtherActionsToRobotData'");
    }

    @Override
    public RobotData translateOtherCancelActionsToRobotData(ServiceDataRequest data) {
        throw new UnsupportedOperationException("Unimplemented method 'translateOtherCancelActionsToRobotData'");
    }

    @Override
    public RobotData translateDetectWorldModelAction(ServiceDataRequest data) {
               throw new UnsupportedOperationException("Unimplemented method 'translateDetectWorldModelAction'");
    }

    @Override
    public DataBESA translateDetectWorldModelResponse(RobotData data) {
        throw new UnsupportedOperationException("Unimplemented method 'translateDetectWorldModelResponse'");
    }

    @Override
    public RobotData translateMovementAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "MOVE", data.getParams());

    }

    @Override
    public DataBESA translateMovementResponse(RobotData data) {
        return data;
    }

    @Override
    public RobotData translateRunAnimationAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "RUNANIMATION", data.getParams());

    }

    @Override
    public DataBESA translateRunAnimationResponse(RobotData data) {
        return data;
    }

    @Override
    public RobotData translateStopAnimationAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "KILLALL", data.getParams());

    }

    @Override
    public DataBESA translateStopAnimationResponse(RobotData data) {
        return data;

    }

    @Override
    public RobotData translateStopMovementAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "KILLMOVE", data.getParams());

    }

    @Override
    public DataBESA translateStopMovementResponse(RobotData data) {
        return data;

    }

}
