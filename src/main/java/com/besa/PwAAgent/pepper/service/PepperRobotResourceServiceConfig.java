package com.besa.PwAAgent.pepper.service;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.services.robotresources.ResourceServiceConfig;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public class PepperRobotResourceServiceConfig extends ResourceServiceConfig{

    @Override
    public DataBESA translateOtherActionsToDataBesa(RobotData data) {
        throw new UnsupportedOperationException("Unimplemented method 'translateOtherActionsToDataBesa'");
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
    public RobotData translateLedColorAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "CHANGELEDCOLOR", data.getParams());

    }

    @Override
    public DataBESA translateLedColorActionResponse(RobotData data) {
        return data;
    }

    @Override
    public RobotData translateLedsOffAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "LEDSOFF", data.getParams());

    }

    @Override
    public DataBESA translateLedsOffActionResponse(RobotData data) {
        return data;
    }

    @Override
    public RobotData translateLedsOnAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "LEDSON", data.getParams());

    }

    @Override
    public DataBESA translateLedsOnActionResponse(RobotData data) {
        return data;
    }

    @Override
    public RobotData translateSuspendAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "SUSPEND", data.getParams());

    }

    @Override
    public DataBESA translateSuspendActionResponse(RobotData data) {
        return data;
    }

    @Override
    public RobotData translateWakeUpAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "WAKEUP", data.getParams());

    }

    @Override
    public DataBESA translateWakeUpActionResponse(RobotData data) {
        return data;
    }

}
