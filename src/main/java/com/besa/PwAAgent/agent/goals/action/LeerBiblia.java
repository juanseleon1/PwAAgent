package com.besa.PwAAgent.agent.goals.action;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.besa.PwAAgent.agent.tasks.LeerBiblia.AnimarAActividad;
import com.besa.PwAAgent.agent.tasks.LeerBiblia.CerrarActividadEspiritual;
import com.besa.PwAAgent.agent.tasks.LeerBiblia.PrepararActividadEspiritual;
import com.besa.PwAAgent.agent.tasks.LeerBiblia.RealizarActividadEspiritual;
import com.besa.PwAAgent.db.model.userprofile.PwAPreferenceContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;
import com.besa.PwAAgent.db.model.userprofile.Religion;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.ServiceGoal;
import rational.RationalRole;
import rational.mapping.Believes;
import rational.mapping.Plan;
import rational.mapping.Task;

public class LeerBiblia extends ServiceGoal<LeerBibliaContext> {
    private static String descrip = "LeerBiblia";

    public static LeerBiblia buildGoal() {
        AnimarAActividad retro = new AnimarAActividad();
        RealizarActividadEspiritual recomCuento = new RealizarActividadEspiritual();
        PrepararActividadEspiritual preparar = new PrepararActividadEspiritual();
        CerrarActividadEspiritual cerrar = new CerrarActividadEspiritual();

        List<Task> taskList;
        Plan rolePlan = new Plan();

        rolePlan.addTask(retro);

        taskList = new ArrayList<>();
        taskList.add(retro);
        rolePlan.addTask(preparar, taskList);

        taskList = new ArrayList<>();
        taskList.add(preparar);
        rolePlan.addTask(recomCuento, taskList);

        taskList = new ArrayList<>();
        taskList.add(recomCuento);
        rolePlan.addTask(cerrar, taskList);

        RationalRole bibliaRole = new RationalRole(descrip, rolePlan);
        LeerBiblia b = new LeerBiblia(MotivationAgent.getPlanID(), bibliaRole);
        return b;
    }

    public LeerBiblia(int id, RationalRole role) {
        super(id, role, descrip, 0, new LeerBibliaContext());
    }

    @Override
    public double detectGoal(Believes beliefs) throws KernellAgentEventExceptionBESA {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        PwAPreferenceContext preferenceContext = miPerfil.getPwAPreferenceContext();
        LocalTime now = LocalTime.now();
        LocalTime lastActivity = preferenceContext.getLastSpiritualActivity();
        if (lastActivity == null) {
            lastActivity = LocalTime.now().minusHours(7);
        }
        Religion religion = preferenceContext.getReligion();
        Duration duration = Duration.between(lastActivity, now).abs();
        int level = preferenceContext.getNivelReligioso();

        boolean activityNeeded = level != 0 && duration.toMinutes() > getMaxTime(level);
        return (!religion.getName().equalsIgnoreCase("ateo") && activityNeeded) ? 1 : 0;
    }

    private long getMaxTime(int level) {
        long time = 0;
        switch (level) {
            case 5:
                time = 60;
                break;
            case 4:
                time = 120;

                break;
            case 3:
                time = 180;

                break;
            case 2:
                time = 360;

                break;
            case 1:
                time = 720;

                break;
            default:
                time = Long.MAX_VALUE;
                break;
        }
        return time;
    }

    @Override
    public double evaluateContribution(StateBDI state) throws KernellAgentEventExceptionBESA {
        BeliefAgent blvs = (BeliefAgent) state.getBelieves();
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        PwAPreferenceContext preferenceContext = miPerfil.getPwAPreferenceContext();
        int level = preferenceContext.getNivelReligioso();
        return (level - 0d) / (5d);
    }

    @Override
    public double evaluatePlausibility(Believes beliefs) throws KernellAgentEventExceptionBESA {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        PwAPreferenceContext preferenceContext = miPerfil.getPwAPreferenceContext();
        Religion religion = preferenceContext.getReligion();
        return religion.getName().equalsIgnoreCase("ateo") ? 0 : 1;
    }

    @Override
    public double evaluateViability(Believes beliefs) throws KernellAgentEventExceptionBESA {
        return 1;
    }

    @Override
    public boolean goalSucceeded(Believes beliefs) throws KernellAgentEventExceptionBESA {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        PwAPreferenceContext preferenceContext = miPerfil.getPwAPreferenceContext();
        LocalTime now = LocalTime.now();
        LocalTime lastActivity = preferenceContext.getLastSpiritualActivity();
        if (lastActivity == null) {
            lastActivity = LocalTime.now().minusHours(7);
        }
        Religion religion = preferenceContext.getReligion();
        Duration duration = Duration.between(lastActivity, now).abs();
        int level = preferenceContext.getNivelReligioso();

        boolean activityNeeded = level != 0 && duration.toMinutes() > getMaxTime(level);
        //ReportBESA.debug("goalSucceeded2: " + !(!religion.getName().equalsIgnoreCase("ateo") && activityNeeded));

        return !(!religion.getName().equalsIgnoreCase("ateo") && activityNeeded);
    }

    @Override
    public boolean predictResultUnlegality(StateBDI state) throws KernellAgentEventExceptionBESA {
        return true;
    }

    @Override
    public double calculateCriticality(Believes believes) {
        return 0;
    }

}
