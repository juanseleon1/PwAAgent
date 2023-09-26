package com.besa.PwAAgent.agent.goals.action;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.ServiceGoal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.besa.PwAAgent.agent.tasks.Retroalimentacion.RecibirRetroalimentacionEjercicio;
import com.besa.PwAAgent.agent.tasks.RutinaEjercicio.ExportarHistorial;
import com.besa.PwAAgent.agent.tasks.RutinaEjercicio.RealizarEjercicios;
import com.besa.PwAAgent.db.model.userprofile.PwAExerciseProfile;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import rational.RationalRole;
import rational.mapping.Believes;
import rational.mapping.Plan;
import rational.mapping.Task;

public class RutinaEjercicio extends ServiceGoal<RutinaEjercicioContext> {

    private final static String DESCRIPTION = "RutinaEjercicio";

    public RutinaEjercicio(int id, RationalRole role) {
        super(id, role, DESCRIPTION, 0, new RutinaEjercicioContext());
    }

    public static RutinaEjercicio buildGoal() {

        RealizarEjercicios tareaEjercicios = new RealizarEjercicios();
        // ProgramarEjercicios progEjercicio = new ProgramarEjercicios();
        // PreguntarPreparacion preparacionEjercicio = new PreguntarPreparacion(
        // "Según mi reloj, nos cae la hora de empezar nuestra rutina de ejercicio! "
        // + ". Ahora, espera un momento, que necesito asegurarme que estemos listo para
        // empezar nuestra jornada.");
        RecibirRetroalimentacionEjercicio retroEjercicio = new RecibirRetroalimentacionEjercicio();
        ExportarHistorial expHistorial = new ExportarHistorial();

        List<Task> taskList;

        Plan rolePlan = new Plan();
        rolePlan.addTask(tareaEjercicios);

        taskList = new ArrayList<>();
        taskList.add(tareaEjercicios);
        rolePlan.addTask(retroEjercicio, taskList);

        taskList = new ArrayList<>();
        taskList.add(retroEjercicio);
        rolePlan.addTask(expHistorial, taskList);

        RationalRole reiActRole = new RationalRole(DESCRIPTION, rolePlan);
        RutinaEjercicio b = new RutinaEjercicio(MotivationAgent.getPlanID(), reiActRole);
        return b;

        // DEBUG: Comentar código anterior y usar este en caso de querer probar solo la
        // rútina de ejercicios.
        /*
         * RealizarEjercicios tareaEjercicios = new RealizarEjercicios();
         * List<String> resources = new ArrayList<>();
         * List<Task> taskList = new ArrayList<>();
         * Plan rolePlan= new Plan();
         * 
         * rolePlan.addTask(tareaEjercicios);
         * 
         * RationalRole rutEjercicioRole = new RationalRole(DESCRIPTION, rolePlan);
         * RutinaEjercicio b = new RutinaEjercicio(InitRESPwA.getPlanID(),
         * rutEjercicioRole,
         * DESCRIPTION, GoalBDITypes.OPORTUNITY);
         * return b;
         * 
         * // --- Debug no. 2. Revise si está funcionando meta interrumpir actividades
         * sin necesitad del sensor.
         * /*
         * RealizarEjercicios tareaEjercicios = new RealizarEjercicios();
         * RealizarEjercicios tareaEjercicios2 = new RealizarEjercicios();
         * InterrumpirActividades interruptAct = new InterrumpirActividades();
         * List<Task> taskList;
         * 
         * Plan rolePlan = new Plan();
         * rolePlan.addTask(tareaEjercicios);
         * 
         * taskList = new ArrayList<>();
         * taskList.add(tareaEjercicios);
         * rolePlan.addTask(interruptAct, taskList);
         * 
         * taskList = new ArrayList<>();
         * taskList.add(interruptAct);
         * rolePlan.addTask(tareaEjercicios2, taskList);
         * 
         * RationalRole reiActRole = new RationalRole(DESCRIPTION, rolePlan);
         * RutinaEjercicio b = new RutinaEjercicio(InitRESPwA.getPlanID(), reiActRole,
         * DESCRIPTION, GoalBDITypes.OPORTUNITY);
         * return b;
         */

    }

    @Override
    public double evaluateViability(Believes believes) throws KernellAgentEventExceptionBESA {
        return 1;
    }

    @Override
    public double evaluatePlausibility(Believes believes) throws KernellAgentEventExceptionBESA {
        // System.out.println("Meta MantenerAtencionPwA evaluatePlausibility");
        return 1;
    }

    @Override
    public double detectGoal(Believes believes) throws KernellAgentEventExceptionBESA {
        BeliefAgent blvs = (BeliefAgent) believes;
        String userId = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(userId);
        PwAExerciseProfile miPerfilEjercicio = miPerfil.getExerciseProfile();
        float distance = blvs.getInteractionState().getUserDistance();
        Date currDate = new Date();
        Calendar currDiaCalendar = GregorianCalendar.getInstance();
        currDiaCalendar.setTime(currDate);
        int currHour = currDiaCalendar.get(Calendar.HOUR_OF_DAY);
        if (miPerfilEjercicio != null) {
            if ((distance <= 0.8f) && (distance >= 0)) {
                return 0;
            } else if (!miPerfilEjercicio.getEjercicioList().isEmpty()) {
                if ((miPerfilEjercicio.getFechaProx().equals(currDate)
                        || miPerfilEjercicio.getFechaProx().before(currDate))
                        && miPerfilEjercicio.getHoraProx() <= currHour) {
                    return 1;
                }
                return 1; // Debug, para no probar con fechas.
            }
        }
        return 0;
    }

    @Override
    public double evaluateContribution(StateBDI stateBDI) throws KernellAgentEventExceptionBESA {
        return 1;
    }

    @Override
    public boolean predictResultUnlegality(StateBDI agentStatus) throws KernellAgentEventExceptionBESA {
        return true;
    }

    @Override
    public boolean goalSucceeded(Believes believes) throws KernellAgentEventExceptionBESA {
        return false;
    }

    @Override
    public double calculateCriticality(Believes arg0) {
        return 1;
    }

}
