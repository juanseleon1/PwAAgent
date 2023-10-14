package com.besa.PwAAgent.agent.tasks.LeerBiblia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.besa.PwAAgent.agent.goals.action.LeerBiblia;
import com.besa.PwAAgent.agent.goals.action.LeerBibliaContext;
import com.besa.PwAAgent.db.model.userprofile.PwAPreferenceContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;
import com.besa.PwAAgent.db.model.userprofile.Versiculo;

import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ConversationContext;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class PrepararActividadEspiritual extends SRTask {

    private String userName;

    public PrepararActividadEspiritual() {
        super();
    }

    @Override
    public void executeTask(Believes believes) {
        BeliefAgent blvs = (BeliefAgent) believes;
        blvs.getInteractionState().setActiveService(LeerBiblia.class.getName());
        String currUser = blvs.getActiveUsers().get(0);
        ConversationContext conversationState = blvs.getInteractionState().getCurrentConversation(currUser);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        userName = miPerfil.getNombre();
        PwAPreferenceContext preferenceContext = miPerfil.getPwAPreferenceContext();
        List<String> toSay = new ArrayList<>();
        toSay.add("Esta bien.");
        String respuesta = conversationState.getLastMessage();
        if (respuesta.equals("oracion")) {
            toSay.add("Vamos a hacer una oracion.");
            toSay.add("Hagamoslo juntos!");
            String oracion = preferenceContext.getReligion().getOracion();
            String[] oracionSplit = oracion.split("\\|");
            for (String s : oracionSplit) {
                toSay.add(s);
            }
        } else {
            toSay.add("Vamos a leer un versiculo de " + preferenceContext.getReligion().getLibro());
            List<Versiculo> versiculos = preferenceContext.getReligion().getVersiculos();
            Random random = new Random();
            int randomIndex = random.nextInt(versiculos.size());
            Versiculo versiculo = versiculos.get(randomIndex);
            toSay.add(" en especifico " + versiculo.getInformacion() + " .");
            toSay.add("El versiculo dice ");
            String texto = versiculo.getTexto();
            String[] textoSplit = texto.split("\\|");
            for (String s : textoSplit) {
                toSay.add(s);
            }
        }
        toSay.add(" ¿Te gusto? ");
        //ReportBESA.debug("TOSAYYYYY:" + toSay);
        LeerBibliaContext leerBibliaContext = (LeerBibliaContext) blvs.getServiceContext(LeerBiblia.class);
        leerBibliaContext.setFrases(toSay);
    }

    @Override
    public boolean checkFinish(Believes beliefs) {
        //ReportBESA.debug("Ejecutando checkFinish de RealizarActividadEspiritual");
        BeliefAgent blvs = (BeliefAgent) beliefs;
        LeerBibliaContext leerBibliaContext = (LeerBibliaContext) blvs.getServiceContext(LeerBiblia.class);
        return super.checkFinish(beliefs) && leerBibliaContext.getFrases() != null;
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
        infoServicio.put("style", "animated");
        sendActionRequest(infoServicio, "talk");
    }

    @Override
    public void cancelTask(Believes believes) {
        super.interruptTask(believes);
        // Map<String, Object> infoServicio = new HashMap<>();
        // //ReportBESA.debug("--- Cancel Task Buscar Animaciones ---");
        // StringBuilder sb = new StringBuilder();
        // toSay.add("Oh, espera");
        // toSay.add(userName);
        // toSay.add(", tenemos que hacer algo mas importante. Ya volvemos a la
        // ejercitar tu espiritu.");
        // infoServicio = new HashMap<>();
        // infoServicio.put("content", sb.toString());
        // infoServicio.put("style", "animated");
        // sendActionRequest(infoServicio, "talk");
    }
}
