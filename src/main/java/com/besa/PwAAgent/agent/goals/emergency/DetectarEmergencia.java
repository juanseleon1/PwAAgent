package com.besa.PwAAgent.agent.goals.emergency;

import java.util.ArrayList;
import java.util.List;

import com.besa.PwAAgent.agent.tasks.DetectarEmergencia.BrindarSoporteEmocional;
import com.besa.PwAAgent.agent.tasks.DetectarEmergencia.ReportarEmergenciaCuidador;
import BESA.BDI.AgentStructuralModel.GoalBDI;
import BESA.BDI.AgentStructuralModel.GoalBDITypes;
import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.WorldModel.WorldModel;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import rational.RationalRole;
import rational.mapping.Believes;
import rational.mapping.Plan;
import rational.mapping.Task;

public class DetectarEmergencia extends GoalBDI {

    private static String descrip = "DetectarEmergencia";

    public static DetectarEmergencia buildGoal() {
        ReportarEmergenciaCuidador retro = new ReportarEmergenciaCuidador();
        BrindarSoporteEmocional bse = new BrindarSoporteEmocional();

        List<Task> taskList;
        Plan rolePlan = new Plan();

        rolePlan.addTask(retro);

        taskList = new ArrayList<>();
        taskList.add(retro);
        rolePlan.addTask(bse, taskList);

        RationalRole emergenciaRole = new RationalRole(descrip, rolePlan);
        DetectarEmergencia b = new DetectarEmergencia(MotivationAgent.getPlanID(), emergenciaRole, descrip,
                GoalBDITypes.DUTY);
        return b;
    }

    public DetectarEmergencia(long id, RationalRole role, String description, GoalBDITypes type) {
        super(id, role, description, type);
    }

    @Override
    public double evaluatePlausibility(Believes beliefs) throws KernellAgentEventExceptionBESA {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        WorldModel worldModel = blvs.getWorldModel();
        return worldModel.isAccidentOcurred() ? 1 : 0;
    }

    @Override
    public double evaluateViability(Believes beliefs) throws KernellAgentEventExceptionBESA {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        WorldModel worldModel = blvs.getWorldModel();
        return worldModel.isAccidentOcurred() ? 1 : 0;

    }

    @Override
    public boolean goalSucceeded(Believes beliefs) throws KernellAgentEventExceptionBESA {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        WorldModel worldModel = blvs.getWorldModel();
        return !worldModel.isAccidentOcurred();

    }

    @Override
    public boolean predictResultUnlegality(StateBDI state) throws KernellAgentEventExceptionBESA {
        BeliefAgent blvs = (BeliefAgent) state.getBelieves();
        WorldModel worldModel = blvs.getWorldModel();
        return worldModel.isAccidentOcurred();
    }

    @Override
    public double detectGoal(Believes beliefs) throws KernellAgentEventExceptionBESA {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        WorldModel worldModel = blvs.getWorldModel();
        return worldModel.isAccidentOcurred() ? 1 : 0;

    }

    @Override
    public double evaluateContribution(StateBDI state) throws KernellAgentEventExceptionBESA {
        BeliefAgent blvs = (BeliefAgent) state.getBelieves();
        WorldModel worldModel = blvs.getWorldModel();
        return worldModel.isAccidentOcurred() ? 1 : 0;
    }

}
