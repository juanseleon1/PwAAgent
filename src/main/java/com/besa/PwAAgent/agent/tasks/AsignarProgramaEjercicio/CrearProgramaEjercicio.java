package com.besa.PwAAgent.agent.tasks.AsignarProgramaEjercicio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.besa.PwAAgent.agent.goals.AsignarProgramaEjercicio;
import com.besa.PwAAgent.agent.goals.AsignarProgramaEjercicioContext;
import com.besa.PwAAgent.db.model.Horario;
import com.besa.PwAAgent.db.model.ProgramaEjercicio;
import com.besa.PwAAgent.db.model.userprofile.PwAExerciseProfile;
import com.besa.PwAAgent.db.model.userprofile.PwAMedicalContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import rational.mapping.Believes;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;


public class CrearProgramaEjercicio extends SRTask {

    private HashMap<String, Object> infoServicio = new HashMap<>();
    Scanner scan;
    boolean puedoProseguir;

    public CrearProgramaEjercicio() {
        System.out.println(" (ProgramarRutina) - Meta construida.");
        scan = new Scanner(System.in);
        puedoProseguir = false;
    }

    @Override
    public void executeTask(Believes parameters) {
        BeliefAgent blvs = (BeliefAgent) parameters;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile)blvs.getUserProfile(currUser);
        int respuesta;
        String userId = miPerfil.getUserContext().getSocioDemoContext().getId();
        PwAMedicalContext medicalContext = (PwAMedicalContext)miPerfil.getUserMedicalContext();
        AsignarProgramaEjercicioContext serviceContext = (AsignarProgramaEjercicioContext) blvs.getServiceContext(AsignarProgramaEjercicio.class);
        if (miPerfil.getExerciseProfile() == null) {
            try {
                //Say - Solo entra acá cuando vé que no tiene un perfil de ejercicio.
                infoServicio = new HashMap<>();
                infoServicio.put("content", "Bienvenidos a mi servicio de programa de ejercicios basado en Vivifrail! "
                        + " Al final de este programa, garantizo que quedaremos fuertes, flexibles y saludables.");
                sendActionRequest(infoServicio, "talk");
                // -- NEW --
                if (medicalContext.getSppb() == null || medicalContext.getRiesgoCaida() == null) {
                    PwAMedicalContext updatedPM = (PwAMedicalContext) miPerfil.getUserMedicalContext();
                    infoServicio.put("content", "Veo que no tengo los datos apropiados para asignar un programa de ejercicio."
                            + "Necesito el resultado de las pruebas SPPB y Caida de Riesgo para asignar mi"
                            + "programa de ejercicio! Porfavor, refiere a la consola de B.D.I para ingresar tus resultados.");
                    sendActionRequest(infoServicio, "talk");
                    infoServicio = new HashMap<>();
                    serviceContext.setExistenPruebasEjercicio(false);
                    // -- Consola Pruebas -- //
                    respuesta = preguntarXConsola(0, 13, "Ahora, ingresa los resultados de la "
                            + "prueba SPPB a en la consola de B.D.I (slash) BESA de cero a doce. Si todavia no tienes las pruebas, cancela ingresando"
                            + " (13).", blvs);
                    if (respuesta == 13) {
                        System.out.println(" Se ha cancelado la creación del perfil de ejercicio. ");
                        serviceContext.setCancelarProgramacionEjercicio(true);
                        return;
                    } else {

                        updatedPM.setSppb(respuesta);
                        respuesta = preguntarXConsola(1, 5, "Genial! Ahora ingresa el puntaje, de uno a cuatro, de riesgo de Caida del PwA"
                                + ", Ingresa cinco para cancelar", blvs);
                        if (respuesta == 5) {
                            System.out.println(" Se ha cancelado la creación del perfil de ejercicio. ");
                            serviceContext.setCancelarProgramacionEjercicio(true);
                            return;
                        } else {
                            updatedPM.setRiesgoCaida(respuesta);
                            System.out.println(" Se ha guardado los valores! ");
                        }
                        //TODO: RESPwABDInterface.updateMedicalProfile(updatedPM);
                        // -- persistir en base de datos.
                    }

                }

                
                respuesta = preguntarXConsola(1, 3, "Listo, Voy a ajustar el nuevo programa para ser realizado todos los dias a las 3 p.m, EST."
                        + "En la consola BESA, ingresa 1 para confirmar, 2 para cambiar e ingresar tu propio horario, y 3 para cancelar.", blvs);

                switch (respuesta) {

                    case 2:
                        respuesta = asignarHorario(blvs);
                        if (respuesta == 3) {
                            System.out.println(" Se ha cancelado la creación del perfil de ejercicio. ");
                            serviceContext.setCancelarProgramacionEjercicio(true);
                            return;
                        }

                        break;

                    case 1:

                        Date date = new Date();
                        Calendar calendar = GregorianCalendar.getInstance();
                        calendar.setTime(date);
                        int hour = calendar.get(Calendar.HOUR_OF_DAY);
                        if (hour > 15) {
                            calendar.add(Calendar.DAY_OF_MONTH, 1);
                        }
                        calendar.set(Calendar.MINUTE, 0);
                        calendar.set(Calendar.SECOND, 0);
                        calendar.set(Calendar.HOUR_OF_DAY, 15);
                        date = calendar.getTime();
                        PwAExerciseProfile nuevoPwAExerciseProfile = new PwAExerciseProfile(userId, 0,
                                date, 15, 0);
                        
                        List<ProgramaEjercicio> misProgramas = serviceContext.getExercisePrograms();
                        for (int i = 0; i < misProgramas.size(); i++) {
                            if (misProgramas.get(i).getNombre().equals("C1")) {
                                nuevoPwAExerciseProfile.setNombrePrograma(misProgramas.get(i));
                            }
                        }
                        
                        //RESPwABDInterface.createExcerciseProfile(nuevoPwAExerciseProfile);
                        miPerfil.setExerciseProfile(nuevoPwAExerciseProfile);
                        miPerfil.setTieneProgramaEjercicio(true);
                        //RESPwABDInterface.updateProfile(miPerfil);
                        miPerfil.updateProfileInBelieves(userId);
                        // --- CREAR HORARIO --- //
                        List<Horario> horario = new ArrayList<>();
                        for (int i = 0; i < 7; i++) {
                            Horario aux = new Horario(i + 1, 15);
                            aux.setCedula(nuevoPwAExerciseProfile);
                            //RESPwABDInterface.createSchedule(aux);
                            horario.add(aux);
                        }
                        nuevoPwAExerciseProfile.setHorarioList(horario);
                        //RESPwABDInterface.updateExcerciseProfile(nuevoPwAExerciseProfile);
                        break;

                    default:
                        System.out.println(" Se ha cancelado la creación del perfil de ejercicio. ");
                        serviceContext.setCancelarProgramacionEjercicio(true);
                        return;

                }
                infoServicio = new HashMap<>();
                infoServicio.put("content", "Muy bien; He finalizado tu creación de perfil de ejercicios! Yupi!");
                sendActionRequest(infoServicio, "talk");
                infoServicio = new HashMap<>();

            } catch (Exception e) {
                System.out.println(e + "...ERROR al Crear perfil!");
            }
        }
        miPerfil.updateProfileInBelieves(userId);
        puedoProseguir = true;
        System.out.println(" (ProgramarRutina) - Meta Ejecutada.");
    }

    @Override
    public void interruptTask(Believes believes) {
        System.out.println(" (ProgramarRutina) - Interrupción de Meta.");
    }

    @Override
    public void cancelTask(Believes believes) {
        System.out.println(" (ProgramarRutina) - Cancelación de Meta.");
    }

    @Override
    public boolean checkFinish(Believes believes) {
        return puedoProseguir == true;
    }

    private int asignarHorario(BeliefAgent blvs) {
        List<Integer> horaList = new ArrayList<>();
        AsignarProgramaEjercicioContext serviceContext = (AsignarProgramaEjercicioContext) blvs.getServiceContext(AsignarProgramaEjercicio.class);
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile)blvs.getUserProfile(currUser);
        String userId = miPerfil.getUserContext().getSocioDemoContext().getId();

        int respuesta = 2;
        while (respuesta == 2) {
            horaList.add(preguntarXConsola(0, 24, "Selecciona una hora desde 0 a 24 para el dia Lunes:", blvs));
            horaList.add(preguntarXConsola(0, 24, "¿para el dia Martes?:", blvs));
            horaList.add(preguntarXConsola(0, 24, "¿para el dia Miercoles?:", blvs));
            horaList.add(preguntarXConsola(0, 24, "¿el Jueves?", blvs));
            horaList.add(preguntarXConsola(0, 24, "Selecciona una hora para el dia Viernes:", blvs));
            horaList.add(preguntarXConsola(0, 24, "Selecciona una hora para el dia Sabado:", blvs));
            horaList.add(preguntarXConsola(0, 24, "Selecciona una hora para el dia Domingo:", blvs));
            respuesta = preguntarXConsola(1, 3, "¿Esta bien el horario que escogiste?"
                    + ". Ingresa en la consola 1 para confirmar, dos para intentar de nuevo, y tres para cancelar.", blvs);

        }
        if (respuesta == 3) {
            System.out.println(" Se ha cancelado la creación del perfil de ejercicio. ");
            serviceContext.setCancelarProgramacionEjercicio(true);
            return respuesta;

        } else {

            Date date = new Date();
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTime(date);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            System.out.println("dia " + dayOfWeek);
            if (hour > horaList.get(dayOfWeek -1)) {
                calendar.add(Calendar.DAY_OF_MONTH, 1);

            }
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.HOUR_OF_DAY, horaList.get(dayOfWeek -1));
            date = calendar.getTime();
            PwAExerciseProfile nuevoPwAExerciseProfile = new PwAExerciseProfile(userId,
                     0, date, horaList.get(dayOfWeek -1), 0);
            List<ProgramaEjercicio> misProgramas = serviceContext.getExercisePrograms();

                        for (int i = 0; i < misProgramas.size(); i++) {
                            if (misProgramas.get(i).getNombre().equals("C1")) {
                                nuevoPwAExerciseProfile.setNombrePrograma(misProgramas.get(i));
                            }
                        }
            //RESPwABDInterface.createExcerciseProfile(nuevoPwAExerciseProfile);
            miPerfil.setExerciseProfile(nuevoPwAExerciseProfile);
            //RESPwABDInterface.updateProfile(blvs.getbPerfilPwA().getPerfil());
            miPerfil.updateProfileInBelieves(userId);
            // -- CREAR HORARIO -- //
            
            System.out.println("y aca?");
            List<Horario> horario = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                Horario aux = new Horario(i + 1, horaList.get(i));
                aux.setCedula(nuevoPwAExerciseProfile);
                //RESPwABDInterface.createSchedule(aux);
                horario.add(aux);
            }
            nuevoPwAExerciseProfile.setHorarioList(horario);
            return 1;
        }

    }

    private int preguntarXConsola(int minLimite, int maxLimite, String pregunta, BeliefAgent blvs) {
        int respuesta = minLimite;
        System.out.println(pregunta);
        infoServicio = new HashMap<>();
        infoServicio.put("content", pregunta);
        sendActionRequest(infoServicio, "talk");
        while (respuesta >= minLimite && respuesta <= maxLimite) {
            while (!scan.hasNextInt()) {
                scan.next();
            }
            respuesta = scan.nextInt();
            if ((respuesta < minLimite) && (respuesta > maxLimite)) {
                System.out.println(" Porfavor ingresa un valor válido. A continuación, vuelve a intentar:");
            } else {
                break;
            }
        }
        return respuesta;
    }
}
