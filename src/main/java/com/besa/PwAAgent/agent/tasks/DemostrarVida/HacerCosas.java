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
        String [] options = {"Hola Nelson", "Hola Hams", "Me quiero Morir", "Puedo hablar, pedazos de escroto"};
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
