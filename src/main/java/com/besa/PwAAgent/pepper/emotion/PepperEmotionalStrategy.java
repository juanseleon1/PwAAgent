package com.besa.PwAAgent.pepper.emotion;

import java.util.HashMap;
import java.util.Map;

import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard.EmotionalStateData;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard.RobotEmotions;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.AgentEmotionalState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.RobotEmotionalStrategy;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.EmotionAxis;

public class PepperEmotionalStrategy implements RobotEmotionalStrategy {

    @Override
    public EmotionalStateData processEmotionsForRobot(AgentEmotionalState state) {
        EmotionalStateData emoData = null;
        try {
            Map<RobotEmotions, Double> emotions = new HashMap<>();
            EmotionAxis emotion = state.getMostActivatedEmotion();
            //ReportBESA.debug("ACTIVATED EMOTION "+ emotion);
            double currValue = emotion.getCurrentValue();
            String emotionName = currValue > 0 ? emotion.getPositiveName() : emotion.getNegativeName();
            emotions.put(RobotEmotions.valueOf(emotionName), currValue);
            emoData = new EmotionalStateData(emotions);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return emoData;
    }

}
