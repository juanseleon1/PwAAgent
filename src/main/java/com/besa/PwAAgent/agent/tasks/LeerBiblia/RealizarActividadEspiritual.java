package com.besa.PwAAgent.agent.tasks.LeerBiblia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.besa.PwAAgent.db.model.userprofile.PwAPreferenceContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;
import com.besa.PwAAgent.db.model.userprofile.Versiculo;

import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ConversationContext;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class RealizarActividadEspiritual extends SRTask {

    private String userName;

    @Override
    public void executeTask(Believes believes) {
        BeliefAgent blvs = (BeliefAgent) believes;
        String currUser = blvs.getActiveUsers().get(0);
        ConversationContext conversationState = blvs.getInteractionState().getCurrentConversation(currUser);
        StringBuffer sb = new StringBuffer();
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        userName = miPerfil.getNombre();
        PwAPreferenceContext preferenceContext = miPerfil.getPwAPreferenceContext();
        sb.append("Esta bien. Vamos a ");
        String respuesta = conversationState.getLastMessage();
        // TODO: Agregar animacion de oracion
        // TODO: Agregar grito de jubilo
        if (respuesta.equals("oracion")) {
            sb.append("hacer una oracion.");
            sb.append("Hagamoslo juntos!");
            sb.append(preferenceContext.getReligion().getOracion());
        } else {
            sb.append("leer un versiculo de ");
            sb.append(preferenceContext.getReligion().getLibro());
            List<Versiculo> versiculos = preferenceContext.getReligion().getVersiculos();
            Random random = new Random();
            int randomIndex = random.nextInt(versiculos.size());
            Versiculo versiculo = versiculos.get(randomIndex);
            sb.append(" en especifico ");
            sb.append(versiculo.getInformacion());
            sb.append(" dice ");
            sb.append(versiculo.getTexto());
        }
        sb.append(" ¿Te gusto? ");
        Map<String, Object> infoServicio = new HashMap<>();
        infoServicio.put("content", sb.toString());
        infoServicio.put("style", "animated");
        sendActionRequest(infoServicio, "talk");
    }

    @Override
    public boolean checkFinish(Believes beliefs) {
        ReportBESA.debug("Ejecutando checkFinish de RealizarActividadEspiritual");
        BeliefAgent blvs = (BeliefAgent) beliefs;
        String currUser = blvs.getActiveUsers().get(0);
        ConversationContext conversationState = blvs.getInteractionState().getCurrentConversation(currUser);
        String answer = conversationState.getLastMessage();
        ReportBESA.debug("checkFinishRealizarActividad: " + answer + "super: " + super.checkFinish(beliefs));
        ReportBESA.debug("has finished: "
                + (super.checkFinish(beliefs) && !answer.isEmpty() && (answer.equals("si") || answer.equals("no"))));
        return super.checkFinish(beliefs) && !answer.isEmpty() && (answer.equals("si") || answer.equals("no"));
    }

    @Override
    public void interruptTask(Believes believes) {
        super.interruptTask(believes);
        Map<String, Object> infoServicio = new HashMap<>();
        ReportBESA.debug("--- Interrupt Task Buscar Animaciones ---");
        StringBuilder sb = new StringBuilder();
        sb.append("Oh, espera");
        sb.append(userName);
        sb.append(", tenemos que hacer algo mas importante. Ya volvemos a continuar el cuento");
        infoServicio = new HashMap<>();
        infoServicio.put("content", sb.toString());
        infoServicio.put("style", "animated");
        sendActionRequest(infoServicio, "talk");
    }

    @Override
    public void cancelTask(Believes believes) {
        super.interruptTask(believes);
        Map<String, Object> infoServicio = new HashMap<>();
        ReportBESA.debug("--- Cancel Task Buscar Animaciones ---");
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
