package com.besa.PwAAgent.agent.tasks.Cuenteria;

import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ConversationContext;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.AgentEmotionalState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.EmotionalEvent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;
import java.util.HashMap;

import com.besa.PwAAgent.agent.goals.action.Cuenteria;
import com.besa.PwAAgent.agent.goals.action.CuenteriaContext;
import com.besa.PwAAgent.configuration.emotionalmodel.utils.EmotionalEventType;
import com.besa.PwAAgent.configuration.emotionalmodel.utils.EmotionalObjectType;
import com.besa.PwAAgent.configuration.emotionalmodel.utils.EmotionalSubjectType;
import com.besa.PwAAgent.db.model.Cuento;
import com.besa.PwAAgent.db.model.Frase;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

public class ReproducirCuento extends SRTask {

    private HashMap<String, Object> infoServicio = new HashMap<>();
    private String userName;

    public ReproducirCuento() {
    }

    @Override
    public void executeTask(Believes parameters) {
        BeliefAgent blvs = (BeliefAgent) parameters;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        userName = miPerfil.getNombre();
        ConversationContext convContext = blvs.getInteractionState().getCurrentConversation(currUser);
        CuenteriaContext cuenteriaContext = (CuenteriaContext) blvs.getServiceContext(Cuenteria.class);
        AgentEmotionalState emotionalState = blvs.getPsychologicalState().getAgentEmotionalState();

        if (!convContext.isRobotTalking()) {

            Cuento cuento = cuenteriaContext.getCuentoActual().getCuento();
            Frase frase = cuento.getFraseList().get(cuenteriaContext.getIndexCuento());
            if (!frase.getEmotionalEvent().trim().isEmpty()) {
                String emoEvt = frase.getEmotionalEvent();
                String[] emoPos = emoEvt.split("_");
                if (emoPos.length > 2) {
                    for (String emoPo : emoPos) {
                        ReportBESA.debug(emoPo);

                    }
                    EmotionalEvent evt = new EmotionalEvent(EmotionalSubjectType.getFromId(emoPos[0]).toString(),
                            EmotionalEventType.getFromId(emoPos[1]).toString(),
                            EmotionalObjectType.getFromId(emoPos[2]).toString());
                    emotionalState.processEmotionalEvent(evt);
                }
            } else {
                emotionalState.emotionalStateChanged();
            }

            infoServicio = new HashMap<>();
            infoServicio.put("content", frase.getContenido());
            sendActionRequest(infoServicio, "talk");
            convContext.setRobotTalking(true);

            if (!frase.getUrlImagen().trim().isEmpty()) {
                infoServicio = new HashMap<>();
                infoServicio.put("image", frase.getUrlImagen());
                sendActionRequest(infoServicio, "showImage");
            }

            if (!frase.getAccion().trim().isEmpty()) {
                infoServicio = new HashMap<>();
                infoServicio.put("animation", frase.getAccion());
                sendActionRequest(infoServicio, "runAnimationAction");
            }

            cuenteriaContext.setIndexCuento(cuenteriaContext.getIndexCuento() + 1);
        }
        ReportBESA.debug(
                "TOTAL Frase" + cuenteriaContext.getCuentoActual().getCuento().getFraseList().size());
        ReportBESA.debug("VA EN ESTA FRASE: " + cuenteriaContext.getIndexCuento());
        if (cuenteriaContext.getCuentoActual().getCuento().getFraseList().size() > cuenteriaContext.getIndexCuento()) {
            setTaskWaitingForExecution();
        }

    }

    @Override
    public void interruptTask(Believes believes) {
        super.interruptTask(believes);
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
        super.cancelTask(believes);
        ReportBESA.debug("--- Cancel Task Buscar Animaciones ---");
        BeliefAgent blvs = (BeliefAgent) believes;
        CuenteriaContext cuenteriaContext = (CuenteriaContext) blvs.getServiceContext(Cuenteria.class);
        cuenteriaContext.setIndexCuento(0);
    }

    @Override
    public boolean checkFinish(Believes believes) {
        BeliefAgent blvs = (BeliefAgent) believes;
        CuenteriaContext cuenteriaContext = (CuenteriaContext) blvs.getServiceContext(Cuenteria.class);
        String currUser = blvs.getActiveUsers().get(0);
        ConversationContext convContext = blvs.getInteractionState().getCurrentConversation(currUser);

        ReportBESA.debug(
                "TOTAL Frase" + cuenteriaContext.getCuentoActual().getCuento().getFraseList().size());
        ReportBESA.debug("VA EN ESTA FRASE: " + cuenteriaContext.getIndexCuento());
        if (!convContext.isRobotTalking() && cuenteriaContext.getCuentoActual().getCuento()
                .getFraseList().size() == cuenteriaContext.getIndexCuento()) {
            ReportBESA.debug("--- Se acabo ---");
            infoServicio = new HashMap<>();
            infoServicio.put("content", "El Fin. Cuentame si te gusto");
            infoServicio.put("style", "animated");
            sendActionRequest(infoServicio, "talk");
            infoServicio = new HashMap<>();
            sendActionRequest(infoServicio, "hideImage");
            return true;
        }
        return false;
    }

}
