package com.besa.PwAAgent.agent.tasks.RutinaEjercicio;

import rational.mapping.Believes;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.besa.PwAAgent.agent.goals.action.RutinaEjercicioContext;
import com.besa.PwAAgent.db.model.Ejercicio;
import com.besa.PwAAgent.db.model.Historial;
import com.besa.PwAAgent.db.model.userprofile.PwAExerciseProfile;
import com.besa.PwAAgent.db.model.userprofile.PwAMedicalContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;

public class ExportarHistorial extends SRTask {

    private final static String FILENAME = "historialMedicoOutput.txt";
    private boolean puedoProseguir = false;

    public ExportarHistorial() {
        puedoProseguir = false;

        // System.out.println(" (ExportarHistorial) - Task construida.");
    }

    @Override
    public void executeTask(Believes parameters) {
        System.out.println("-------- GUARDANDO HISTORIAL ............");

        boolean newFileFlag = false;
        BeliefAgent blvs = (BeliefAgent) parameters;
        String oldFile = "";
        try {
            File textFile = new File(FILENAME);
            if (!textFile.exists()) {
                textFile.createNewFile();
                newFileFlag = true;
            } else {
                newFileFlag = false;
                System.out.println("-------- LEYENDO DOCUMENTO PRIMO ............");
                Scanner reader = new Scanner(textFile);
                while (reader.hasNextLine()) {
                    oldFile += reader.nextLine() + "\n";
                }
                reader.close();
            }
            try (FileWriter writer = new FileWriter(textFile)) {
                String userId = blvs.getActiveUsers().get(0);
                RutinaEjercicioContext context = (RutinaEjercicioContext) blvs.getServiceContext(RutinaEjercicioContext.class);
                PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(userId);
                PwAMedicalContext currPerfilMedico = (PwAMedicalContext)miPerfil.getUserMedicalContext();
                PwAExerciseProfile currPerfilEjercicio = miPerfil.getExerciseProfile();
                Date currDate = new Date();
                if (newFileFlag) {
                    System.out.println("-------- CREANDO DOCUMENTO ............");
                    // -- encontrar edad de PwA. -- //

                    Calendar currDiaCalendar = GregorianCalendar.getInstance();
                    currDiaCalendar.setTime(currDate);
                    int edad = currDiaCalendar.get(Calendar.YEAR);
                    currDiaCalendar.setTime(miPerfil.getFechaNacimiento());
                    edad -= currDiaCalendar.get(Calendar.YEAR);
                    // ----------------------------- //
                    writer.write("Backlog - Historial de Ejercicios\n"
                            + "----------------INFORMACIóN DEL PACIENTE---------------\n"
                            + "Nombre: " + miPerfil.getNombre() + ".\n"
                            + "Apellido: " + miPerfil.getApellido() + ".\n"
                            + "Cedula: " + miPerfil.getCedula() + ".\n"
                            + "Edad: " + edad + ".\n"
                            + "Causa de demencia: " + currPerfilMedico.getCausaDemenciaCondicion().getCondicion()
                            + ".\n"
                            + "Puntaje SPPB: " + currPerfilMedico.getSppb() + ".\n"
                            + "Puntaje Riesgo de Caida: " + currPerfilMedico.getRiesgoCaida() + ".\n"
                            + "----------------HISTORIAL DE EJERCICIOS ---------------\n");

                }
                if (!newFileFlag) {
                    System.out.println("-------- LEYENDO DOCUEMNTO ............");
                    writer.write(oldFile);
                }
                writer.write("----------Sesion del dia " + currDate.toString() + "---------\n");
                String pesoUsado = "N/A";
                String retroGusto = "N/A";
                String retroCans = "N/A";
                System.out.println("-------- LEYENDO  HISTORIAL!!!!!!!!!............");
                for (int i = 0; i < context.getCurrHistorialList().size(); i++) {
                    Historial currHistorial = context.getCurrHistorialList().get(i);
                    System.out.println("-------- ENTRE AL FOR LOOP CON ESTE HISTORIAL: " + currHistorial.getEjercicio()
                            + " !!!!!!!!!............");

                    for (int j = 0; j < currPerfilEjercicio.getEjercicioList().size(); j++) {
                        System.out.println("-------- PESO GUARDADO " + pesoUsado + " !!!!!!!!!............");
                        if (currPerfilEjercicio.getEjercicioList().get(j).getNombre()
                                .equals(currHistorial.getEjercicio())) {
                            Ejercicio currEjercicio = currPerfilEjercicio.getEjercicioList().get(j);
                            for (int k = 0; k < currEjercicio.getCategoriaEntrenamientoList().size(); k++) {
                                if (currEjercicio.getCategoriaEntrenamientoList().get(k).getIntensidadList()
                                        .get(currPerfilEjercicio.getIndexIntensidadActual()).getPeso() != null
                                        && currEjercicio.getNecesitaPeso()) {
                                    pesoUsado = String.valueOf(
                                            currEjercicio.getCategoriaEntrenamientoList().get(k).getIntensidadList()
                                                    .get(currPerfilEjercicio.getIndexIntensidadActual()).getPeso());
                                }
                            }
                        }
                    }
                    System.out.println("-------- PESO GUARDADO " + pesoUsado + " !!!!!!!!!............");
                    if (currHistorial.getRetroalimentacionGusto() != null) {
                        retroGusto = String.valueOf(currHistorial.getRetroalimentacionGusto());
                    }
                    if (currHistorial.getRetroalimentacionCansancio() != null) {
                        retroCans = String.valueOf(currHistorial.getRetroalimentacionCansancio());
                    }
                    System.out.println("-------- PESO GUARDADO " + pesoUsado + " !!!!!!!!!............");
                    System.out.println("-------- RETROGUSTO GUARDADO " + retroGusto + " !!!!!!!!!............");
                    System.out.println("-------- RETROCANS GUARDADO " + retroCans + " !!!!!!!!!............");
                    System.out.println("-------- EESTOY ANTES DEL LOOP ............");
                    writer.write(" -----------------------\n"
                            + "Nombre del Ejercicio: " + currHistorial.getEjercicio() + ".\n"
                            + "Repeticiones realizadas : " + currHistorial.getRepeticionesHechas() + ".\n"
                            + "Retroalimentación de Gusto(1 - 3): " + retroGusto + ".\n"
                            + "Retroalimentación de Cansancio (1 - 3): " + retroCans + ".\n"
                            + "Peso usado: " + pesoUsado + ".\n"
                            + "Notas: " + currHistorial.getNotas() + ".\n");
                    System.out.println("-------- ESCRIBIO LO NECESARIO EN EL HISTORIAL EN EL LOOP ............");
                }
                writer.write("-------------------------------------------\n");
                System.out.println("--------QUEDO GUARDADO EL HISTORIAL ............");
            }

        } catch (IOException e) {
            System.out.println("An error has ocurred in creating a historial File following this: " + e.getMessage());
        }
        puedoProseguir = true;
    }

    @Override
    public void interruptTask(Believes believes) {
        System.out.println("ExportarHistorial - Interrumpido. ");
    }

    @Override
    public void cancelTask(Believes believes) {
        System.out.println("ExportarHistorial - Cancelado. ");
    }

    @Override
    public boolean checkFinish(Believes believes) {
        return puedoProseguir;
    }

}
