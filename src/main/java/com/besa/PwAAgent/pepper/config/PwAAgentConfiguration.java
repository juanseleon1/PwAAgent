package com.besa.PwAAgent.pepper.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.besa.PwAAgent.agent.goals.action.Cuenteria;
import com.besa.PwAAgent.agent.goals.action.CuenteriaSupport;
import com.besa.PwAAgent.agent.goals.action.DarMedicamentos;
import com.besa.PwAAgent.agent.goals.action.DemostrarVida;
import com.besa.PwAAgent.agent.goals.action.LeerBiblia;
import com.besa.PwAAgent.agent.goals.action.MusicoTerapia;
import com.besa.PwAAgent.agent.goals.emergency.DetectarEmergencia;
import com.besa.PwAAgent.agent.goals.latent.MusicoTerapiaEsMejor;

import BESA.BDI.AgentStructuralModel.Agent.LatentGoalStructure;
import BESA.BDI.AgentStructuralModel.LatentGoalStructure.AgentRole;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.goal.RequestPermission;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.explainability.goal.ExplainDecisions;
import BESA.SocialRobot.BDIAgent.MotivationAgent.utils.MotivationAgentConfiguration;
import BESA.SocialRobot.BDIAgent.MotivationAgent.utils.SRConfiguration;

public class PwAAgentConfiguration extends SRConfiguration {

    @Override
    protected void setupLatentGoalStructureAndMasks() {
        MotivationAgentConfiguration motivationAgentConfiguration = getConfig();
        LatentGoalStructure latentGoalStructure = new LatentGoalStructure();
        MusicoTerapiaEsMejor root = new MusicoTerapiaEsMejor();
        latentGoalStructure.setRoot(root);
        MusicoTerapia musicoTerapia = MusicoTerapia.buildGoal();
        Cuenteria cuenteria = Cuenteria.buildGoal();
        CuenteriaSupport cuenteriaSupport = CuenteriaSupport.buildGoal();
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
        latentGoalStructure.addRelation(root, musicoTerapia);
        latentGoalStructure.addRelation(root, cuenteria);
        latentGoalStructure.addRelation(root, darMedicamentos);
        latentGoalStructure.addRelation(root, leerBiblia);
        latentGoalStructure.addRelation(root, cuenteriaSupport);

        motivationAgentConfiguration.setGoalStructure(latentGoalStructure);

        AgentRole defaultRole = new AgentRole("Default");
        defaultRole.setWeight(root.getId(), darMedicamentos.getId(), -1);
        defaultRole.setWeight(root.getId(), musicoTerapia.getId(), 1);
        defaultRole.setWeight(root.getId(), cuenteria.getId(), -1);
        defaultRole.setWeight(root.getId(), leerBiblia.getId(), -1);
        defaultRole.setWeight(root.getId(), cuenteriaSupport.getId(), -1);

        AgentRole testRole = new AgentRole("ChangeCuenteria");
        testRole.setWeight(root.getId(), darMedicamentos.getId(), -1);
        testRole.setWeight(root.getId(), musicoTerapia.getId(), 1);
        testRole.setWeight(root.getId(), cuenteria.getId(), -1);
        testRole.setWeight(root.getId(), leerBiblia.getId(), -1);
        testRole.setWeight(root.getId(), cuenteriaSupport.getId(), -1);

        testRole.addGoalStatus(cuenteriaSupport.getId(), true);

        AgentRole resetRole = new AgentRole("ResetCuenteria");
        resetRole.setWeight(root.getId(), darMedicamentos.getId(), -1);
        resetRole.setWeight(root.getId(), musicoTerapia.getId(), 1);
        resetRole.setWeight(root.getId(), cuenteria.getId(), -1);
        resetRole.setWeight(root.getId(), leerBiblia.getId(), -1);
        resetRole.setWeight(root.getId(), cuenteriaSupport.getId(), -1);

        resetRole.addGoalStatus(cuenteriaSupport.getId(), false);

        Map<String, AgentRole> roles = new ConcurrentHashMap<>();
        roles.put(defaultRole.getName(), defaultRole);
        roles.put(testRole.getName(), testRole);
        roles.put(resetRole.getName(), resetRole);

        motivationAgentConfiguration.setDefaultAgentRole(defaultRole);
        motivationAgentConfiguration.setAgentRoles(roles);
    }

}
