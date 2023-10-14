package com.besa.PwAAgent;

import BESA.SocialRobot.BDIAgent.BeliefAgent.WorldModel.AccidentData;
import BESA.SocialRobot.RiskDetectionAgent.agent.RawVideoData;
import BESA.SocialRobot.RiskDetectionAgent.agent.RiskDetectionAgentState;

public class PwARiskDetectionAgentState  extends RiskDetectionAgentState{

    @Override
    public AccidentData processVideoData(RawVideoData data) {
        AccidentData aData = new AccidentData();
        if(data.getParams().containsKey("accidentDetected")){
            aData.setHasAccident(true);
        }
        return aData;
    }

}
