package com.besa.PwAAgent.agent.goals.action;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class EsperarRespuesta extends SRTask {

    @Override
    public void executeTask(Believes believes) {
        BeliefAgent blvs = (BeliefAgent) believes;
        CuenteriaSupportContext context = (CuenteriaSupportContext) blvs.getServiceContext(CuenteriaSupport.class);
        if (context.getWaitForAnswer() != null
                && !context.getWaitForAnswer().plusSeconds(10).isBefore(LocalTime.now())) {
            this.setTaskWaitingForExecution();
        } else if(context.getWaitForAnswer() != null){
            context.setDone(true);
            StringBuilder sb = new StringBuilder();
            sb.append("¡Ya veo, que interesante! Dejame volver al cuento");
            Map<String, Object> infoServicio = new HashMap<>();
            infoServicio.put("style", "animated");
            infoServicio.put("content", sb.toString());
            sendActionRequest(infoServicio, "talk");
        }

    }

    @Override
    public boolean checkFinish(Believes beliefs) {
        boolean hasEnded = false;
        BeliefAgent blvs = (BeliefAgent) beliefs;
        CuenteriaSupportContext context = (CuenteriaSupportContext) blvs.getServiceContext(CuenteriaSupport.class);
        if (context.getWaitForAnswer() != null
                && context.getWaitForAnswer().plusSeconds(10).isBefore(LocalTime.now())) {
            if (super.checkFinish(beliefs) && context.isDone()) {
                context.setLastLine(context.getCurrentLine());
                context.setWaitForAnswer(null);
                context.setCanAsk(false);
                hasEnded = true;
            }
        }
        return hasEnded;
    }

}
