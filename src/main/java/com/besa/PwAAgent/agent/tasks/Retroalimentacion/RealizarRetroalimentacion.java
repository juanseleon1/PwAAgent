package com.besa.PwAAgent.agent.tasks.Retroalimentacion;

import rational.mapping.Believes;
import java.util.HashMap;
import java.util.List;

import com.besa.PwAAgent.agent.utils.UserEvaluableContext;

import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ConversationContext;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;

public class RealizarRetroalimentacion extends SRTask {

    private HashMap<String, Object> infoServicio = new HashMap<>();
    private int num;
    private List<String> preguntas;
    private String intro;
    private int expectedAnswers;

    public RealizarRetroalimentacion(List<String> preguntas, String intro) {
        this.preguntas = preguntas;
        this.num = -1;
        this.expectedAnswers = -1;
        this.intro = intro;
    }

    @Override
    public void executeTask(Believes parameters) {
        BeliefAgent blvs = (BeliefAgent) parameters;
        String currUSer = blvs.getActiveUsers().get(0);
        ConversationContext convContext = blvs.getInteractionState().getCurrentConversation(currUSer);
        UserEvaluableContext activityContext = (UserEvaluableContext) blvs.getInteractionState()
                .getCurrentServiceContext();
        //ReportBESA.debug("num: " + num + " preguntas: " + preguntas.size() + " expectedAnswers: " + expectedAnswers
              //  + " retroValues: " + activityContext.getRetroValues().size());
        if (num == -1) {
            infoServicio = new HashMap<>();
            infoServicio.put("content", intro);
            convContext.setRobotTalking(true);
            sendActionRequest(infoServicio, "talk");
            num++;
            expectedAnswers++;
        } else if (!convContext.isRobotTalking() && num < preguntas.size()
                && activityContext.getRetroValues().size() == expectedAnswers) {

            infoServicio = new HashMap<>();
            infoServicio.put("content", preguntas.get(num));
            infoServicio.put("retro", true);
            convContext.setRobotTalking(true);
            sendActionRequest(infoServicio, "talk");
            num++;
            expectedAnswers++;
        }
    }

    @Override
    public boolean checkFinish(Believes believes) {
        BeliefAgent blvs = (BeliefAgent) believes;
        UserEvaluableContext activityContext = (UserEvaluableContext) blvs.getInteractionState()
                .getCurrentServiceContext();
        //ReportBESA.debug("num: " + num + " preguntas: " + preguntas.size() + " expectedAnswers: " + expectedAnswers
                //+ " retroValues: " + activityContext.getRetroValues().size());

        if (num >= preguntas.size() && activityContext.getRetroValues().size() == preguntas.size()) {
            return super.checkFinish(believes);
        } else {
            setTaskWaitingForExecution();
        }
        return false;
    }

}
