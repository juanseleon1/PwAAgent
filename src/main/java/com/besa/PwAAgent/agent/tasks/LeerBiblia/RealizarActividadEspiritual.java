package com.besa.PwAAgent.agent.tasks.LeerBiblia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.besa.PwAAgent.agent.goals.action.LeerBiblia;
import com.besa.PwAAgent.agent.goals.action.LeerBibliaContext;
import com.besa.PwAAgent.db.model.userprofile.PwAPreferenceContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;
import com.besa.PwAAgent.db.model.userprofile.Versiculo;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class RealizarActividadEspiritual extends SRTask {

    @Override
    public void executeTask(Believes believes) {
        BeliefAgent blvs = (BeliefAgent) believes;
        String currUser = blvs.getActiveUsers().get(0);
        LeerBibliaContext context = (LeerBibliaContext) blvs.getServiceContext(LeerBiblia.class);
        StringBuffer sb = new StringBuffer();
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        PwAPreferenceContext preferenceContext = miPerfil.getPwAPreferenceContext();
        sb.append("Esta bien. Vamos a ");
        String respuesta = context.getWordRecognized();
        if (respuesta.equals("oracion")) {
            sb.append("hacer una oracion");
            sb.append("Hagamoslo juntos");
            sb.append(preferenceContext.getReligion().getOracion());
        } else {
            sb.append("leer un versiculo de ");
            sb.append(preferenceContext.getReligion().getLibro());
            List<Versiculo> versiculos = preferenceContext.getReligion().getVersiculos();
            Random random = new Random();
            int randomIndex = random.nextInt(versiculos.size());
            Versiculo versiculo = versiculos.get(randomIndex);
            sb.append("en especifico");
            sb.append(versiculo.getInformacion());
            sb.append("dice");
            sb.append(versiculo.getTexto());
        }
        sb.append("¿Te gusto?");
        Map<String, Object> infoServicio = new HashMap<>();
        infoServicio.put("content", sb.toString());
        sendActionRequest(infoServicio, "talk");
    }

}
