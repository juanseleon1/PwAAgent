package com.besa.PwAAgent.agent.tasks.Retroalimentacion;

import rational.mapping.Believes;
import java.util.HashMap;
import com.besa.PwAAgent.agent.goals.MusicoTerapia;
import com.besa.PwAAgent.agent.goals.MusicoTerapiaContext;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;


public class RecibirRetroalimentacionEjercicio extends SRTask {

    private HashMap<String, Object> infoServicio = new HashMap<>();
    private int num;

    public RecibirRetroalimentacionEjercicio() {

        num = 0;
//        System.out.println("--- Task Recibir Retroalimentacion Iniciada ---"); TODO
    }

    @Override
    public void executeTask(Believes parameters) {
        System.out.println("--- Execute Task Recibir Retroalimentacion ---");
        BeliefAgent blvs = (BeliefAgent) parameters;
                MusicoTerapiaContext musicoTerapiaContext = (MusicoTerapiaContext) blvs.getServiceContext(MusicoTerapia.class);

        //if (blvs.getbEstadoInteraccion().getRetroalimentacionValue() == null) {
        //    System.out.println("No tengo mis respuestas!...");
        //    if (blvs.getbEstadoInteraccion().isTopicoActivo(PepperTopicsNames.RETROEJERTOPIC)) {
        //        if (num == 1) {
        //            System.out.println("HOLA 3 " + num + "  " + blvs.getbEstadoInteraccion().getRetroalimentacionValue());
        //            infoServicio = new HashMap<>();
        //            infoServicio.put("content", "Podria hacerte una pregunta?");
        //            srb = ServiceRequestBuilder.buildRequest(VoiceServiceRequestType.SAY, infoServicio);
        //            ResPwaUtils.requestService(srb, blvs);
        //            num++;
        //        }
        //        num++;
        //    }
        //    setTaskWaitingForExecution();
//
        //} else {
        //    System.out.println("Tengo mis respuestas!...");
        //    String retroalimentacion = blvs.getbEstadoInteraccion().getRetroalimentacionValue(); //TODO - Cambiar Python
        //    List<String> resulset = Arrays.asList(retroalimentacion.split(" "));
        //    if (resulset != null) {
//
        //        for (int i = 0; i < blvs.getbEstadoInteraccion().getCurrHistorialList().size(); i++) {
        //            Historial auxHist = blvs.getbEstadoInteraccion().getCurrHistorialList().get(i);
//
        //            auxHist.setRetroalimentacionGusto(CheckRetroValue(resulset.get(0)));
        //            if (resulset.size() > 1) {
        //                auxHist.setRetroalimentacionCansancio(CheckRetroValue(resulset.get(1)));
        //            }
        //            blvs.getbEstadoInteraccion().updateHistorialList(auxHist, i);
        //            RESPwABDInterface.updateHistorial(auxHist);
        //        }
//
        //    } else {
        //        setTaskWaitingForExecution();
        //    }
        //}

    }

    private int CheckRetroValue(String frase) {
        switch (frase.toLowerCase()) {
            case "uno":
                return 1;
            case "dos":
                return 2;
            case "tres":
                return 3;
            default:
                return 0;
        }
    }

    @Override
    public void interruptTask(Believes believes) {
        System.out.println("--- Interrupt Task Recibir Retroalimentacion ---");
        //BeliefAgent blvs = (BeliefAgent) believes;
    }

    @Override
    public void cancelTask(Believes believes) {
        System.out.println("--- Cancel Task Recibir Retroalimentacion ---");
        //BeliefAgent blvs = (BeliefAgent) believes;
    }

    @Override
    public boolean checkFinish(Believes believes) {
        System.out.println("Chequee finish - RecibirRetroEjercicio");
        BeliefAgent blvs = (BeliefAgent) believes;
        //System.out.println("¿Está mi tópico de retro activo? " + blvs.getbEstadoInteraccion().isTopicoActivo(PepperTopicsNames.RETROEJERTOPIC));
        //if (!blvs.getbEstadoInteraccion().isTopicoActivo(PepperTopicsNames.RETROEJERTOPIC) && blvs.getbEstadoInteraccion().getRetroalimentacionValue() != null) {
        //    blvs.getbEstadoInteraccion().setRetroalimentacionValue(null);
        //    System.out.println("Terminé mi retroalimentación...");
        //    num = 0;
        //    return true;
        //}
        return false;
    }

}
