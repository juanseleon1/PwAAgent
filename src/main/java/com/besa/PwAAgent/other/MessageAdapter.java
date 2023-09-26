package com.besa.PwAAgent.other;

import java.util.Scanner;
import java.util.Set;

import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRAdapter;

public class MessageAdapter extends SRAdapter{
    private Scanner scanner;
    private Set<Double> queries; 

    public MessageAdapter(Scanner scanner, Set<Double> queries) {
        this.scanner = scanner;
        this.queries = queries;
    }

    @Override
    public void sendRequest(RobotData data) {
        String toPrint = (String)data.getParameters().get("content");
        System.out.println(toPrint);
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

    public synchronized Set<Double> getQueries() {
        return queries;
    }

    public void setQueries(Set<Double> queries) {
        this.queries = queries;
    }

    

}
