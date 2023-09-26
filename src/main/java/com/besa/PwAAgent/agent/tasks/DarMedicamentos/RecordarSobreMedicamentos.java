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
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class RecordarSobreMedicamentos extends SRTask {

    @Override
    public void executeTask(Believes beliefs) {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        PwAMedicalContext medicalContext = miPerfil.getUserMedicalContext();
        LocalTime now = LocalTime.now();
        String userName = blvs.getUserProfile(currUser).getUserContext().getSocioDemoContext().getName();
        DarMedicamentosContext darMedicamentosContext = (DarMedicamentosContext) blvs.getServiceContext(DarMedicamentos.class);

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

            Map<String, Object> infoServicio = new HashMap<>();
            infoServicio.put("content", sb.toString());
            sendActionRequest(infoServicio, "talk");
        }

    }

}
