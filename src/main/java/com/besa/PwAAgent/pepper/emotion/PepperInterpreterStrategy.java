package com.besa.PwAAgent.pepper.emotion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.EmotionalEvent;
import BESA.SocialRobot.EmotionalInterpreterAgent.agent.EmotionalInterpreterStrategy;
import BESA.SocialRobot.EmotionalInterpreterAgent.guard.EmotionalData;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.agent.UserEmotionalInterpreterAgent;

public class PepperInterpreterStrategy implements EmotionalInterpreterStrategy {

    @Override
    public List<EmotionalEvent> processEvents(EmotionalData data) {
        List<EmotionalEvent> events = new ArrayList<>();
        String origin = data.getOrigin();
        String action = data.getAction();
        Map<String, Double> params = data.getEmoParams();

        if (origin.equals(UserEmotionalInterpreterAgent.name)) {
            double max = -1;
            String maxEmo = "";

            for (Entry<String, Double> entry : params.entrySet()) {
                if (entry.getValue() > max) {
                    maxEmo = entry.getKey();
                    max = entry.getValue();
                }
            }
            if(max!=0){
                EmotionalEvent event = new EmotionalEvent("user", action, maxEmo);
                events.add(event);
            }
        }

        return events;
    }

}
