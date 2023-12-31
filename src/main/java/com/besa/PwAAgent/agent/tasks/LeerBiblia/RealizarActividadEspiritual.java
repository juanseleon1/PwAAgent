package com.besa.PwAAgent.agent.tasks.LeerBiblia;

import java.util.HashMap;
import java.util.Map;
import com.besa.PwAAgent.agent.goals.action.LeerBiblia;
import com.besa.PwAAgent.agent.goals.action.LeerBibliaContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;
import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ConversationContext;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class RealizarActividadEspiritual extends SRTask {

    private String userName;

    public RealizarActividadEspiritual() {
        super();
    }

    @Override
    public void executeTask(Believes believes) {
        BeliefAgent blvs = (BeliefAgent) believes;
        blvs.getInteractionState().setActiveService(LeerBiblia.class.getName());
        LeerBibliaContext leerBibliaContext = (LeerBibliaContext) blvs.getServiceContext(LeerBiblia.class);
        String currUser = blvs.getActiveUsers().get(0);
        ConversationContext convContext = blvs.getInteractionState().getCurrentConversation(currUser);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        userName = miPerfil.getNombre();
        Map<String, Object> infoServicio = new HashMap<>();

        if (!convContext.isRobotTalking()) {
            String frase = leerBibliaContext.getFrases().get(leerBibliaContext.getIndex());
            infoServicio.put("content", frase);
            infoServicio.put("style", "animated");
            sendActionRequest(infoServicio, "talk");
            convContext.setRobotTalking(true);
            leerBibliaContext.setIndex(leerBibliaContext.getIndex() + 1);
        }

        if (leerBibliaContext.getIndex() < leerBibliaContext.getFrases().size()) {
            setTaskWaitingForExecution();
        }
    }

    @Override
    public boolean checkFinish(Believes beliefs) {
        //ReportBESA.debug("Ejecutando checkFinish de RealizarActividadEspiritual");
        BeliefAgent blvs = (BeliefAgent) beliefs;
        String currUser = blvs.getActiveUsers().get(0);
        ConversationContext conversationState = blvs.getInteractionState().getCurrentConversation(currUser);
        String answer = conversationState.getLastMessage();
        //ReportBESA.debug("checkFinishRealizarActividad: " + answer + "super: " + super.checkFinish(beliefs));
        //ReportBESA.debug("has finished: "
                //+ (super.checkFinish(beliefs) && !answer.isEmpty() && (answer.equals("si") || answer.equals("no"))));
        LeerBibliaContext leerBibliaContext = (LeerBibliaContext) blvs.getServiceContext(LeerBiblia.class);

        return super.checkFinish(beliefs) && !answer.isEmpty() && (answer.equals("si") || answer.equals("no"))
                && leerBibliaContext.getIndex() == leerBibliaContext.getFrases().size();
    }

    @Override
    public void interruptTask(Believes believes) {
        super.interruptTask(believes);
        Map<String, Object> infoServicio = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("Oh, espera");
        sb.append(userName);
        sb.append(", tenemos que hacer algo mas importante. Ya volvemos a la ejercitar tu espiritu.");
        infoServicio = new HashMap<>();
        infoServicio.put("content", sb.toString());
        // infoServicio.put("style", "animated");
        sendActionRequest(infoServicio, "talk");
    }

    @Override
    public void cancelTask(Believes believes) {
        super.interruptTask(believes);
        // Map<String, Object> infoServicio = new HashMap<>();
        // //ReportBESA.debug("--- Cancel Task Buscar Animaciones ---");
        // StringBuilder sb = new StringBuilder();
        // sb.append("Oh, espera");
        // sb.append(userName);
        // sb.append(", tenemos que hacer algo mas importante. Ya volvemos a la
        // ejercitar tu espiritu.");
        // infoServicio = new HashMap<>();
        // infoServicio.put("content", sb.toString());
        // infoServicio.put("style", "animated");
        // sendActionRequest(infoServicio, "talk");
    }
}
