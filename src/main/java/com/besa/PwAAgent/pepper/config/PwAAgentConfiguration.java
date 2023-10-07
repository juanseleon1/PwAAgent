package com.besa.PwAAgent.pepper.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.besa.PwAAgent.agent.goals.action.Cuenteria;
import com.besa.PwAAgent.agent.goals.action.DarMedicamentos;
import com.besa.PwAAgent.agent.goals.action.DemostrarVida;
import com.besa.PwAAgent.agent.goals.action.LeerBiblia;
import com.besa.PwAAgent.agent.goals.action.MusicoTerapia;
import com.besa.PwAAgent.agent.goals.emergency.DetectarEmergencia;
import com.besa.PwAAgent.agent.goals.latent.GenerateWellBeing;
import com.besa.PwAAgent.agent.goals.latent.PerformActivities;
import com.besa.PwAAgent.agent.goals.latent.PerformAssistance;
import com.besa.PwAAgent.agent.goals.latent.PerformEntertainment;
import com.besa.PwAAgent.agent.goals.latent.PerformSpiritual;

import BESA.BDI.AgentStructuralModel.Agent.LatentGoalStructure;
import BESA.BDI.AgentStructuralModel.LatentGoalStructure.AgentRole;
import BESA.BDI.AgentStructuralModel.LatentGoalStructure.LatentGoal;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.goal.RequestPermission;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.explainability.goal.ExplainDecisions;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.mission.EmotionalAgentRole;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.mission.EmotionalImpact;
import BESA.SocialRobot.BDIAgent.MotivationAgent.utils.MotivationAgentConfiguration;
import BESA.SocialRobot.BDIAgent.MotivationAgent.utils.SRConfiguration;

public class PwAAgentConfiguration extends SRConfiguration {

    @Override
    protected void setupLatentGoalStructureAndMasks() {
        MotivationAgentConfiguration motivationAgentConfiguration = getConfig();
        LatentGoalStructure latentGoalStructure = new LatentGoalStructure();
        LatentGoal root = new GenerateWellBeing();
        latentGoalStructure.setRoot(root);
        LatentGoal activities = new PerformActivities();
        LatentGoal assistance = new PerformAssistance();
        LatentGoal entertainment = new PerformEntertainment();
        LatentGoal spiritual = new PerformSpiritual();
        MusicoTerapia musicoTerapia = MusicoTerapia.buildGoal();
        Cuenteria cuenteria = Cuenteria.buildGoal();
        DarMedicamentos darMedicamentos = DarMedicamentos.buildGoal();
        LeerBiblia leerBiblia = LeerBiblia.buildGoal();
        RequestPermission requestPermission = RequestPermission.buildGoal();
        ExplainDecisions explainDecisions = ExplainDecisions.buildGoal();
        DemostrarVida vida = DemostrarVida.buildGoal();
        DetectarEmergencia emergencia = DetectarEmergencia.buildGoal();
        latentGoalStructure.addOrphanBDIGoal(requestPermission);
        latentGoalStructure.addOrphanBDIGoal(explainDecisions);
        latentGoalStructure.addOrphanBDIGoal(emergencia);
        latentGoalStructure.addOrphanBDIGoal(vida);
        latentGoalStructure.addRelation(root, activities);
        latentGoalStructure.addRelation(activities, assistance);
        latentGoalStructure.addRelation(assistance, darMedicamentos);
        latentGoalStructure.addRelation(spiritual, darMedicamentos);
        latentGoalStructure.addRelation(entertainment, darMedicamentos);
        latentGoalStructure.addRelation(activities, entertainment);
        latentGoalStructure.addRelation(assistance, musicoTerapia);
        latentGoalStructure.addRelation(spiritual, musicoTerapia);
        latentGoalStructure.addRelation(entertainment, musicoTerapia);
        latentGoalStructure.addRelation(assistance, cuenteria);
        latentGoalStructure.addRelation(spiritual, cuenteria);
        latentGoalStructure.addRelation(entertainment, cuenteria);
        latentGoalStructure.addRelation(activities, spiritual);
        latentGoalStructure.addRelation(assistance, leerBiblia);
        latentGoalStructure.addRelation(spiritual, leerBiblia);
        latentGoalStructure.addRelation(entertainment, leerBiblia);

        motivationAgentConfiguration.setGoalStructure(latentGoalStructure);

        AgentRole defaultRole = new AgentRole();
        defaultRole.setWeight(root.getId(), activities.getId(), 1);
        defaultRole.setWeight(activities.getId(), assistance.getId(), 1);
        defaultRole.setWeight(activities.getId(), entertainment.getId(), 1);
        defaultRole.setWeight(activities.getId(), spiritual.getId(), 1);
        defaultRole.setWeight(assistance.getId(), darMedicamentos.getId(), 1);
        defaultRole.setWeight(entertainment.getId(), musicoTerapia.getId(), 1);
        defaultRole.setWeight(entertainment.getId(), cuenteria.getId(), 1);
        defaultRole.setWeight(spiritual.getId(), leerBiblia.getId(), 1);
        List<EmotionalImpact> emotionalImpacts = new ArrayList<>();

        Map<String, Double> eventInfluences = new HashMap<>();
        eventInfluences.put("no tomo", 1d);
        double forgetFactor = 0.0001;
        double baseValue = 0.8;
        EmotionalImpact emotionalImpact = new EmotionalImpact(eventInfluences, forgetFactor, baseValue);
        emotionalImpact.setPositiveEmotionName("Ira");
        emotionalImpacts.add(emotionalImpact);

        EmotionalAgentRole emotionalRole = new EmotionalAgentRole(emotionalImpacts);
        emotionalRole.setWeight(root.getId(), activities.getId(), 1);
        emotionalRole.setWeight(activities.getId(), assistance.getId(), 1);
        emotionalRole.setWeight(activities.getId(), entertainment.getId(), 1);
        emotionalRole.setWeight(activities.getId(), spiritual.getId(), 1);
        emotionalRole.setWeight(assistance.getId(), darMedicamentos.getId(), 1);
        emotionalRole.setWeight(entertainment.getId(), musicoTerapia.getId(), 1);
        emotionalRole.setWeight(entertainment.getId(), cuenteria.getId(), 1);
        emotionalRole.setWeight(spiritual.getId(), leerBiblia.getId(), 1);
        List<AgentRole> roles = new ArrayList<>();

        motivationAgentConfiguration.setDefaultAgentRole(defaultRole);
        motivationAgentConfiguration.setAgentRoles(roles);
    }

}
