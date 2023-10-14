package com.besa.PwAAgent.agent.tasks.DarMedicamentos;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import com.besa.PwAAgent.agent.goals.action.DarMedicamentos;
import com.besa.PwAAgent.agent.goals.action.DarMedicamentosContext;
import com.besa.PwAAgent.db.model.userprofile.FranjaMedicamento;
import com.besa.PwAAgent.db.model.userprofile.PwAMedicalContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ConversationContext;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class RecordarSobreMedicamentos extends SRTask {

    @Override
    public void executeTask(Believes beliefs) {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        blvs.getInteractionState().setActiveService(DarMedicamentos.class.getName());
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        String userName = miPerfil.getNombre();
        PwAMedicalContext medicalContext = miPerfil.getUserMedicalContext();
        LocalTime now = LocalTime.now();
        DarMedicamentosContext darMedicamentosContext = (DarMedicamentosContext) blvs
                .getServiceContext(DarMedicamentos.class);
        ConversationContext convContext = blvs.getInteractionState().getCurrentConversation(currUser);

        FranjaMedicamento franja = null;

        for (FranjaMedicamento franjas : medicalContext.getFranjaMedicamentoList()) {
            if (now.isBefore(franjas.getHora().plusMinutes(10))) {
                franja = franjas;
            }
        }
        LocalTime horaActual = LocalTime.now();
        if (franja != null) {
            StringBuffer sb = new StringBuffer();
            sb.append("Oye ");
            sb.append(userName);
            sb.append(", son las ");
            sb.append(horaActual.getHour());
            sb.append("horas con");
            sb.append(horaActual.getMinute());
            sb.append("minutos");
            sb.append(", es hora de tomar tus medicamentos.");
            darMedicamentosContext.setCurrentFranja(franja);
            convContext.setRobotTalking(true);
            Map<String, Object> infoServicio = new HashMap<>();
            infoServicio.put("content", sb.toString());
            infoServicio.put("style", "animated");
            sendActionRequest(infoServicio, "talk");
        }

    }

    @Override
    public boolean checkFinish(Believes beliefs) {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        String currUser = blvs.getActiveUsers().get(0);
        ConversationContext convContext = blvs.getInteractionState().getCurrentConversation(currUser);
        return super.checkFinish(beliefs) && !convContext.isRobotTalking();
    }

}
