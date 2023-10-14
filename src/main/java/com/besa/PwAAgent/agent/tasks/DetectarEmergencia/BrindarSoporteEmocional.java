package com.besa.PwAAgent.agent.tasks.DetectarEmergencia;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.besa.PwAAgent.agent.utils.RoleUtils;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ConversationContext;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class BrindarSoporteEmocional extends SRTask {

    private String userName;
    private Map<String, Object> infoServicio;
    private LocalTime horaActual;
    private LocalTime horaUltimoMensaje;

    @Override
    public void executeTask(Believes parameters) {
        BeliefAgent blvs = (BeliefAgent) parameters;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        ConversationContext convContext = blvs.getInteractionState().getCurrentConversation(currUser);
        userName = miPerfil.getNombre();
        Random random = new Random();
        String[] options = { "Tranquilo " + userName + ", todo estará bien. Ya viene tu cuidador.",
                "Tu cuidador esta en camino. No te afanes", "Respira Profundo, ya viene tu cuidador", ""};
        if (horaUltimoMensaje == null) {
            horaUltimoMensaje = LocalTime.now().minusMinutes(2);
            RoleUtils.setSadnessEmotionalAgentRole();
        }
        horaActual = LocalTime.now();
        Duration diff = Duration.between(horaUltimoMensaje, horaActual).abs();
        //ReportBESA.debug("Minutes difference: " + diff.toMinutes());
        if (!convContext.getLastMessage().equals("ya estoy aqui")) {
            if (diff.toSeconds() >= 20) {

                //ReportBESA.debug("Entra a brindar soporte emocional");
                horaUltimoMensaje = horaActual;
                int idx = random.nextInt(options.length);
                infoServicio = new HashMap<>();
                infoServicio.put("content", options[idx]);
                infoServicio.put("style", "animated");
                sendActionRequest(infoServicio, "talk");
                infoServicio = new HashMap<>();
                StringBuilder sb = new StringBuilder();
                sb.append("Tu paciente ");
                sb.append(userName);
                sb.append(" ");
                sb.append(miPerfil.getApellido());
                sb.append(" ha sufrido un accidente. Lo apoyaré mientras llegas.");
                infoServicio.put("message", sb.toString());
                infoServicio.put("priority", "ALERTA::");
                sendActionRequest(infoServicio, "sendMessageAction");
            }
            this.setTaskWaitingForExecution();
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
            sb.append("Me alegra que ya hayas llegado ");
            sb.append(miPerfil.getCuidadorNombreUsuario().getNombre());
            sb.append(". Dejame volver a la otra actividad.");
            infoServicio.put("content", sb.toString());
            infoServicio.put("style", "animated");
            sendActionRequest(infoServicio, "talk");
            //ReportBESA.debug("Last message: " + convContext.getLastMessage());
            horaActual = null;
            horaUltimoMensaje = null;
            RoleUtils.sendDefaultEmotionalAgentRole();
            blvs.getWorldModel().setAccidentOcurred(false);
            return true;
        }
        return false;
    }

}
