package com.besa.PwAAgent.agent.tasks.DarMedicamentos;

import java.util.ArrayList;
import java.util.List;
import com.besa.PwAAgent.agent.goals.action.DarMedicamentos;
import com.besa.PwAAgent.agent.goals.action.DarMedicamentosContext;
import com.besa.PwAAgent.db.model.userprofile.Dosis;
import com.besa.PwAAgent.db.model.userprofile.FranjaMedicamento;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;
import rational.mapping.Believes;

public class PrepararInformacion extends SRTask {

    @Override
    public void executeTask(Believes beliefs) {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        blvs.getInteractionState().setActiveService(DarMedicamentos.class.getName());
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        String userName = miPerfil.getNombre();
        DarMedicamentosContext darMedicamentosContext = (DarMedicamentosContext) blvs
                .getServiceContext(DarMedicamentos.class);
        FranjaMedicamento franja = darMedicamentosContext.getCurrentFranja();

        List<String> sb = new ArrayList<>();
        sb.add(userName + ", no olvides que debes tomar los siguientes medicamentos: ");
        List<Dosis> medicamentos = franja.getDosis();

        medicamentos.forEach(dosis -> {
            sb.add(dosis.getCantidad() + " miligramos de " + dosis.getMedicamento() + ". ");
        });

        sb.add("Dime si, cuando te hayas tomado el medicamento. O dime no, si no te lo quieres tomar");
        darMedicamentosContext.setMedicamentos(sb);
    }

    @Override
    public boolean checkFinish(Believes beliefs) {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        DarMedicamentosContext darMedicamentosContext = (DarMedicamentosContext) blvs
                .getServiceContext(DarMedicamentos.class);
        return super.checkFinish(beliefs) && darMedicamentosContext.getMedicamentos() != null
                && !darMedicamentosContext.getMedicamentos().isEmpty();
    }

}
