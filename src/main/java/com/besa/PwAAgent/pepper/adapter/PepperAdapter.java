package com.besa.PwAAgent.pepper.adapter;

import java.io.DataOutputStream;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapter;

public class PepperAdapter extends SRAdapter {
    private String robotIP;
    private int robotPort;
    @Autowired
    private ObjectMapper objectMapper;

    public PepperAdapter(String robotIP, int robotPort) {
        super();
        this.robotIP = robotIP;
        this.robotPort = robotPort;
    }

    @Override
    public synchronized void sendRequest(RobotData data) {
        String json;

        try (Socket s = new Socket(robotIP, robotPort);
                DataOutputStream oos = new DataOutputStream(s.getOutputStream())) {
            json = convertServiceRequest(data);
            System.out.println("ENVIANDO \n" + json);
            oos.writeUTF(json + "\n\r");
            oos.flush();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String convertServiceRequest(RobotData data) throws JsonProcessingException {
        PepperSendable s = new PepperSendable(data.getId(), data.getFunction(), data.getFunction(),
                data.getParameters());
        return objectMapper.writeValueAsString(s);
    }

    @Override
    public void setup() {
    }

}
