package com.besa.PwAAgent.other;

import com.besa.PwAAgent.agent.utils.TerminalUtils;

import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapter;

public class MessageAdapter extends SRAdapter {

    private TerminalUtils utils;

    public MessageAdapter(TerminalUtils utils) {
        this.utils = utils;
    }

    @Override
    public void sendRequest(RobotData data) {
        String msg = (String) data.getParameters().get("message");
        String category = (String) data.getParameters().get("category");
        double ack = (double) data.getId();

        switch (category.toUpperCase()) {
            case "NOTIFICATION":
                String priority = (String) data.getParameters().get("priority");
                utils.sendPriorityNotification(ack, priority, msg);
                break;
            case "PERMISSION":
                utils.processPermissionRequest(ack, msg);
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
