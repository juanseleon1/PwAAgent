package com.besa.PwAAgent.agent.tasks.LeerBiblia;

import java.util.HashMap;
import java.util.Map;

import com.besa.PwAAgent.db.model.userprofile.PwAPreferenceContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;
import com.besa.PwAAgent.db.model.userprofile.Religion;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class AnimarAActividad extends SRTask {

    @Override
    public void executeTask(Believes believes) {
        BeliefAgent blvs = (BeliefAgent) believes;
        String currUser = blvs.getActiveUsers().get(0);
        String userName = blvs.getUserProfile(currUser).getUserContext().getSocioDemoContext().getName();
        StringBuffer sb = new StringBuffer();
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        PwAPreferenceContext preferenceContext = miPerfil.getPwAPreferenceContext();
        Religion religion = preferenceContext.getReligion();
        sb.append("Oye! ");
        sb.append(userName);
        sb.append("hace un buen tiempo que no lees tu libro favorito");
        sb.append(religion.getLibro());
        sb.append("te gustaria leer un versiculo? ¿O prefieres que hagamos una oracion?");
        Map<String, Object> infoServicio = new HashMap<>();
        infoServicio.put("content", sb.toString());
        infoServicio.put("origin", "hacerEspiritual");
        sendActionRequest(infoServicio, "talk");
    }

}
