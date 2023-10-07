package com.besa.PwAAgent.agent.tasks.DarMedicamentos;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.besa.PwAAgent.agent.goals.action.DarMedicamentos;
import com.besa.PwAAgent.agent.goals.action.DarMedicamentosContext;
import com.besa.PwAAgent.db.model.userprofile.Dosis;
import com.besa.PwAAgent.db.model.userprofile.FranjaMedicamento;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class EsperarConfirmacion extends SRTask {
    private LocalTime start = null;

    @Override
    public void executeTask(Believes beliefs) {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        String userName = miPerfil.getNombre();
        DarMedicamentosContext darMedicamentosContext = (DarMedicamentosContext) blvs
                .getServiceContext(DarMedicamentos.class);
        LocalTime now = LocalTime.now();
        FranjaMedicamento franja = darMedicamentosContext.getCurrentFranja();
        if (start == null) {
            start = LocalTime.now().minusMinutes(15);
        }
        Duration duration = Duration.between(start, now);
        long minutesDifference = duration.toMinutes();

        if (minutesDifference > 5 && darMedicamentosContext.getWordRecognized() != null) {
            start = now;
            StringBuffer sb = new StringBuffer();
            sb.append(userName);
            sb.append("no olvides que debes tomar los siguientes medicamentos");
            List<Dosis> medicamentos = franja.getDosis();

            medicamentos.forEach(dosis -> {
                sb.append(dosis.getCantidad());
                sb.append("miligramos de");
                sb.append(dosis.getMedicamento());
            });

            sb.append("Dime si, cuando te hayas tomado el medicamento. O dime no, si no te lo quieres tomar");
            Map<String, Object> infoServicio = new HashMap<>();
            infoServicio.put("content", sb.toString());
            infoServicio.put("style", "animated");
            sendActionRequest(infoServicio, "talk");
        }
    }

    @Override
    public boolean checkFinish(Believes beliefs) {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        DarMedicamentosContext darMedicamentosContext = (DarMedicamentosContext) blvs
                .getServiceContext(DarMedicamentos.class);
        boolean shouldFinish = super.checkFinish(beliefs) && darMedicamentosContext.getWordRecognized() != null;
        if (!shouldFinish) {
            setTaskWaitingForExecution();
        }
        return shouldFinish;
    }

}
