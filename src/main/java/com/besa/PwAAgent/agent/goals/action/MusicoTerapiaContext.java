package com.besa.PwAAgent.agent.goals.action;

import java.util.Map;

import com.besa.PwAAgent.agent.PwAService;
import com.besa.PwAAgent.agent.utils.UserEvaluableContext;
import com.besa.PwAAgent.db.model.PreferenciaXBaile;
import com.besa.PwAAgent.db.model.PreferenciaXCancion;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;
import com.besa.PwAAgent.db.repository.ActivityPreferencesRepository;
import com.besa.PwAAgent.db.repository.SongPreferencesRepository;
import com.besa.PwAAgent.pwa.PwAConversationEventData;
import com.besa.PwAAgent.utils.SpringContext;

import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import rational.data.InfoData;

public class MusicoTerapiaContext extends UserEvaluableContext {

    private PreferenciaXCancion cancionActual;
    private boolean estaBailando;
    private String retroalimentacionValue;
    private PreferenciaXBaile baileActual;
    private boolean videoEnded;

    public MusicoTerapiaContext() {
        super();
        estaBailando = false;
        videoEnded = false;
        cancionActual = null;
        baileActual = null;
        retroalimentacionValue = null;
    }

    public void setCancionActual(PreferenciaXCancion cancionSelected) {
        this.cancionActual = cancionSelected;
    }

    public PreferenciaXCancion getCancionActual() {
        return cancionActual;
    }

    public boolean isEstaBailando() {
        return estaBailando;
    }

    public void setBaileActual(PreferenciaXBaile baileSelected) {
        this.baileActual = baileSelected;
    }

    public PreferenciaXBaile getBaileActual() {
        return baileActual;
    }

    public boolean isVideoHasEnded() {
        return videoEnded;
    }

    public String getRetroalimentacionValue() {
        return retroalimentacionValue;
    }

    @Override
    public MusicoTerapiaContext clone() {
        MusicoTerapiaContext cloned = new MusicoTerapiaContext();
        cloned.estaBailando = estaBailando;
        cloned.cancionActual = cancionActual == null ? cancionActual
                : new PreferenciaXCancion(cancionActual.getPreferenciaXCancionPK());
        cloned.baileActual = baileActual == null ? baileActual
                : new PreferenciaXBaile(baileActual.getPreferenciaXBailePK());
        return cloned;
    }

    public void setEstaBailando(boolean estaBailando) {
        this.estaBailando = estaBailando;
    }

    public void setRetroalimentacionValue(String retroalimentacionValue) {
        this.retroalimentacionValue = retroalimentacionValue;
    }

    public boolean isVideoEnded() {
        return videoEnded;
    }

    public void setVideoEnded(boolean videoEnded) {
        this.videoEnded = videoEnded;
    }

    @Override
    public void updateTasteForRelatedObjs(BeliefAgent blvs, double factor) {
        cancionActual.setGusto(cancionActual.getGusto() * (1 + (0.5 - factor)));
        cancionActual.setGusto(cancionActual.getGusto() * (1 + (0.5 - factor)));
        SpringContext.getBean(SongPreferencesRepository.class).save(cancionActual);
        PwAProfile profile = (PwAProfile) blvs.getUserProfile(blvs.getActiveUsers().get(0));
        profile.getPwAPreferenceContext().getActXPreferenciaList().forEach(t -> {
            if (t.getActividadPwa().getNombre().equals(PwAService.MUSICOTERAPIA.name()))
                t.setGusto(t.getGusto() * (1 + (0.5 - factor)));
            SpringContext.getBean(ActivityPreferencesRepository.class).save(t);
        });
    }

    @Override
    public boolean handleOtherData(InfoData data) {
        boolean update = false;
        if (data instanceof PwAConversationEventData) {
            PwAConversationEventData response = (PwAConversationEventData) data;
            //ReportBESA.debug("UPDATING VALUES " + data);
            if (response.isRetroalimentationValue()) {
                //ReportBESA.debug("Retros: " + response.getMessage());
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
            estaBailando = !(boolean) response.get("animationEnded");
        }

        if (response.containsKey("endVideo")) {
            videoEnded = (boolean) response.get("endVideo");
        }
        return update;
    }

    @Override
    public String captureRecordData() {
        return this.toString();
    }

    @Override
    public String toString() {
        String cancion = cancionActual != null ? cancionActual.getCancion().getNombre() : "ninguna";
        String baile = baileActual != null ? baileActual.getBaile().getNombre() : "ninguno";
        return "Contexto de Musicoterapia\n" +
                "Canción actual: " + cancion + "\n" +
                "Robot bailando: " + estaBailando + "\n" +
                "Valor de retroalimentación: " + retroalimentacionValue + "\n" +
                "Baile actual: " + baile + "\n" +
                "Video finalizado: " + videoEnded;
    }

}
