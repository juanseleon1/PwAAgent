package com.besa.PwAAgent.agent.tasks.DetectarEmergencia;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ConversationContext;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class BrindarSoporteEmocional extends SRTask {

    private String userName;
    private Map<String, Object> infoServicio;

    @Override
    public void executeTask(Believes parameters) {
        BeliefAgent blvs = (BeliefAgent) parameters;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        ConversationContext convContext = blvs.getInteractionState().getCurrentConversation(currUser);
        userName = miPerfil.getNombre();
        Random random = new Random();
        String[] options = { "Tranquilo " + userName + ", todo estará bien. Ya viene tu cuidador.",
                "Aqui estoy, te ayudaré", "Tu cuidador esta en camino. No te afanes" };

        if (!convContext.getLastMessage().equals("ya estoy aqui")) {
            int idx = random.nextInt(options.length);
            infoServicio = new HashMap<>();
            infoServicio.put("content", options[idx]);
            infoServicio.put("style", "animated");
            sendActionRequest(infoServicio, "talk");
        } else {
            this.setTaskInExecution();
        }
    }

    @Override
    public boolean checkFinish(Believes beliefs) {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);

        ConversationContext convContext = blvs.getInteractionState().getCurrentConversation(currUser);

        if (convContext.getLastMessage().equals("ya estoy aqui")) {
            infoServicio = new HashMap<>();
            StringBuffer sb = new StringBuffer();
            sb.append("Me alegra que ya hayas llegado, ");
            sb.append(miPerfil.getCuidadorNombreUsuario().getNombre());
            infoServicio.put("content", sb.toString());
            infoServicio.put("style", "animated");
            sendActionRequest(infoServicio, "talk");
            return true;
        }
        return super.checkFinish(beliefs);
    }

}
