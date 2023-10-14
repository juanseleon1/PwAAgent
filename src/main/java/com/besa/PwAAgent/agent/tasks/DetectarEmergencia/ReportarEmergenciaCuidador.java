package com.besa.PwAAgent.agent.tasks.DetectarEmergencia;

import java.util.HashMap;

import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class ReportarEmergenciaCuidador extends SRTask {
    private HashMap<String, Object> infoServicio = new HashMap<>();
    private String userName;
    private boolean isFinished;

    @Override
    public void executeTask(Believes parameters) {
        BeliefAgent blvs = (BeliefAgent) parameters;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        userName = miPerfil.getNombre();
        StringBuilder sb = new StringBuilder();
        sb.append("¿Estas bien, ");
        sb.append(userName);
        sb.append("?");
        sb.append(" ¡Le avisaré a tu cuidador");
        sb.append(miPerfil.getCuidadorNombreUsuario().getNombre());
        sb.append("para que venga a ayudarnos!");

        infoServicio = new HashMap<>();
        infoServicio.put("content", sb.toString());
        sendActionRequest(infoServicio, "talk");
        infoServicio.put("style", "animated");

        infoServicio = new HashMap<>();
        sb = new StringBuilder();
        sb.append("Tu paciente ");
        sb.append(userName);
        sb.append(" ");
        sb.append(miPerfil.getApellido());
        sb.append(" ha sufrido un accidente. Lo apoyaré mientras llegas.");
        infoServicio.put("message", sb.toString());
        infoServicio.put("priority", "ALERTA::");
        sendActionRequest(infoServicio, "sendMessageAction");
    }

    @Override
    public boolean checkFinish(Believes beliefs) {
        if (super.checkFinish(beliefs) && !isFinished) {
            isFinished = true;
        }
        return isFinished;
    }
}
