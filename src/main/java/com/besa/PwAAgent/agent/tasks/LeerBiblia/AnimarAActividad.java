package com.besa.PwAAgent.agent.tasks.LeerBiblia;

import java.util.HashMap;
import java.util.Map;

import com.besa.PwAAgent.agent.goals.action.LeerBiblia;
import com.besa.PwAAgent.db.model.userprofile.PwAPreferenceContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;
import com.besa.PwAAgent.db.model.userprofile.Religion;

import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ConversationContext;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class AnimarAActividad extends SRTask {

    private String userName;

    @Override
    public void executeTask(Believes believes) {
        // ReportBESA.debug("Ejecutando AnimarAActividad");
        BeliefAgent blvs = (BeliefAgent) believes;
        blvs.getInteractionState().setActiveService(LeerBiblia.class.getName());
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        userName = miPerfil.getNombre();
        StringBuffer sb = new StringBuffer();
        PwAPreferenceContext preferenceContext = miPerfil.getPwAPreferenceContext();
        Religion religion = preferenceContext.getReligion();
        sb.append("Oye,");
        sb.append(userName);
        sb.append(". Hace un buen tiempo que no lees tu libro favorito: ");
        sb.append(religion.getLibro());
        sb.append(". Te gustaria leer un versiculo? ¿O prefieres que hagamos una oracion?");
        Map<String, Object> infoServicio = new HashMap<>();
        infoServicio.put("content", sb.toString());
        sendActionRequest(infoServicio, "talk");
    }

    @Override
    public boolean checkFinish(Believes beliefs) {
        // ReportBESA.debug("Ejecutando checkFinish de AnimarAActividad");
        BeliefAgent blvs = (BeliefAgent) beliefs;
        String currUser = blvs.getActiveUsers().get(0);
        ConversationContext conversationState = blvs.getInteractionState().getCurrentConversation(currUser);
        String answer = conversationState.getLastMessage();
        // ReportBESA.debug("checkFinishSolicitarActividad: " + answer + "super: " +
        // super.checkFinish(beliefs));
        // ReportBESA.debug("has finished: " + (super.checkFinish(beliefs) &&
        // !answer.isEmpty()
        // && (answer.equals("oracion") || answer.equals("versiculo"))));
        return super.checkFinish(beliefs) && !answer.isEmpty()
                && (answer.equals("oracion") || answer.equals("versiculo"));
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
        sendActionRequest(infoServicio, "talk");
    }

    @Override
    public void cancelTask(Believes believes) {
        super.interruptTask(believes);
        Map<String, Object> infoServicio = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("Oh, espera");
        sb.append(userName);
        sb.append(", tenemos que hacer algo mas importante. Ya volvemos a la ejercitar tu espiritu.");
        infoServicio = new HashMap<>();
        infoServicio.put("content", sb.toString());
        infoServicio.put("style", "animated");
        sendActionRequest(infoServicio, "talk");
    }
}
