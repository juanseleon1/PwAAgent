package com.besa.PwAAgent.pepper.adapter;
//TODO: activate and deactivate all services in Pepper
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Map;

import com.besa.PwAAgent.utils.SpringContext;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import BESA.Log.ReportBESA;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapter;

public class PepperAdapter extends SRAdapter {
    private String robotIP;
    private int robotPort;

    public PepperAdapter(String robotIP, int robotPort) {
        super();
        this.robotIP = robotIP;
        this.robotPort = robotPort;
    }

    @Override
    public synchronized void sendRequest(RobotData data) {
        String json;
        ReportBESA.debug("SENDING REQUEST " + data);
        try (Socket s = new Socket(robotIP, robotPort);
                DataOutputStream oos = new DataOutputStream(s.getOutputStream())) {
            json = convertServiceRequest(data);
            ReportBESA.debug("ENVIANDO \n" + json);
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
                (Map<String,Object>)data.getParameters());
        ReportBESA.debug("SENDING sendable " + s);
        return SpringContext.getBean(ObjectMapper.class).writeValueAsString(s);
    }

    @Override
    public void setup() {
    }

}
