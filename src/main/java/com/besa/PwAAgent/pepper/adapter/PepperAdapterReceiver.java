package com.besa.PwAAgent.pepper.adapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import BESA.Exception.ExceptionBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapterReceiver;
import BESA.SocialRobot.ServiceProvider.agent.guard.RobotReplyData;

public class PepperAdapterReceiver extends SRAdapterReceiver implements Runnable {
    @Autowired
    private ObjectMapper objectMapper;
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
            System.out.println("PepperAdapterReceiver setup with port: " + port);
            ss = new ServerSocket(port);
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
                            reply = objectMapper.readValue(json, RobotReplyData.class);
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
