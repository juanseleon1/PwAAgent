package com.besa.PwAAgent.agent.tasks.MusicoTerapia;


import rational.mapping.Believes;
import java.util.HashMap;
import java.util.List;

import com.besa.PwAAgent.agent.goals.MusicoTerapia;
import com.besa.PwAAgent.agent.goals.MusicoTerapiaContext;
import com.besa.PwAAgent.db.model.PreferenciaXBaile;
import com.besa.PwAAgent.db.model.userprofile.PwAPreferenceContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;
import com.besa.PwAAgent.utils.personalization.CromosomaBaile;
import com.besa.PwAAgent.utils.personalization.ModeloSeleccion;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;


public class ReproduccionCancion extends SRTask {

    private HashMap<String, Object> infoServicio = new HashMap<>();
    private boolean envioVideo;
    private long start = -1;
    private String userName;

    public ReproduccionCancion() {
//        System.out.println("--- Task Busqueda Cancion Iniciada ---");
        envioVideo = false;

    }

    @Override
    public void executeTask(Believes parameters) {
        System.out.println("--- Execute Task Reproducir Cancion ---");
        BeliefAgent blvs = (BeliefAgent) parameters;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        userName =  miPerfil.getUserContext().getSocioDemoContext().getName();
        PwAPreferenceContext prefContext = (PwAPreferenceContext) miPerfil.getUserContext().getPreferenceContext();
        MusicoTerapiaContext musicoterapiaContext = (MusicoTerapiaContext) blvs.getServiceContext(MusicoTerapia.class);


        List<PreferenciaXBaile> bailes = prefContext.getPreferenciaXBaileList();
        long now = System.currentTimeMillis();

        if ((now - start > 3000 || start == -1) && !musicoterapiaContext.isEstaBailando()) {
            start = now;

            infoServicio = new HashMap<>();
            ModeloSeleccion<PreferenciaXBaile> modeloBaile = new ModeloSeleccion<PreferenciaXBaile>(bailes);
            PreferenciaXBaile baileSelected = null;
            CromosomaBaile cromosoma = null;
            cromosoma = (CromosomaBaile) modeloBaile.selectCromosoma();
            if (cromosoma != null && !musicoterapiaContext.isEstaBailando()) {
                baileSelected = cromosoma.getBaile();
                musicoterapiaContext.setBaileActual(baileSelected);
                infoServicio = new HashMap<>();
                infoServicio.put("animation", musicoterapiaContext.getBaileActual().getBaile().getNombre());
                sendActionRequest(infoServicio, "runAnimationAction");
            }
        }

        if (!envioVideo) {
            String urlcancion = musicoterapiaContext.getCancionActual().getCancion().getUrl();
            infoServicio = new HashMap<>();
            infoServicio.put("video", urlcancion);
            sendActionRequest(infoServicio, "showVideo");
            envioVideo = true;
        }

    }

    @Override
    public void interruptTask(Believes believes) {
        super.interruptTask(believes);
        BeliefAgent blvs = (BeliefAgent) believes;
        MusicoTerapiaContext musicoterapiaContext = (MusicoTerapiaContext) blvs.getServiceContext(MusicoTerapia.class);
        System.out.println("--- Interrupt Task Seleccionar Cancion ---");
        StringBuilder sb = new StringBuilder();
        sb.append("Oh, espera");
        sb.append(userName);
        sb.append(", tenemos que hacer algo mas importante. Ya vuelvo a ponerte ");
        sb.append(musicoterapiaContext.getCancionActual().getCancion().getNombre());
        infoServicio = new HashMap<>();
        infoServicio.put("content", sb.toString());
        sendActionRequest(infoServicio, "talk");
    }

    @Override
    public void cancelTask(Believes believes) {
                super.cancelTask(believes);
        System.out.println("--- Cancel Task Busqueda Cancion ---");
        BeliefAgent blvs = (BeliefAgent) believes;
        MusicoTerapiaContext musicoterapiaContext = (MusicoTerapiaContext) blvs.getServiceContext(MusicoTerapia.class);
        musicoterapiaContext.setCancionActual(null);
    }

    @Override
    public boolean checkFinish(Believes believes) {

        BeliefAgent blvs = (BeliefAgent) believes;
        MusicoTerapiaContext musicoterapiaContext = (MusicoTerapiaContext) blvs.getServiceContext(MusicoTerapia.class);

        if (musicoterapiaContext.isVideoHasEnded()) {
            //!blvs.getbEstadoInteraccion().isTopicoActivo(PepperTopicsNames.RETROCANCIONTOPIC) &&
            if (envioVideo) {
                //TODO: implement topic mgmt.
                //ResPwaUtils.deactivateTopic(PepperTopicsNames.BLANKATOPIC, believes);
                //ResPwaUtils.activateTopic(PepperTopicsNames.RETROCANCIONTOPIC, believes);
                envioVideo = false;
                infoServicio = new HashMap<>();
                infoServicio.put("mode", "killAll");
                sendActionRequest(infoServicio, "stopMovementResponse");
            }
            return true;
        } else {
            setTaskWaitingForExecution();
            return false;
        }
    }

}
