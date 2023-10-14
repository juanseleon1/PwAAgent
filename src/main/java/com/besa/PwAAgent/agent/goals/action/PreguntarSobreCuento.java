package com.besa.PwAAgent.agent.goals.action;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class PreguntarSobreCuento extends SRTask {

    @Override
    public void executeTask(Believes beliefs) {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        blvs.getInteractionState().setActiveService(Cuenteria.class.getName());
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        String userName = miPerfil.getNombre();
        StringBuffer sb = new StringBuffer();
        sb.append("Oye,");
        sb.append(userName);
        sb.append("¿Te esta gustando el cuento? ");
        sb.append("Cuentame tu parte favorita hasta ahora");
        Map<String, Object> infoServicio = new HashMap<>();
        infoServicio.put("style", "animated");
        infoServicio.put("content", sb.toString());
        sendActionRequest(infoServicio, "talk");
    }

    @Override
    public boolean checkFinish(Believes beliefs) {
        boolean hasEnded = false;
        BeliefAgent blvs = (BeliefAgent) beliefs;
        CuenteriaSupportContext context = (CuenteriaSupportContext) blvs.getServiceContext(CuenteriaSupport.class);
        if (super.checkFinish(beliefs)) {
            context.setWaitForAnswer(LocalTime.now());
            context.setDone(false);
            hasEnded = true;
        }
        return hasEnded || !context.canAsk();
    }

}
