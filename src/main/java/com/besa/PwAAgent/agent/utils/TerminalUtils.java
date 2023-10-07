package com.besa.PwAAgent.agent.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import BESA.BDI.AgentStructuralModel.GoalBDI;
import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.BDI.AgentStructuralModel.LatentGoalStructure.LatentGoal;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.ServiceGoal;
import BESA.SocialRobot.ExplainabilityAgent.agent.ExplainabilityAgentState;
import BESA.SocialRobot.ServiceProvider.agent.adapter.RobotData;
import BESA.SocialRobot.ServiceProvider.agent.guard.RobotReplyData;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;

public class TerminalUtils implements Runnable {
    private MotivationAgent agent;
    private Scanner scanner;
    private AtomicBoolean ready;
    private Map<String, Double> permissions;
    private MessageAdapterReceiver receiver;
    private List<ServiceGoal<?>> services;
    private ExplainabilityAgentState records;
    private List<LatentGoal> latentGoals;

    public TerminalUtils(MotivationAgent agent, MessageAdapterReceiver receiver) {
        this.agent = agent;
        this.scanner = new Scanner(System.in);
        this.ready = new AtomicBoolean(true);
        this.permissions = new ConcurrentHashMap<>();
        this.receiver = receiver;
    }

    @Override
    public void run() {
        StateBDI state = (StateBDI) agent.getState();
        Set<LatentGoal> latents = state.getMachineBDIParams().getGoalStructure().getLatentGoals();
        Set<GoalBDI> goals = state.getMachineBDIParams().getGoalStructure().getBdiGoals();
        services = new ArrayList<>();
        latentGoals = new ArrayList<>(latents);
        for (GoalBDI goalBDI : goals) {
            if (goalBDI instanceof ServiceGoal) {
                services.add((ServiceGoal<?>) goalBDI);
            }
        }

        while (ready.get()) {
            write("Seleccione la meta:");
            write("1. Aprobar Permisos");
            write("2. Cambiar Objetivo del Agente");
            write("3. Ver Proceso de Toma de Decisiones");
            write("4. Activar Metas");
            write("-1. Salir");

            System.out.print("Seleccione: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    approvePermissions();
                    break;
                case 2:
                    changeLatentGoals();
                    break;
                case 3:
                    showReasoning();
                    break;
                case 4:
                    activateBDIGoals();
                    break;
                case -1:
                    ready.set(false);
                    break;
                default:
                    break;
            }

        }

    }

    private void activateBDIGoals() {
        boolean exit = false;
        while (!exit) {
            int i = 1;
            for (ServiceGoal<?> serviceGoal : services) {
                write(i + ". " + serviceGoal.getClass().getSimpleName() + "Estado: "
                        + (serviceGoal.isAuthorized() ? "Activa" : "Desactivada"));
                i++;
            }
            write("-1. Salir");

            int meta = scanner.nextInt();
            if (meta != -1) {
                write("1. Activar Meta");
                write("2. Desactivar Meta");
                write("-1. Menu Anterior");

                int res = scanner.nextInt();
                if (res != -1) {
                    services.get(meta - 1).setAuthorized(res == 1);
                }
            }
            if (meta == -1) {
                exit = true;
            }
        }

    }

    private void showReasoning() {
    }

    private void changeLatentGoals() {
        boolean exit = false;
        while (!exit) {
            int i = 1;
            for (LatentGoal goal : latentGoals) {
                write(i + ". " + goal.getClass().getSimpleName() + "Estado: "
                        + (goal.isAuthorized() ? "Activa" : "Desactivada"));
                i++;
            }
            write("-1. Salir");

            int meta = scanner.nextInt();
            if (meta != -1) {
                write("1. Activar Meta");
                write("2. Desactivar Meta");
                write("-1. Menu Anterior");

                int res = scanner.nextInt();
                if (res != -1) {
                    latentGoals.get(meta - 1).setAuthorized(res == 1);
                }
            }
            if (meta == -1) {
                exit = true;
            }
        }
    }

    private void approvePermissions() {
        write("Permisos Pendientes");
        int i = 0;
        Set<String> keySet = permissions.keySet();
        List<String> keyList = new ArrayList<>(keySet);

        for (String entry : keyList) {
            write(i + ". " + entry);
            i++;
        }
        write("-1. Menu Anterior");
        int meta = scanner.nextInt();
        if (meta != -1) {
            write("1. Aprobar");
            write("2. Denegar");
            write("-1. Menu Anterior");
            int res = scanner.nextInt();
            if (res != -1) {
                replyToPermission(keyList.get(meta), res==1);
            }
        }
    }

    public void sendPriorityNotification(double ack, String priority, String message) {
        sendPriorityNotification(priority, message);
        RobotData rd = new RobotData(ack, ServiceNames.MESSAGE.name(), "sendMessageResponse", new HashMap<>());
        RobotReplyData data = new RobotReplyData(rd, ack, "sendMessageResponse");
        receiver.sendReply(data);
    }

    public void sendPriorityNotification(String priority, String message) {
        StringBuffer sb = new StringBuffer();
        sb.append(priority.toUpperCase());
        sb.append(": ");
        sb.append(message);
        write(sb.toString());
    }

    public void processPermissionRequest(double ack, String permission) {
        sendPriorityNotification("HIGH", permission);
        permissions.put(permission, ack);
    }

    private synchronized void write(String msg) {
        System.out.println(msg);
    }

    private void replyToPermission(String permission, boolean authorized) {
        double ack = permissions.get(permission);
        Map<String, Object> params = new HashMap<>();
        params.put("permission", permission);
        params.put("authorized", authorized);
        RobotData rd = new RobotData(ack, ServiceNames.MESSAGE.name(), "sendMessageResponse", params);
        RobotReplyData data = new RobotReplyData(rd, ack, "sendMessageResponse");
        receiver.sendReply(data);
    }

    public MotivationAgent getAgent() {
        return agent;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public AtomicBoolean getReady() {
        return ready;
    }

    public Map<String, Double> getPermissions() {
        return permissions;
    }

    public MessageAdapterReceiver getReceiver() {
        return receiver;
    }

    public List<ServiceGoal<?>> getServices() {
        return services;
    }

    public ExplainabilityAgentState getRecords() {
        return records;
    }

    public void setAgent(MotivationAgent agent) {
        this.agent = agent;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setReady(AtomicBoolean ready) {
        this.ready = ready;
    }

    public void setPermissions(Map<String, Double> permissions) {
        this.permissions = permissions;
    }

    public void setReceiver(MessageAdapterReceiver receiver) {
        this.receiver = receiver;
    }

    public void setServices(List<ServiceGoal<?>> services) {
        this.services = services;
    }

    public void setRecords(ExplainabilityAgentState records) {
        this.records = records;
    }

}
