package com.besa.PwAAgent.agent.utils;

import java.util.ArrayList;
import java.util.List;

import com.besa.PwAAgent.agent.PwAService;
import com.besa.PwAAgent.agent.goals.action.CuenteriaContext;
import com.besa.PwAAgent.agent.goals.action.MusicoTerapiaContext;
import com.besa.PwAAgent.db.model.ActXPreferencia;
import com.besa.PwAAgent.db.model.Antecedente;
import com.besa.PwAAgent.db.model.PreferenciaXCancion;
import com.besa.PwAAgent.db.model.PreferenciaXCuento;
import com.besa.PwAAgent.db.model.userprofile.PwAPreferenceContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;
import com.besa.PwAAgent.db.repository.AntecedenteRepository;

import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ServiceContext;

public class PwAUtil {
    public static double getGustoActividad(PwAService actividad, PwAPreferenceContext perfil) {
        double gusto = 0;
        ReportBESA.debug("getActXPreferenciaListJLEON5" + perfil.getActXPreferenciaList());
        for (ActXPreferencia a : perfil.getActXPreferenciaList()) {
            ReportBESA.debug("JLEON5"+a.getActividadPwa().getNombre() + " " + actividad.name());
            if (a.getActividadPwa().getNombre().equalsIgnoreCase(actividad.name())) {
                gusto = a.getGusto();
                break;
            }
        }
        return gusto;
    }

    public static void calculateActivityFeedBack(PwAService activity, PwAProfile perfil, ServiceContext context,Double respuestaRetroalimentacion, AntecedenteRepository repo){
        double emotionFeedback = 0.0;// emotionFeedbackAux = 0;
    ;//PwAPreferenceContext preferencias = perfil.getPwAPreferenceContext();
        
        List<Antecedente> antecedents = repo.findAll();
        //emotionFeedback = bEstadoEmocionalPwA.getFeedbackEmotion();
        emotionFeedback = aproximateEmotionValue(emotionFeedback);

        List<Antecedente> antecedentsForFeedback = getAntecedentsForFeedback(emotionFeedback, respuestaRetroalimentacion, antecedents);

        switch (activity) {
            case CUENTERIA:
                CuenteriaContext cuenteriaContext = (CuenteriaContext) context;
                PreferenciaXCuento preferenciaCuento = (PreferenciaXCuento) cuenteriaContext.getCuentoActual();
                ModeloRetroalimentacion<PreferenciaXCuento> modeloRetroCuento = new ModeloRetroalimentacion<>(preferenciaCuento);
                modeloRetroCuento.activityFeedback(antecedentsForFeedback);
                break;

            case MUSICOTERAPIA:
            MusicoTerapiaContext musicoTerapiaContext = (MusicoTerapiaContext) context;
                PreferenciaXCancion preferenciaCancion = (PreferenciaXCancion) musicoTerapiaContext.getCancionActual();
                ModeloRetroalimentacion<PreferenciaXCancion> modelRetroCancion = new ModeloRetroalimentacion<>(preferenciaCancion);
                modelRetroCancion.activityFeedback(antecedentsForFeedback);
                break;
            case EJERCICIO:
            
                break;
            case LEER_BIBLIA:
            case TOMAR_MEDICAMENTO:
            default:
                break;
        }
    }


    private static double aproximateEmotionValue(double emotionFeedback) {
        double aproximation = 0.0;
        final double VERY_PLEASANT = 1;
        final double PLEASANT = 0.65;
        final double LITTLE_PLEASANT = 0.35;
        final double VERY_UNPLEASANT = -1;
        final double UNPLEASANT = -0.65;
        final double LITTLE_UNPLEASANT = -0.35;
        final double ZERO = 0.0;

        if (emotionFeedback > PLEASANT) {
            aproximation = VERY_PLEASANT;
        } else {
            if (emotionFeedback > LITTLE_PLEASANT) {
                aproximation = PLEASANT;
            } else {
                if (emotionFeedback > ZERO) {
                    aproximation = LITTLE_PLEASANT;
                } else {
                    if (emotionFeedback < UNPLEASANT) {
                        aproximation = VERY_UNPLEASANT;
                    } else {
                        if (emotionFeedback < LITTLE_PLEASANT) {
                            aproximation = UNPLEASANT;
                        } else {
                            aproximation = LITTLE_UNPLEASANT;
                        }
                    }
                }
            }
        }

        return aproximation;
    }

    private static List<Antecedente> getAntecedentsForFeedback(double emotionFeedback, double voiceFeedback, List<Antecedente> antecedents) {

        List<Antecedente> antecedentsForFeedback = new ArrayList<>();
        for (int i = 0; i < antecedents.size(); i++) {
            if (antecedents.get(i).getEtiqueta().equals("EMOTIONFEEDBACK") && antecedents.get(i).getValor() == emotionFeedback) {
                antecedentsForFeedback.add(antecedents.get(i));
            } else {
                if (antecedents.get(i).getEtiqueta().equals("VOICEFEEDBACK") && antecedents.get(i).getValor() == voiceFeedback) {
                    antecedentsForFeedback.add(antecedents.get(i));
                }
            }
        }

        return antecedentsForFeedback;
    }

}
