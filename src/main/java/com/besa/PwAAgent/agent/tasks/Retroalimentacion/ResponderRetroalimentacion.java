package com.besa.PwAAgent.agent.tasks.Retroalimentacion;

import java.util.HashMap;
import java.util.Map;

import com.besa.PwAAgent.agent.utils.UserEvaluableContext;
import com.besa.PwAAgent.pwa.PwAEmotionalModel;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.UserInteraction.UserInteractionState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.EmotionalEvent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class ResponderRetroalimentacion extends SRTask {
    private HashMap<String, Object> infoServicio;
    private HashMap<String, Object> animServicio;
    private boolean isFinished = false;

    public ResponderRetroalimentacion() {
    }

    @Override
    public void executeTask(Believes beliefs) {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        String userId = blvs.getActiveUsers().get(0);
        UserInteractionState intState = blvs.getInteractionState().getCurrentInteraction(userId);
        double emotions = processEmotionValence(intState.getUserEmotions());
        UserEvaluableContext serviceContext = (UserEvaluableContext) blvs.getInteractionState()
                .getCurrentServiceContext();
        String reaction = serviceContext.calculateFeedback(emotions, blvs);
        String event = null;
        if (reaction.equals("Positive")) {
            infoServicio = new HashMap<>();
            infoServicio.put("content", "¡Me alegra que te haya gustado!");
            animServicio = new HashMap<>();
            animServicio.put("tag", "happy");
            event = "liked";
        } else {
            infoServicio = new HashMap<>();
            infoServicio.put("content", "Espero hacerlo mejor la proxima vez");
            animServicio = new HashMap<>();
            animServicio.put("tag", "sad");
            event = "hates";
        }
        try {
            EmotionalEvent emoEvent = new EmotionalEvent("user", event, "activity");
            blvs.getPsychologicalState().getAgentEmotionalState().processEmotionalEvent(emoEvent);
            wait(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendActionRequest(infoServicio, "talk");
        sendActionRequest(animServicio, "runAnimationAction");
    }

    private double processEmotionValence(Map<String, Double> userEmotions) {
        double valence = 0;

        for (PwAEmotionalModel.Emotion emotion : PwAEmotionalModel.Emotion.values()) {
            if (userEmotions.containsKey(emotion.toString())) {
                if (emotion.equals(PwAEmotionalModel.Emotion.joy)
                        || emotion.equals(PwAEmotionalModel.Emotion.excitement)
                        || emotion.equals(PwAEmotionalModel.Emotion.laughter)) {
                    valence += userEmotions.get(emotion.toString());
                } else if (emotion.equals(PwAEmotionalModel.Emotion.anger)
                        || emotion.equals(PwAEmotionalModel.Emotion.sorrow)) {
                    valence -= userEmotions.get(emotion.toString());
                }
            }
        }
        return valence;
    }

    @Override
    public boolean checkFinish(Believes beliefs) {
        if(super.checkFinish(beliefs) && !isFinished){
            isFinished = true;
        }
        return isFinished;
    }


}