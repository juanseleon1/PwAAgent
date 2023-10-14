package com.besa.PwAAgent.agent.goals.action;

import java.util.ArrayList;
import java.util.List;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.ServiceGoal;
import rational.RationalRole;
import rational.mapping.Believes;
import rational.mapping.Plan;
import rational.mapping.Task;

public class CuenteriaSupport extends ServiceGoal<CuenteriaSupportContext> {

    private static String descrip = "CuenteriaSupport";

    public static CuenteriaSupport buildGoal() {
        PreguntarSobreCuento recomCuento = new PreguntarSobreCuento();
        EsperarRespuesta esperar = new EsperarRespuesta();

        Plan rolePlan = new Plan();

        rolePlan.addTask(recomCuento);
        List<Task> taskList = new ArrayList<>();
        taskList.add(recomCuento);
        rolePlan.addTask(esperar, taskList);

        RationalRole cuenteriaRole = new RationalRole(descrip, rolePlan);
        CuenteriaSupport b = new CuenteriaSupport(MotivationAgent.getPlanID(), cuenteriaRole);
        return b;
    }

    public CuenteriaSupport(int id, RationalRole role) {
        super(id, role, descrip, 0, new CuenteriaSupportContext());
    }

    @Override
    public double evaluatePlausibility(Believes beliefs) throws KernellAgentEventExceptionBESA {
        return 1;
    }

    @Override
    public double evaluateViability(Believes beliefs) throws KernellAgentEventExceptionBESA {
        return 1;

    }

    @Override
    public boolean goalSucceeded(Believes beliefs) throws KernellAgentEventExceptionBESA {
        return !this.isAuthorized();
    }

    @Override
    public double detectGoal(Believes beliefs) throws KernellAgentEventExceptionBESA {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        CuenteriaSupportContext context = (CuenteriaSupportContext) blvs.getServiceContext(CuenteriaSupport.class);
        return context.getCurrentLine() - context.getLastLine() > 10 ? 1 : 0;
    }

    @Override
    public boolean predictResultUnlegality(StateBDI state) throws KernellAgentEventExceptionBESA {
        return true;
    }

    @Override
    public double evaluateContribution(StateBDI state) throws KernellAgentEventExceptionBESA {
        return 2;
    }

    @Override
    public double calculateCriticality(Believes beliefs) {
        return 0;
    }

}