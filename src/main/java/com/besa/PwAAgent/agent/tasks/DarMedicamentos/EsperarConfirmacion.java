package com.besa.PwAAgent.agent.tasks.DarMedicamentos;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import com.besa.PwAAgent.agent.goals.action.DarMedicamentos;
import com.besa.PwAAgent.agent.goals.action.DarMedicamentosContext;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ConversationContext;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class EsperarConfirmacion extends SRTask {
    private LocalTime start = null;

    @Override
    public void executeTask(Believes beliefs) {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        blvs.getInteractionState().setActiveService(DarMedicamentos.class.getName());
        String currUser = blvs.getActiveUsers().get(0);
        ConversationContext convContext = blvs.getInteractionState().getCurrentConversation(currUser);
        DarMedicamentosContext darMedicamentosContext = (DarMedicamentosContext) blvs
                .getServiceContext(DarMedicamentos.class);
        LocalTime now = LocalTime.now();
        if (start == null) {
            start = LocalTime.now();
        }
        Duration duration = Duration.between(start, now).abs();
        long minutesDifference = duration.toMinutes();
        
        if (darMedicamentosContext.getIndex() >= darMedicamentosContext.getMedicamentos().size()) {
            if(minutesDifference > 5){
                start = now;
                darMedicamentosContext.setIndex(0);
            }
        }else if (!convContext.isRobotTalking()) {
            String frase = darMedicamentosContext.getMedicamentos().get(darMedicamentosContext.getIndex());
            Map<String, Object> infoServicio = new HashMap<>();
            infoServicio.put("content", frase);
            infoServicio.put("style", "animated");
            sendActionRequest(infoServicio, "talk");
            convContext.setRobotTalking(true);
            darMedicamentosContext.setIndex(darMedicamentosContext.getIndex() + 1);
        }


    }

    @Override
    public boolean checkFinish(Believes beliefs) {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        String currUser = blvs.getActiveUsers().get(0);
        ConversationContext convContext = blvs.getInteractionState().getCurrentConversation(currUser);

        boolean shouldFinish = super.checkFinish(beliefs)
                && (convContext.getLastMessage().equals("si") || convContext.getLastMessage().equals("no"))
                && !convContext.isRobotTalking();
        if (!shouldFinish) {
            setTaskWaitingForExecution();
        }
        return shouldFinish;
    }

}
