package com.besa.PwAAgent.other;

import java.util.List;

import com.besa.PwAAgent.agent.utils.TerminalUtils;

import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.request.Request;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapter;

public class MessageAdapter extends SRAdapter {

    private TerminalUtils utils;

    public MessageAdapter(TerminalUtils utils) {
        this.utils = utils;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sendRequest(RobotData data) {
        //ReportBESA.debug("DATA HERE: " + data);
        double ack = (double) data.getId();
        String category = (String) data.getParameters().get("category");

        switch (category.toUpperCase()) {
            case "NOTIFICATION":
                String msg = (String) data.getParameters().get("message");
                String priority = (String) data.getParameters().get("priority");
                utils.sendPriorityNotification(ack, priority, msg);
                break;
            case "PERMISSION":
                List<Request> permissions = (List<Request>) data.getParameters().get("requests");
                for (Request request : permissions) {
                    utils.processPermissionRequest(ack, request);
                }
                break;
        }
    }

    @Override
    public void setup() {

    }

    public TerminalUtils getUtils() {
        return utils;
    }

    public void setUtils(TerminalUtils utils) {
        this.utils = utils;
    }

}
