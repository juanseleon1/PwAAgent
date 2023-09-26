package com.besa.PwAAgent.agent.goals.latent;

import com.besa.PwAAgent.db.model.userprofile.PwAMedicalContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.BDI.AgentStructuralModel.LatentGoalStructure.LatentGoal;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import rational.mapping.Believes;

public class PerformAssistance extends LatentGoal {

    public PerformAssistance() {
        super(MotivationAgent.getPlanID());
    }

    @Override
    public double detectGoal(Believes beliefs) throws KernellAgentEventExceptionBESA {
        BeliefAgent beliefAgent = (BeliefAgent) beliefs;
        String currentUser = beliefAgent.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) beliefAgent.getUserProfile(currentUser);
        PwAMedicalContext medicalContext = miPerfil.getUserMedicalContext();
        double value = 0;

        if (medicalContext.getFast() > 3) {
            value += 0.2;
        }
        if (medicalContext.getDiscapAuditiva() == 1) {
            value += 0.2;
        }
        if (medicalContext.getDiscapMotora() == 1) {
            value += 0.2;
        }
        if (medicalContext.getDiscapVisual() == 1) {
            value += 0.2;
        }

        return value;
    }

    @Override
    public double evaluateContribution(StateBDI state) throws KernellAgentEventExceptionBESA {
        BeliefAgent beliefAgent = (BeliefAgent) state.getBelieves();
        String currentUser = beliefAgent.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) beliefAgent.getUserProfile(currentUser);
        PwAMedicalContext medicalContext = miPerfil.getUserMedicalContext();
        double value = 0;

        if (medicalContext.getFast() > 3) {
            value += 0.2;
        }
        if (medicalContext.getDiscapAuditiva() == 1) {
            value += 0.2;
        }
        if (medicalContext.getDiscapMotora() == 1) {
            value += 0.2;
        }
        if (medicalContext.getDiscapVisual() == 1) {
            value += 0.2;
        }

        return value;
    }

}
