package com.besa.PwAAgent.agent.tasks.Retroalimentacion;

import rational.mapping.Believes;
import java.util.HashMap;
import java.util.List;

import com.besa.PwAAgent.agent.utils.UserEvaluableContext;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ConversationContext;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;

public class RealizarRetroalimentacion extends SRTask {

    private HashMap<String, Object> infoServicio = new HashMap<>();
    private int num;
    private List<String> preguntas;

    public RealizarRetroalimentacion(List<String> preguntas) {
        this.preguntas = preguntas;
        this.num = -1;
    }

    @Override
    public void executeTask(Believes parameters) {
        BeliefAgent blvs = (BeliefAgent) parameters;
        String currUSer = blvs.getActiveUsers().get(0);
        ConversationContext convContext = blvs.getInteractionState().getCurrentConversation(currUSer);
        if (!convContext.isRobotTalking() && num < preguntas.size()) {
            if (num == -1) {
                infoServicio = new HashMap<>();
                infoServicio.put("content", "Ahora que finalizamos la actividad, me gustaria preguntarte si te gusto.");
                convContext.setRobotTalking(true);
                sendActionRequest(infoServicio, "talk");
                num++;
            }
            else {
                 infoServicio = new HashMap<>();
                infoServicio.put("content", preguntas.get(num));
                infoServicio.put("retro", true);
                convContext.setRobotTalking(true);
                sendActionRequest(infoServicio, "talk");
                num++;
            }
        }
    }

    @Override
    public boolean checkFinish(Believes believes) {
        BeliefAgent blvs = (BeliefAgent) believes;
        UserEvaluableContext context = (UserEvaluableContext) blvs.getInteractionState().getCurrentServiceContext();
        if (num >= preguntas.size() && context.getRetroValues().size() == preguntas.size()) {
            num = -1;
            return true;
        } else {
            setTaskWaitingForExecution();
            return false;
        }
    }

}
