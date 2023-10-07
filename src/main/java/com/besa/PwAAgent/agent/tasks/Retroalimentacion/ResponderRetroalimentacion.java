package com.besa.PwAAgent.agent.tasks.Retroalimentacion;

import java.util.HashMap;
import java.util.Map;

import com.besa.PwAAgent.agent.utils.UserEvaluableContext;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.UserInteraction.UserInteractionState;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class ResponderRetroalimentacion extends SRTask {
    private HashMap<String, Object> infoServicio;

    public ResponderRetroalimentacion() {
    }

    @Override
    public void executeTask(Believes beliefs) {
        BeliefAgent blvs =(BeliefAgent) beliefs;
        String userId = blvs.getActiveUsers().get(0);
        UserInteractionState intState = blvs.getInteractionState().getCurrentInteraction(userId);
        double emotions = processEmotionValence(intState.getUserEmotions());
        UserEvaluableContext serviceContext = (UserEvaluableContext) blvs.getInteractionState().getCurrentServiceContext();
        String reaction = serviceContext.calculateFeedback(emotions);

        if (reaction.equals("Positive")) {
            infoServicio = new HashMap<>();
            infoServicio.put("content", "¡Me alegra que ye haya gustado!");
            sendActionRequest(infoServicio, "talk");
            infoServicio = new HashMap<>();
            infoServicio.put("animation", "Popurri"); //TODO: add happy action. Add eventos emocionales.
            sendActionRequest(infoServicio, "runAnimationAction");
        } else {
            infoServicio = new HashMap<>();
            infoServicio.put("content", "Espero hacerlo mejor la proxima vez");
            sendActionRequest(infoServicio, "talk");
            infoServicio = new HashMap<>();
            infoServicio.put("animation", "Popurri");
            sendActionRequest(infoServicio, "runAnimationAction");
        }
    }

    private double processEmotionValence(Map<String, Double> userEmotions) {
        //TODO:
        return 0;
    }

}
