package com.besa.PwAAgent.agent.tasks.PrepararEjercicio;

import rational.mapping.Believes;
import java.util.HashMap;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;

public class PreguntarPreparacion extends SRTask {

    private HashMap<String, Object> infoServicio = new HashMap<>();
    private final String PREGUNTA;
   // private final int NOPREGUNTAS = 3;
    boolean estoyEsperandoNegacion = false;
    double waitingTimer = 15000;
    //double waitingTimer = 3000;
    //private long start = -1;

    //Constructor: Recibe pregunta que irá a responder. 
    public PreguntarPreparacion(String pregunta) {
        System.out.println(" (PreguntarPreparacion) - Meta construida.");
        this.PREGUNTA = pregunta;
    }

    @Override
    public void executeTask(Believes parameters) {
        //System.out.println(" (PreguntarPreparacion) - Meta ejecutada.");
        BeliefAgent blvs = (BeliefAgent) parameters;
        // -- Llamar Tópico de preparación. -- HUGE TODO

        // -- Terminar la ejecución de la meta -- //
        //blvs.getbEstadoInteraccion().getPreparacionNegada()
        if (blvs.getActiveUsers().isEmpty()) {
            //long now = System.currentTimeMillis();
            System.out.println("Estoy esperando");
            if (!estoyEsperandoNegacion) {
                //ResPwaUtils.deactivateTopic(PepperTopicsNames.PREPARACION, parameters);
                //start = now;
                estoyEsperandoNegacion = true;
            }
           // if ((now - start > waitingTimer) || blvs.getbEstadoInteraccion().getEstoyListoEmpezarPreparacion()) {
           //     estoyEsperandoNegacion = false;
           //     blvs.getbEstadoInteraccion().setEstoyListoEmpezarPreparacion(false);
           //     blvs.getbEstadoInteraccion().resetPreparacionNegada();
           //     System.out.println("Salí!");
           //     blvs.getbEstadoInteraccion().setRespuestasPorContexto(0);
           //     setTaskWaitingForExecution();
           // }
        } else {
            //ResPwaUtils.activateTopic(PepperTopicsNames.PREPARACION, parameters);
            // -- Realiza pregunta inicial para lograr una respuesta del PwA en el tópico. --
            infoServicio = new HashMap<>();
            infoServicio.put("content", PREGUNTA);
            sendActionRequest(infoServicio, "talk");
        }
    }

    @Override
    public void interruptTask(Believes believes) {
        System.out.println(" (PreguntarPreparacion) - Interrupción de Meta.");
        //ResPwaUtils.deactivateTopic(PepperTopicsNames.PREPARACION, believes);
    }

    @Override
    public void cancelTask(Believes believes) {
        System.out.println(" (PreguntarPreparacion) - Cancelación de Meta.");
        //ResPwaUtils.deactivateTopic(PepperTopicsNames.PREPARACION, believes);
    }

    @Override
    public boolean checkFinish(Believes believes) {
        //BeliefAgent blvs = (BeliefAgent) believes;
        //if (blvs.getbEstadoInteraccion().getPreparacionNegada()) {
        //    setTaskWaitingForExecution();
        //    return false;
        //}
        //if (blvs.getbEstadoInteraccion().isTopicoActivo(PepperTopicsNames.PREPARACION)) {
        //    /*System.out.println("¿Se ha negado la preparación?");
        //    System.out.println(blvs.getbEstadoInteraccion().getPreparacionNegada());
        //    System.out.println("Mis respuestas por contexto son:");
        //    System.out.println(blvs.getbEstadoInteraccion().getRespuestasPorContexto());*/
        //    if ((blvs.getbEstadoInteraccion().getRespuestasPorContexto() >= NOPREGUNTAS)
        //            && !blvs.getbEstadoInteraccion().getPreparacionNegada()) {
        //        ResPwaUtils.deactivateTopic(PepperTopicsNames.PREPARACION, believes);
        //        blvs.getbEstadoInteraccion().setRespuestasPorContexto(0);
        //        //blvs.getbEstadoInteraccion().setPreparadoEjercicio(true);
        //        
        //        return true;
        //    }
        //}
        return false;
    }
}
