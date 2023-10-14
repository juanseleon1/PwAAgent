package com.besa.PwAAgent.agent.tasks.DemostrarVida;

import java.util.HashMap;
import java.util.Random;

import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class HacerCosas extends SRTask {
    private HashMap<String, Object> infoServicio = new HashMap<>();

    @Override
    public void executeTask(Believes beliefs) {
        Random random = new Random();
        //int caseId = random.nextInt(2);
        //String role = null;
        //switch (caseId) {
        //    case 0:
        //        //ReportBESA.debug("IT is Default Emotional Agent Role");
        //        role = "default";
        //        RoleUtils.sendDefaultEmotionalAgentRole();
        //        break;
        //        case 1:
        //        //ReportBESA.debug("IT is sadness Emotional Agent Role");
        //        role = "sadness";
        //        RoleUtils.setSadnessEmotionalAgentRole();
        //        break;
        //    }
        //try {
        //    wait(100);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        String[] options = {"Esta es una prueba", "Esta es otra prueba", "Esta es una prueba mas"};
        int idx = random.nextInt(options.length);
        infoServicio = new HashMap<>();
        infoServicio.put("content", options[idx]);
        infoServicio.put("style", "animated");
        sendActionRequest(infoServicio, "talk");
        infoServicio = new HashMap<>();
        infoServicio.put("animation", "Popurri");
        sendActionRequest(infoServicio, "runAnimationAction");
    }

}
