package com.besa.PwAAgent.agent.tasks.Cuenteria;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import java.util.HashMap;
import java.util.List;

import com.besa.PwAAgent.agent.goals.action.Cuenteria;
import com.besa.PwAAgent.agent.goals.action.CuenteriaContext;
import com.besa.PwAAgent.db.model.PreferenciaXCuento;
import com.besa.PwAAgent.db.model.userprofile.PwAPreferenceContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;
import com.besa.PwAAgent.utils.personalization.CromosomaCuento;
import com.besa.PwAAgent.utils.personalization.ModeloSeleccion;

import rational.mapping.Believes;


public class SeleccionarCuento extends SRTask {

    private HashMap<String, Object> infoServicio = new HashMap<>();
    private String userName;

    @Override
    public void executeTask(Believes parameters) {
        BeliefAgent blvs = (BeliefAgent) parameters;
        blvs.getInteractionState().setActiveService(Cuenteria.class.getName());

        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile)blvs.getUserProfile(currUser);
        userName =  miPerfil.getNombre();
        CuenteriaContext cuenteriaContext = (CuenteriaContext) blvs.getServiceContext(Cuenteria.class);
        PwAPreferenceContext prefContext = (PwAPreferenceContext)miPerfil.getPwAPreferenceContext();
        List<PreferenciaXCuento> cuentos = prefContext.getPreferenciaXCuentoList();
        ModeloSeleccion<PreferenciaXCuento> modeloCuento = new ModeloSeleccion<PreferenciaXCuento>(cuentos);
        PreferenciaXCuento cuentoSelected = null;
        CromosomaCuento cromosoma = null;
        cromosoma = (CromosomaCuento) modeloCuento.selectCromosoma();

        if (cromosoma != null) {
            cuentoSelected = cromosoma.getCuento();
            cuenteriaContext.setCuentoActual(cuentoSelected);
            infoServicio.put("content", "Como se que te gustan los cuentos de "+ cuentoSelected.getCuento().getGenero().getGenero()+ ". Voy a contarte el cuento de " + cuentoSelected.getCuento().getNombre());
            infoServicio.put("style", "animated");
            sendActionRequest(infoServicio, "talk");
        }
        cuenteriaContext.setIndexCuento(0);
    }

    @Override
    public void interruptTask(Believes believes) {
        super.interruptTask(believes);
        //ReportBESA.debug("--- Interrupt Task Recomendar Cuento ---");
        StringBuilder sb = new StringBuilder();
        sb.append("Oh, espera");
        sb.append(userName);
        sb.append(", tenemos que hacer algo mas importante. Ya volvemos a continuar el cuento");
        infoServicio = new HashMap<>();
        infoServicio.put("content", sb.toString());
        infoServicio.put("style", "animated");
        sendActionRequest(infoServicio, "talk");
    }

    @Override
    public void cancelTask(Believes believes) {
        super.cancelTask(believes);
        //ReportBESA.debug("--- Cancel Task Recomendar Cuento ---");
        BeliefAgent blvs = (BeliefAgent) believes;
        CuenteriaContext cuenteriaContext = (CuenteriaContext) blvs.getServiceContext(Cuenteria.class);
        cuenteriaContext.setCuentoActual(null);
    }

    @Override
    public boolean checkFinish(Believes believes) {
        BeliefAgent blvs = (BeliefAgent) believes;
                CuenteriaContext cuenteriaContext = (CuenteriaContext) blvs.getServiceContext(Cuenteria.class);
        return cuenteriaContext.getCuentoActual() != null;
    }

}