package com.besa.PwAAgent.agent.tasks.MusicoTerapia;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;
import java.util.HashMap;
import java.util.List;

import com.besa.PwAAgent.agent.goals.action.MusicoTerapia;
import com.besa.PwAAgent.agent.goals.action.MusicoTerapiaContext;
import com.besa.PwAAgent.db.model.PreferenciaXCancion;
import com.besa.PwAAgent.db.model.userprofile.PwAPreferenceContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;
import com.besa.PwAAgent.utils.personalization.CromosomaCancion;
import com.besa.PwAAgent.utils.personalization.ModeloSeleccion;

public class SeleccionarCancion extends SRTask {

    private HashMap<String, Object> infoServicio = new HashMap<>();
    private String userName;

    public SeleccionarCancion() {
        // System.out.println("--- Task Seleccionar Cancion Iniciada ---");
    }

    @Override
    public void executeTask(Believes parameters) {
        System.out.println("--- Execute Task Seleccionar Cancion ---");

        BeliefAgent blvs = (BeliefAgent) parameters;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        userName = miPerfil.getUserContext().getSocioDemoContext().getName();

        PwAPreferenceContext prefContext = (PwAPreferenceContext) miPerfil.getUserContext().getPreferenceContext();
        MusicoTerapiaContext musicoterapiaContext = (MusicoTerapiaContext) blvs.getServiceContext(MusicoTerapia.class);
        sendActionRequest(infoServicio, "talk");

        List<PreferenciaXCancion> canciones = prefContext.getPreferenciaXCancionList();
        ModeloSeleccion<PreferenciaXCancion> modeloCancion = new ModeloSeleccion<PreferenciaXCancion>(canciones);
        PreferenciaXCancion cancionSelected = null;
        CromosomaCancion cromosoma = null;
        cromosoma = (CromosomaCancion) modeloCancion.selectCromosoma();

        if (cromosoma != null) {
            cancionSelected = cromosoma.getCancion();
            musicoterapiaContext.setCancionActual(cancionSelected);
        }

        infoServicio = new HashMap<>();
        infoServicio.put("content", "La canción seleccionada es " + cancionSelected.getCancion().getNombre());
        sendActionRequest(infoServicio, "talk");

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
        System.out.println("--- Cancel Task Seleccionar Cancion ---");
        BeliefAgent blvs = (BeliefAgent) believes;
        MusicoTerapiaContext musicoterapiaContext = (MusicoTerapiaContext) blvs.getServiceContext(MusicoTerapia.class);
        musicoterapiaContext.setCancionActual(null);
    }

    @Override
    public boolean checkFinish(Believes believes) {
        BeliefAgent blvs = (BeliefAgent) believes;
        MusicoTerapiaContext musicoterapiaContext = (MusicoTerapiaContext) blvs.getServiceContext(MusicoTerapia.class);
        return musicoterapiaContext.getCancionActual() != null;
    }

}
