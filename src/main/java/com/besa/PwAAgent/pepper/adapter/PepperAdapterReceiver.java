package com.besa.PwAAgent.pepper.adapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.besa.PwAAgent.utils.SpringContext;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import BESA.Exception.ExceptionBESA;
import BESA.Log.ReportBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapterReceiver;
import BESA.SocialRobot.ServiceProvider.agent.guard.RobotReplyData;

public class PepperAdapterReceiver extends SRAdapterReceiver implements Runnable {

    protected AtomicBoolean ready;
    protected ServerSocket ss;
    private int port;

    public PepperAdapterReceiver(int port) {
        super();
        ready = new AtomicBoolean(true);
        this.port = port;
    }

    @Override
    public void setup() {
        try {
            ReportBESA.debug("PepperAdapterReceiver setup with port: " + port);
            ss = new ServerSocket(port);
            Thread t = new Thread(this);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        
        while (ready.get()) {
            try {
                Socket s = ss.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String json = in.readLine();
                Thread t1 = new Thread() {
                    @Override
                    public void run() {
                        RobotReplyData reply;
                        try {
                            boolean containsEmo = json.contains("getUserEmotions");
                            if(!containsEmo)
                                ReportBESA.debug("ENTRANDO \n" + json + "\n");
                            reply = SpringContext.getBean(ObjectMapper.class).readValue(json, RobotReplyData.class);
                            if(!containsEmo)
                                ReportBESA.debug("RECIBIENDO \n" + reply + "\n");
                            handleRobotData(reply);
                        } catch (JsonProcessingException e) {
                            e.printStackTrace();
                        } catch (ExceptionBESA e) {
                            e.printStackTrace();
                        }
                    }
                };
                t1.start();
            } catch (IOException ex) {
                Logger.getLogger(PepperAdapterReceiver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
