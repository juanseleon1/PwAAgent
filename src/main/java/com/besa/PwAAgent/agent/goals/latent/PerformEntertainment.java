package com.besa.PwAAgent.agent.goals.latent;

import com.besa.PwAAgent.db.model.userprofile.PwAPreferenceContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;
import com.besa.PwAAgent.db.model.userprofile.Religion;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.BDI.AgentStructuralModel.LatentGoalStructure.LatentGoal;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import rational.mapping.Believes;

public class PerformEntertainment extends LatentGoal {

    public PerformEntertainment() {
        super(MotivationAgent.getPlanID());
    }

    @Override
    public double detectGoal(Believes beliefs) throws KernellAgentEventExceptionBESA {
        BeliefAgent beliefAgent = (BeliefAgent) beliefs;
        String currentUser = beliefAgent.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) beliefAgent.getUserProfile(currentUser);
        PwAPreferenceContext miContexto = miPerfil.getPwAPreferenceContext();
        Religion miReligion = miContexto.getReligion();

        return miReligion.getName().equalsIgnoreCase("ateo") ? 0 : 1;
    }

    @Override
    public double evaluateContribution(StateBDI state) throws KernellAgentEventExceptionBESA {
        BeliefAgent beliefAgent = (BeliefAgent) state.getBelieves();
        String currentUser = beliefAgent.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) beliefAgent.getUserProfile(currentUser);
        PwAPreferenceContext miContexto = miPerfil.getPwAPreferenceContext();
        return miContexto.getGustoBaile() * .20
                + miContexto.getGustoKaraoke() * .20
                + miContexto.getGustoMusica() * .20;
    }

}
