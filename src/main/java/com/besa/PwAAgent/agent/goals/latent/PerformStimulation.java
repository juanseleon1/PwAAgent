package com.besa.PwAAgent.agent.goals.latent;

import com.besa.PwAAgent.db.model.userprofile.PwAMedicalContext;
import com.besa.PwAAgent.db.model.userprofile.PwAPreferenceContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.BDI.AgentStructuralModel.LatentGoalStructure.LatentGoal;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import rational.mapping.Believes;

public class PerformStimulation extends LatentGoal {

    public PerformStimulation() {
        super(MotivationAgent.getPlanID());
    }

    @Override
    public double detectGoal(Believes beliefs) throws KernellAgentEventExceptionBESA {
        BeliefAgent beliefAgent = (BeliefAgent) beliefs;
        String currentUser = beliefAgent.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) beliefAgent.getUserProfile(currentUser);
        PwAMedicalContext medicalContext = miPerfil.getUserMedicalContext();
        double value = 0;
        if (medicalContext.getSppb() >= 6) {
            value += 0.3;
        }
        if (medicalContext.getFast() < 5) {
            value += 0.3;
        }
        if (medicalContext.getRiesgoCaida() < 3) {
            value += 0.3;
        }

        return value;
    }

    @Override
    public double evaluateContribution(StateBDI state) throws KernellAgentEventExceptionBESA {
        BeliefAgent beliefAgent = (BeliefAgent) state.getBelieves();
        String currentUser = beliefAgent.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) beliefAgent.getUserProfile(currentUser);
        PwAPreferenceContext miContexto = miPerfil.getPwAPreferenceContext();
        return miContexto.getGustoBaile() * .20 + miContexto.getGustoEjercicio() * .20
                + miContexto.getGustoKaraoke() * .20 + miContexto.getGustoLeer() * .20
                + miContexto.getGustoMusica() * .20;
    }
}
