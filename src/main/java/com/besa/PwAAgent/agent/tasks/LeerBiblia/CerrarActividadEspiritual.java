package com.besa.PwAAgent.agent.tasks.LeerBiblia;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import com.besa.PwAAgent.agent.goals.action.LeerBiblia;
import com.besa.PwAAgent.agent.goals.action.LeerBibliaContext;
import com.besa.PwAAgent.db.model.userprofile.PwAPreferenceContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ConversationContext;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class CerrarActividadEspiritual extends SRTask {

    @Override
    public void executeTask(Believes believes) {
        BeliefAgent blvs = (BeliefAgent) believes;
        String currUser = blvs.getActiveUsers().get(0);
        ConversationContext conversationState = blvs.getInteractionState().getCurrentConversation(currUser);
        StringBuffer sb = new StringBuffer();
        String respuesta = conversationState.getLastMessage();
        // TODO: Agregar animacion segun emocion. Agregar impacto emocional.
        if (respuesta.equals("si")) {
            sb.append("¡Me alegra que te haya gustado!");
            sb.append("¡Que el Señor te bendiga!");
        } else {
            sb.append("Oh! Es una lastima, espero hacerlo mejor la proxima vez.");
        }
        Map<String, Object> infoServicio = new HashMap<>();
        infoServicio.put("content", sb.toString());
        sendActionRequest(infoServicio, "talk");
    }

    @Override
    public boolean checkFinish(Believes beliefs) {
        boolean shouldEnd = super.checkFinish(beliefs);
        ReportBESA.debug("Ejecutando checkFinish de CerrarActividadEspiritual");
        ReportBESA.debug("checkFinishCerrarActividad: " + shouldEnd);
        if (shouldEnd) {
            BeliefAgent blvs = (BeliefAgent) beliefs;
            String currUser = blvs.getActiveUsers().get(0);
            PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
            LeerBibliaContext context = (LeerBibliaContext) blvs.getServiceContext(LeerBiblia.class);
            context.setQuiereParar(true);
            PwAPreferenceContext preferenceContext = miPerfil.getPwAPreferenceContext();
            preferenceContext.setLastSpiritualActivity(LocalTime.now());
        }
        return shouldEnd;
    }

}