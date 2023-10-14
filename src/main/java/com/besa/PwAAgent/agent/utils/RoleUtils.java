package com.besa.PwAAgent.agent.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BESA.BDI.AgentStructuralModel.LatentGoalStructure.AgentRole;
import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.System.Directory.AgHandlerBESA;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.mission.ChangeAgentRoleData;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.mission.ChangeAgentRoleGuard;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.mission.EmotionalAgentRole;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.mission.EmotionalImpact;

public class RoleUtils {
    public static void setSadnessEmotionalAgentRole() {
        List<EmotionalImpact> emotionalImpacts = new ArrayList<>();
        Map<String, Double> eventInfluences = new HashMap<>();
        double forgetFactor = 1;
        double baseValue = -1;
        EmotionalImpact emotionalImpact = new EmotionalImpact(eventInfluences, forgetFactor, baseValue);
        emotionalImpact.setPositiveEmotionName("HAPPINESS");
        emotionalImpacts.add(emotionalImpact);
        EmotionalAgentRole emotionalRole = new EmotionalAgentRole(emotionalImpacts, "SADNESS");
        sendRole(emotionalRole);
    }

    public static void sendDefaultEmotionalAgentRole() {
        try {
            ChangeAgentRoleData data = ChangeAgentRoleData.createEmotionalDefaultData();
            EventBESA eventBesa = new EventBESA(ChangeAgentRoleGuard.class.getName(),
                    data);
            AgHandlerBESA agHandlerBESA;
            agHandlerBESA = AdmBESA.getInstance().getHandlerByAlias(MotivationAgent.name);
            agHandlerBESA.sendEvent(eventBesa);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }

    public static void sendRole(AgentRole role) {
        try {

            ChangeAgentRoleData data = new ChangeAgentRoleData(role);
            EventBESA eventBesa = new EventBESA(ChangeAgentRoleGuard.class.getName(),
                    data);
            AgHandlerBESA agHandlerBESA;
            agHandlerBESA = AdmBESA.getInstance().getHandlerByAlias(MotivationAgent.name);
            agHandlerBESA.sendEvent(eventBesa);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }
}
