package com.besa.PwAAgent;

import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapterReceiver;

public class PepperMessageAdapterReceiver extends SRAdapterReceiver implements Runnable{
    private Scanner scanner;
    protected AtomicBoolean ready;
    private  Set<Double> queries;
    public PepperMessageAdapterReceiver(Scanner scanner,  Set<Double> queries) {
        this.scanner = scanner;
        ready = new AtomicBoolean(true);
    }

    @Override
    public void setup() {
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {

        //while (ready.get()) {
        //    try {
        //        int answer = scanner.nextInt();
        //        Thread t1 = new Thread() {
        //            @Override
        //            public void run() {
        //                RobotReplyData reply;
        //                try {
        //                    RobotReplyData data = new RobotReplyData( new RobotData(answer, getName(), getName(), null)), );
        //                    reply = objectMapper.readValue(json, RobotReplyData.class);
        //                    handleRobotData(reply);
        //                } catch (JsonProcessingException e) {
        //                    e.printStackTrace();
        //                } catch (ExceptionBESA e) {
        //                    e.printStackTrace();
        //                }
        //            }
        //        };
        //        t1.start();
        //    } catch (IOException ex) {
        //        Logger.getLogger(PepperAdapterReceiver.class.getName()).log(Level.SEVERE, null, ex);
        //    }
        //}
//
    }//


     public synchronized Set<Double> getQueries() {
        return queries;
    }

    public void setQueries(Set<Double> queries) {
        this.queries = queries;
    }

}
