package com.besa.PwAAgent.agent.utils;

import com.besa.PwAAgent.agent.PwAService;
import com.besa.PwAAgent.db.model.ActXPreferencia;
import com.besa.PwAAgent.db.model.userprofile.PwAPreferenceContext;

public class PwAUtil {
    public static double getGustoActividad(PwAService actividad, PwAPreferenceContext perfil) {
        double gusto = 0;
        for (ActXPreferencia a : perfil.getActXPreferenciaList()) {
            if (a.getActividadPwa().getNombre().equalsIgnoreCase(actividad.name())) {
                gusto = a.getGusto();
                break;
            }
        }
        return gusto;
    }

}
