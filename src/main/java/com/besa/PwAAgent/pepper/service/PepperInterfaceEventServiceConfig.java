package com.besa.PwAAgent.pepper.service;

import BESA.Kernel.Agent.Event.DataBESA;
import BESA.SocialRobot.HumanCooperationAgent.guard.InteractionAnswerData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.services.interfaces.interfaceevent.InterfaceEventServiceConfig;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public class PepperInterfaceEventServiceConfig extends InterfaceEventServiceConfig{

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
    protected InteractionAnswerData handleInterfaceEvent(RobotData data) {
        throw new UnsupportedOperationException("Unimplemented method 'handleInterfaceEvent'");
    }

    @Override
    protected RobotData translateActivateInterfaceAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "WAKETABLET", data.getParams());

    }

    @Override
    protected DataBESA translateActivateInterfaceResponse(RobotData data) {
        return data;
    }

    @Override
    protected RobotData translateChangeInterfacePropertiesAction(ServiceDataRequest data) {
        String changeStr = (String) data.getParams().get("changeParam");
        return new RobotData(data.getId(), data.getServiceName(), changeStr, data.getParams());

    }

    @Override
    protected DataBESA translateChangeInterfacePropertiesResponse(RobotData data) {
        return data;
    }

    @Override
    protected RobotData translateDeactivateInterfaceAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "SUSPENDTABLET", data.getParams());

    }

    @Override
    protected DataBESA translateDeactivateInterfaceResponse(RobotData data) {
        return data;
    }

    @Override
    protected RobotData translateHideImageAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "HIDEIMG", data.getParams());

    }

    @Override
    protected DataBESA translateHideImageResponse(RobotData data) {
        return data;

    }

    @Override
    protected RobotData translatePauseVideoAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "PAUSEVIDEO", data.getParams());

    }

    @Override
    protected DataBESA translatePauseVideoResponse(RobotData data) {
        return data;

    }

    @Override
    protected RobotData translateQuitVideoAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "QUITVIDEO", data.getParams());

    }

    @Override
    protected DataBESA translateQuitVideoActionResponse(RobotData data) {
        return data;

    }

    @Override
    protected RobotData translateResumeVideoAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "RESUMEVIDEO", data.getParams());

    }

    @Override
    protected DataBESA translateResumeVideoResponse(RobotData data) {
        return data;

    }

    @Override
    protected RobotData translateShowImageAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "SHOWIMG", data.getParams());

    }

    @Override
    protected DataBESA translateShowImageResponse(RobotData data) {
        return data;

    }

    @Override
    protected RobotData translateShowVideoAction(ServiceDataRequest data) {
        return new RobotData(data.getId(), data.getServiceName(), "SHOWVIDEO", data.getParams());

    }

    @Override
    protected DataBESA translateShowVideoResponse(RobotData data) {
        return data;

    }

}
