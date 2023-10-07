package com.besa.PwAAgent.agent.utils;

import BESA.Exception.ExceptionBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapterReceiver;
import BESA.SocialRobot.ServiceProvider.agent.guard.RobotReplyData;

public class MessageAdapterReceiver extends SRAdapterReceiver{

    @Override
    public void setup() {
    }

    public void sendReply(RobotReplyData data){
        try {
            this.handleRobotData(data);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }



}
