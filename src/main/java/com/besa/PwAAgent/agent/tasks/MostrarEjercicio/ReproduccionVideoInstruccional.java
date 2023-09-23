package com.besa.PwAAgent.agent.tasks.MostrarEjercicio;

import rational.mapping.Believes;
import java.util.HashMap;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;

public class ReproduccionVideoInstruccional extends SRTask {
    private HashMap<String, Object> infoServicio = new HashMap<>();
    private boolean b_Reproduccion; // Determina si el video se está reproduciendo.

    public ReproduccionVideoInstruccional() {
        System.out.println("--- DEBUG: Iniciado - Reproducción video instruccional. ---");
        b_Reproduccion = false;
    }

    @Override
    public void executeTask(Believes parameters) {
        System.out.println("--- DEBUG: Ejecutando - Reproducción video instruccional. ---");
        //BeliefAgent blvs = (BeliefAgent) parameters;
        if (!b_Reproduccion) {
            String urlVideo = "https://www.youtube.com/watch?v=tl8Esq9Oxpg&list=RDBYVOnEwbTMk&index=2";
            infoServicio.put("video", urlVideo);
            sendActionRequest(infoServicio, "showVideo");
            b_Reproduccion = true;
        }
    }

    @Override
    public void interruptTask(Believes believes) {
        infoServicio = new HashMap<>();
        infoServicio.put("stop", "");
        sendActionRequest(infoServicio, "pauseVideo");
    }

    @Override
    public void cancelTask(Believes believes) {
        infoServicio = new HashMap<>();
        infoServicio.put("stop", "");
        sendActionRequest(infoServicio, "quitVideo");
    }

    @Override
    public boolean checkFinish(Believes believes) {
        // TODO: Revisar si las repeticiones de ejercicios se ha terminado.
        return true;
    }
}
