package com.besa.PwAAgent.agent.tasks.MusicoTerapia;

import rational.mapping.Believes;
import java.util.HashMap;
import java.util.List;

import com.besa.PwAAgent.agent.goals.action.MusicoTerapia;
import com.besa.PwAAgent.agent.goals.action.MusicoTerapiaContext;
import com.besa.PwAAgent.db.model.PreferenciaXBaile;
import com.besa.PwAAgent.db.model.userprofile.PwAPreferenceContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;
import com.besa.PwAAgent.utils.personalization.CromosomaBaile;
import com.besa.PwAAgent.utils.personalization.ModeloSeleccion;

import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;

public class ReproduccionCancion extends SRTask {

    private HashMap<String, Object> infoServicio = new HashMap<>();
    private boolean envioVideo;
    private String userName;

    public ReproduccionCancion() {
        envioVideo = false;

    }

    @Override
    public void executeTask(Believes parameters) {
        BeliefAgent blvs = (BeliefAgent) parameters;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        userName = miPerfil.getNombre();
        PwAPreferenceContext prefContext = (PwAPreferenceContext) miPerfil.getPwAPreferenceContext();
        MusicoTerapiaContext musicoterapiaContext = (MusicoTerapiaContext) blvs.getServiceContext(MusicoTerapia.class);

        List<PreferenciaXBaile> bailes = prefContext.getPreferenciaXBaileList();

        if (!musicoterapiaContext.isEstaBailando()) {

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
                musicoterapiaContext.setEstaBailando(true);
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
        //ReportBESA.debug("--- Interrupt Task Seleccionar Cancion ---");
        StringBuilder sb = new StringBuilder();
        sb.append("Oh, espera");
        sb.append(userName);
        sb.append(", tenemos que hacer algo mas importante. Ya vuelvo a ponerte ");
        sb.append(musicoterapiaContext.getCancionActual().getCancion().getNombre());
        infoServicio = new HashMap<>();
        infoServicio.put("content", sb.toString());
        infoServicio.put("style", "animated");
        sendActionRequest(infoServicio, "talk");
        envioVideo = false;
    }

    @Override
    public void cancelTask(Believes believes) {
        super.cancelTask(believes);
        //ReportBESA.debug("--- Cancel Task Busqueda Cancion ---");
        BeliefAgent blvs = (BeliefAgent) believes;
        MusicoTerapiaContext musicoterapiaContext = (MusicoTerapiaContext) blvs.getServiceContext(MusicoTerapia.class);
        envioVideo = false;
        StringBuilder sb = new StringBuilder();
        sb.append("Oh, espera");
        sb.append(userName);
        sb.append(", tenemos que hacer algo mas importante. Ya vuelvo a ponerte ");
        sb.append(musicoterapiaContext.getCancionActual().getCancion().getNombre());
        infoServicio = new HashMap<>();
        infoServicio.put("content", sb.toString());
        infoServicio.put("style", "animated");
        sendActionRequest(infoServicio, "talk");
    }

    @Override
    public boolean checkFinish(Believes believes) {

        BeliefAgent blvs = (BeliefAgent) believes;
        MusicoTerapiaContext musicoterapiaContext = (MusicoTerapiaContext) blvs.getServiceContext(MusicoTerapia.class);
        //ReportBESA.debug("videoEnded" + musicoterapiaContext.isVideoHasEnded());

        if (musicoterapiaContext.isVideoHasEnded()) {
            //ReportBESA.debug("in videoEnded" + envioVideo);
            if (envioVideo) {
                //ReportBESA.debug("in videoEnded" + envioVideo);
                envioVideo = false;
                infoServicio = new HashMap<>();
                infoServicio.put("mode", "killAll");
                sendActionRequest(infoServicio, "stopAnimationAction");
            }
            return true;
        } else {
            setTaskWaitingForExecution();
            return false;
        }
    }

}
