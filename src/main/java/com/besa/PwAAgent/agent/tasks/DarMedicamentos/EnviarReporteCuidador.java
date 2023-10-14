package com.besa.PwAAgent.agent.tasks.DarMedicamentos;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.besa.PwAAgent.agent.goals.action.DarMedicamentos;
import com.besa.PwAAgent.agent.goals.action.DarMedicamentosContext;
import com.besa.PwAAgent.agent.utils.RoleUtils;
import com.besa.PwAAgent.db.model.userprofile.Dosis;
import com.besa.PwAAgent.db.model.userprofile.FranjaMedicamento;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ConversationContext;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.AgentEmotionalState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.EmotionalModel.EmotionalEvent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class EnviarReporteCuidador extends SRTask {

    @Override
    public void executeTask(Believes beliefs) {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        blvs.getInteractionState().setActiveService(DarMedicamentos.class.getName());
        AgentEmotionalState state = blvs.getPsychologicalState().getAgentEmotionalState();
        String currUser = blvs.getActiveUsers().get(0);
        ConversationContext convContext = blvs.getInteractionState().getCurrentConversation(currUser);
        if (!convContext.getLastMessage().equals("si")) {
            //ReportBESA.debug("I AM ANGRYYYYY");
            RoleUtils.setSadnessEmotionalAgentRole();
        }

        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        String userName = miPerfil.getNombre();
        DarMedicamentosContext darMedicamentosContext = (DarMedicamentosContext) blvs
                .getServiceContext(DarMedicamentos.class);

        StringBuffer reporte = new StringBuffer();
        StringBuffer sb = new StringBuffer();
        String evento = null;
        Map<String, Object> infoServicio = new HashMap<>();
        reporte.append(userName);
        if (convContext.getLastMessage().equals("si")) {
            reporte.append("se tomo los medicamentos a las" + LocalTime.now().toString());
            sb.append(userName);
            sb.append(", me alegra que te hayas tomado los medicamentos!");
            infoServicio.put("style", "animated");
            evento = "took";
        } else {
            reporte.append("no se tomo los medicamentos");
            sb.append(userName);
            sb.append(", deberias tomarte los medicamentos!");
            evento = "notook";
        }
        EmotionalEvent event = new EmotionalEvent("user", evento, "medicine");
        state.processEmotionalEvent(event);
        try {
            wait(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reporte.append("\n\n\n\n\n");

        FranjaMedicamento franja = darMedicamentosContext.getCurrentFranja();
        List<Dosis> medicamentos = franja.getDosis();
        medicamentos.forEach(dosis -> {
            reporte.append(dosis.getCantidad());
            reporte.append("miligramos de");
            reporte.append(dosis.getMedicamento());
        });
        infoServicio.put("content", sb.toString());
        sendActionRequest(infoServicio, "talk");
    }

    @Override
    public boolean checkFinish(Believes beliefs) {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        DarMedicamentosContext darMedicamentosContext = (DarMedicamentosContext) blvs
                .getServiceContext(DarMedicamentos.class);
        boolean shouldFinish = super.checkFinish(beliefs);
        //ReportBESA.debug("IS OUT. SHOULD FINISH  " + shouldFinish);

        if (shouldFinish) {
            RoleUtils.sendDefaultEmotionalAgentRole();
            //ReportBESA.debug("IS OUT. SHOULD FINISH");
            FranjaMedicamento franja = darMedicamentosContext.getCurrentFranja();
            if (franja != null) {
                franja.setDone(true);
            }
            darMedicamentosContext.setCurrentFranja(null);
            darMedicamentosContext.setMedicamentos(null);
        }

        return shouldFinish;
    }

    
}
