package com.besa.PwAAgent.agent.tasks.Cuenteria;



import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ConversationContext;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.AgentEmotionalState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.EmotionalEvent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;
import java.util.HashMap;
import com.besa.PwAAgent.agent.goals.Cuenteria;
import com.besa.PwAAgent.agent.goals.CuenteriaContext;
import com.besa.PwAAgent.configuration.emotionalmodel.utils.EmotionalEventType;
import com.besa.PwAAgent.configuration.emotionalmodel.utils.EmotionalObjectType;
import com.besa.PwAAgent.configuration.emotionalmodel.utils.EmotionalSubjectType;
import com.besa.PwAAgent.db.model.Cuento;
import com.besa.PwAAgent.db.model.Frase;


public class ReproducirCuento extends SRTask {

    private HashMap<String, Object> infoServicio = new HashMap<>();
    private long start = -1;
    private String userName;

    public ReproducirCuento() {
    }

    @Override
    public void executeTask(Believes parameters) {
        System.out.println("--- Execute Task Buscar Animaciones ---");
        
        BeliefAgent blvs = (BeliefAgent) parameters;
        String currUser = blvs.getActiveUsers().get(0);
        userName =  blvs.getUserProfile(currUser).getUserContext().getSocioDemoContext().getName();
        ConversationContext convContext = blvs.getInteractionState().getCurrentConversation(currUser);
        long now = System.currentTimeMillis();
        CuenteriaContext cuenteriaContext = (CuenteriaContext) blvs.getServiceContext(Cuenteria.class);
        AgentEmotionalState emotionalState = blvs.getPsychologicalState().getAgentEmotionalState();
        System.out.println("UNIT SECOND" + (now - start));
        System.out.println("START" + start);
        System.out.println("NOW" + now);

        if ((now - start > 3000 || start == -1) && !convContext.isRobotTalking()) {
            start = now;

            Cuento cuento = cuenteriaContext.getCuentoActual().getCuento();
            Frase frase = cuento.getFraseList().get(cuenteriaContext.getIndexCuento());
            if (!frase.getEmotionalEvent().isEmpty()) {
                String emoEvt = frase.getEmotionalEvent();
                String[] emoPos = emoEvt.split("_");
                if (emoPos.length > 2) {
                    for (String emoPo : emoPos) {
                        System.out.println(emoPo);

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

            if (!frase.getUrlImagen().isEmpty()) {
                infoServicio = new HashMap<>();
                infoServicio.put("image", frase.getUrlImagen());
                sendActionRequest(infoServicio, "showImage");
            }

            if (!frase.getAccion().isEmpty()) {
                infoServicio = new HashMap<>();
                infoServicio.put("animation", frase.getAccion());
                sendActionRequest(infoServicio, "runAnimationAction");
            }

            cuenteriaContext.setIndexCuento(cuenteriaContext.getIndexCuento() + 1);
        }
        System.out.println(
                "TOTAL Frase" + cuenteriaContext.getCuentoActual().getCuento().getFraseList().size());
        System.out.println("VA EN ESTA FRASE: " + cuenteriaContext.getIndexCuento());
        if (cuenteriaContext.getCuentoActual().getCuento().getFraseList().size() > cuenteriaContext.getIndexCuento()) {
            setTaskWaitingForExecution();
        }

    }

    @Override
    public void interruptTask(Believes believes) {
        super.interruptTask(believes);
        System.out.println("--- Interrupt Task Buscar Animaciones ---");
        StringBuilder sb = new StringBuilder();
        sb.append("Oh, espera");
        sb.append(userName);
        sb.append(", tenemos que hacer algo mas importante. Ya volvemos a continuar el cuento");
        infoServicio = new HashMap<>();
        infoServicio.put("content", sb.toString());
        sendActionRequest(infoServicio, "talk");
    }

    @Override
    public void cancelTask(Believes believes) {
        super.cancelTask(believes);
        System.out.println("--- Cancel Task Buscar Animaciones ---");
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

        System.out.println(
                "TOTAL Frase" + cuenteriaContext.getCuentoActual().getCuento().getFraseList().size());
        System.out.println("VA EN ESTA FRASE: " + cuenteriaContext.getIndexCuento());
        if (!convContext.isRobotTalking() && cuenteriaContext.getCuentoActual().getCuento()
                .getFraseList().size() == cuenteriaContext.getIndexCuento()) {
            System.out.println("--- Se acabo ---");
            infoServicio = new HashMap<>();
            infoServicio.put("content", "El Fin. Cuentame si te gusto");
            sendActionRequest(infoServicio, "talk");
            infoServicio = new HashMap<>();
            sendActionRequest(infoServicio, "hideImage");
            // TODO: Add topic mgmt.
            // ResPwaUtils.activateTopic(PepperTopicsNames.RETROCUENTOTOPIC, believes);
            return true;
        }
        return false;
    }

}
