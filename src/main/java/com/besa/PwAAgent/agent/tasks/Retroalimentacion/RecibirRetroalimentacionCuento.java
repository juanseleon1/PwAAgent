package com.besa.PwAAgent.agent.tasks.Retroalimentacion;


import rational.mapping.Believes;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.besa.PwAAgent.agent.goals.action.CuenteriaContext;
import com.besa.PwAAgent.agent.goals.action.MusicoTerapia;

import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.SRTask;


public class RecibirRetroalimentacionCuento extends SRTask {

    private HashMap<String, Object> infoServicio = new HashMap<>();
    private int num;

    public RecibirRetroalimentacionCuento() {

        num = 0;
    }

    @Override
    public void executeTask(Believes parameters) {
        System.out.println("--- Execute Task Recibir Retroalimentacion ---");
        BeliefAgent blvs = (BeliefAgent) parameters;
        CuenteriaContext cuenteriaContext = (CuenteriaContext) blvs.getServiceContext(MusicoTerapia.class);

        if (cuenteriaContext.getRetroalimentacionValue() == null) {
            //cuenteriaContext.isTopicoActivo(PepperTopicsNames.RETROCUENTOTOPIC)
            if (true) {
                if (num == 1) {
                    System.out.println("HOLA 2 " + num + "  " + cuenteriaContext.getRetroalimentacionValue());
                    infoServicio = new HashMap<>();
                    infoServicio.put("content", "Podria hacerte una pregunta?");
                    infoServicio.put("isQuery", "true");
                    sendActionRequest(infoServicio, "talk");
                    num++;
                }
                num++;
            }
            setTaskWaitingForExecution();

        } else {
            String retroalimentacion = cuenteriaContext.getRetroalimentacionValue();
            List<String> resulset = Arrays.asList(retroalimentacion.split(" "));
            Double respuestaRetroalimentacion = -1.0;
            if (resulset != null) {
                HashMap<String, Long> resultados = new HashMap<>();
                resultados.put("Tres", resulset.stream().filter(retroa -> retroa.equalsIgnoreCase("Tres")).count() * 3);
                resultados.put("Dos", resulset.stream().filter(retroa -> retroa.equalsIgnoreCase("Dos")).count() * 2);
                resultados.put("Uno", resulset.stream().filter(retroa -> retroa.equalsIgnoreCase("Uno")).count());
                Double resulRetroAlimentacion = Double.valueOf(resultados.get("Tres") + resultados.get("Dos") + resultados.get("Uno") / resulset.size());
                if (resulRetroAlimentacion > 2.5) {
                    respuestaRetroalimentacion = 1.0;
                }
                if (resulRetroAlimentacion <= 2.5 && resulRetroAlimentacion >= 1.5) {
                    respuestaRetroalimentacion = 0.5;
                }
                if (resulRetroAlimentacion < 1.5) {
                    respuestaRetroalimentacion = 0.0;
                }

                cuenteriaContext.feedbackActivity(respuestaRetroalimentacion);
                infoServicio = new HashMap<>();
                infoServicio.put("content", "Gracias por tus consejos!");
                sendActionRequest(infoServicio, "talk");
                //ResPwaUtils.deactivateTopic(PepperTopicsNames.RETROCUENTOTOPIC, parameters);

            } else {
                setTaskWaitingForExecution();
            }
        }

    }

    @Override
    public void interruptTask(Believes believes) {
        System.out.println("--- Interrupt Task Recibir Retroalimentacion ---");
    }

    @Override
    public void cancelTask(Believes believes) {
        System.out.println("--- Cancel Task Recibir Retroalimentacion ---");
    }

    @Override
    public boolean checkFinish(Believes believes) {

        BeliefAgent blvs = (BeliefAgent) believes;
        //TODO: !cuenteriaContext.isTopicoActivo(PepperTopicsNames.RETROCUENTOTOPIC)
        if (blvs.getActiveUsers().size()> 1 &&true) {
            //ResPwaUtils.activateTopic(PepperTopicsNames.BLANKATOPIC, believes);
            num = 0;
            return true;
        }
        return false;
    }

}
