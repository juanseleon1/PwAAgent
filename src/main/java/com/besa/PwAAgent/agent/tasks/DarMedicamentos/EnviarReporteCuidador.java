package com.besa.PwAAgent.agent.tasks.DarMedicamentos;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.besa.PwAAgent.agent.goals.action.DarMedicamentos;
import com.besa.PwAAgent.agent.goals.action.DarMedicamentosContext;
import com.besa.PwAAgent.db.model.userprofile.Dosis;
import com.besa.PwAAgent.db.model.userprofile.FranjaMedicamento;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.AgentEmotionalState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.EmotionalEvent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class EnviarReporteCuidador extends SRTask {

    @Override
    public void executeTask(Believes beliefs) {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        AgentEmotionalState state = blvs.getPsychologicalState().getAgentEmotionalState();
        String currUser = blvs.getActiveUsers().get(0);
        String userName = blvs.getUserProfile(currUser).getUserContext().getSocioDemoContext().getName();
        DarMedicamentosContext darMedicamentosContext = (DarMedicamentosContext) blvs
                .getServiceContext(DarMedicamentos.class);

        StringBuffer reporte = new StringBuffer();
        StringBuffer sb = new StringBuffer();
        String evento = null;
        Map<String, Object> infoServicio = new HashMap<>();
        reporte.append(userName);
        if (darMedicamentosContext.isConfirmacionMedicamentos()) {
            reporte.append("se tomo los medicamentos a las" + LocalTime.now().toString());
            sb.append(userName);
            sb.append("me alegra que te hayas tomado los medicamentos!");
            sendActionRequest(infoServicio, "talk");
            evento = "tomo";
        } else {
            reporte.append("no se tomo los medicamentos");
            sb.append(userName);
            sb.append("deberias tomarte los medicamentos!");
            evento = "no tomo";
        }
        EmotionalEvent event = new EmotionalEvent("usuario", evento, "medicamentos");
        state.processEmotionalEvent(event);
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        infoServicio.put("content", sb.toString());
        sendActionRequest(infoServicio, "talk");
        reporte.append("\n\n\n\n\n");

        FranjaMedicamento franja = darMedicamentosContext.getCurrentFranja();
        List<Dosis> medicamentos = franja.getDosis();
        medicamentos.forEach(dosis -> {
            reporte.append(dosis.getCantidad());
            reporte.append("miligramos de");
            reporte.append(dosis.getMedicamento());
        });
    }

    @Override
    public boolean checkFinish(Believes beliefs) {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        DarMedicamentosContext darMedicamentosContext = (DarMedicamentosContext) blvs
                .getServiceContext(DarMedicamentos.class);
        boolean shouldFinish = super.checkFinish(beliefs);
        if (shouldFinish) {
            darMedicamentosContext.setConfirmacionMedicamentos(false);
            darMedicamentosContext.setCurrentFranja(null);
            darMedicamentosContext.setWordRecognized(null);
        }
        return shouldFinish;
    }

}
