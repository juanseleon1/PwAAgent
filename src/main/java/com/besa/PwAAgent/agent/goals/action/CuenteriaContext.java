package com.besa.PwAAgent.agent.goals.action;

import java.util.Map;

import com.besa.PwAAgent.agent.PwAService;
import com.besa.PwAAgent.agent.utils.UserEvaluableContext;
import com.besa.PwAAgent.db.model.PreferenciaXCuento;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;
import com.besa.PwAAgent.db.repository.ActivityPreferencesRepository;
import com.besa.PwAAgent.db.repository.TalePreferencesRepository;
import com.besa.PwAAgent.pwa.PwAConversationEventData;
import com.besa.PwAAgent.utils.SpringContext;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import rational.data.InfoData;

public class CuenteriaContext extends UserEvaluableContext {
    private int indexCuento;
    private PreferenciaXCuento cuentoActual;
    private String retroalimentacionValue;
    private boolean moviendose;
    private boolean isChanged;

    public CuenteriaContext() {
        super();
        indexCuento = 0;
        retroalimentacionValue = null;
        cuentoActual = null;
        moviendose = false;
        isChanged = false;
    }

    public PreferenciaXCuento getCuentoActual() {
        return cuentoActual;
    }

    public int getIndexCuento() {
        return indexCuento;
    }

    public void setIndexCuento(int i) {
        indexCuento = i;
    }

    public String getRetroalimentacionValue() {
        return retroalimentacionValue;
    }

    public void feedbackActivity(Double respuestaRetroalimentacion) {
    }

    public void setCuentoActual(PreferenciaXCuento cuentoSelected) {
        cuentoActual = cuentoSelected;
    }

    @Override
    public CuenteriaContext clone() {
        CuenteriaContext cloned = new CuenteriaContext();
        cloned.indexCuento = indexCuento;
        cloned.cuentoActual = cuentoActual == null ? cuentoActual
                : new PreferenciaXCuento(cuentoActual.getPreferenciaXCuentoPK());
        return cloned;
    }

    @Override
    public void updateTasteForRelatedObjs(BeliefAgent blvs, double factor) {
        cuentoActual.setGusto(cuentoActual.getGusto() * (1 + (0.5 - factor)));
        SpringContext.getBean(TalePreferencesRepository.class).save(cuentoActual);
        PwAProfile profile = (PwAProfile) blvs.getUserProfile(blvs.getActiveUsers().get(0));
        profile.getPwAPreferenceContext().getActXPreferenciaList().forEach(t -> {
            if (t.getActividadPwa().getNombre().equals(PwAService.CUENTERIA.name()))
                t.setGusto(t.getGusto() * (1 + (0.5 - factor)));
            SpringContext.getBean(ActivityPreferencesRepository.class).save(t);
        });
    }

    @Override
    public boolean handleOtherData(InfoData data) {
        boolean update = false;
        if (data instanceof PwAConversationEventData) {
            PwAConversationEventData response = (PwAConversationEventData) data;
            if (response.isRetroalimentationValue()) {
                this.getRetroValues().add(response.getMessage());
                update = true;
            }
        }
        return update;
    }

    @Override
    public boolean handleRobotData(RobotData data) {
        boolean update = false;
        RobotData robotData = (RobotData) data;
        Map<String, ?> response = robotData.getParameters();

        if (response.containsKey("animationEnded")) {
            moviendose = !(boolean) response.get("animationEnded");
        }
        return update;
    }

    public void setRetroalimentacionValue(String retroalimentacionValue) {
        this.retroalimentacionValue = retroalimentacionValue;
    }

    public boolean isMoviendose() {
        return moviendose;
    }

    public void setMoviendose(boolean moviendose) {
        this.moviendose = moviendose;
    }

    @Override
    public String captureRecordData() {
        return this.toString();
    }

    @Override
    public String toString() {
        String cuento = cuentoActual != null && cuentoActual.getCuento() != null ? cuentoActual.getCuento().getNombre()
                : "ninguno";
        return "Contexto de Cuentería\n" +
                "Línea del cuento: " + indexCuento + "\n" +
                "Nombre del cuento: " + cuento + "\n" +
                "Valor de retroalimentación: " + retroalimentacionValue + "\n" +
                "El robot se movió: " + moviendose;
    }

    public boolean isChanged() {
        return isChanged;
    }

    public void setChanged(boolean isChanged) {
        this.isChanged = isChanged;
    }

}
