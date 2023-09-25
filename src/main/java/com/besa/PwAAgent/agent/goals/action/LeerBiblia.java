package com.besa.PwAAgent.agent.goals.action;

import java.util.ArrayList;
import java.util.List;

import com.besa.PwAAgent.agent.tasks.LeerBiblia.AnimarAActividad;
import com.besa.PwAAgent.agent.tasks.LeerBiblia.LeerVersiculo;
import com.besa.PwAAgent.agent.tasks.LeerBiblia.PreguntarOpinion;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.ServiceGoal;
import rational.RationalRole;
import rational.mapping.Believes;
import rational.mapping.Plan;
import rational.mapping.Task;

public class LeerBiblia extends ServiceGoal<LeerBibliaContext>{
    private static String descrip = "Medicamentos";


     public static LeerBiblia buildGoal(BeliefAgent beliefAgent) {
        AnimarAActividad retro = new AnimarAActividad();
        LeerVersiculo recomCuento = new LeerVersiculo();
        PreguntarOpinion preguntarOpinion = new PreguntarOpinion();

        List<Task> taskList;
        Plan rolePlan = new Plan();

        rolePlan.addTask(retro);

        taskList = new ArrayList<>();
        taskList.add(retro);
        rolePlan.addTask(recomCuento, taskList);


        taskList = new ArrayList<>();
        taskList.add(recomCuento);
        rolePlan.addTask(preguntarOpinion, taskList);

        RationalRole bibliaRole = new RationalRole(descrip, rolePlan);
        LeerBiblia b = new LeerBiblia(MotivationAgent.getPlanID(), bibliaRole, beliefAgent);
        return b;
    }

    public LeerBiblia(int id, RationalRole role, BeliefAgent beliefAgent) {
        super(id, role, descrip, 0, beliefAgent, new LeerBibliaContext());
    }

    @Override
    public double detectGoal(Believes arg0) throws KernellAgentEventExceptionBESA {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'detectGoal'");
    }

    @Override
    public double evaluateContribution(StateBDI arg0) throws KernellAgentEventExceptionBESA {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evaluateContribution'");
    }

    @Override
    public double evaluatePlausibility(Believes arg0) throws KernellAgentEventExceptionBESA {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evaluatePlausibility'");
    }

    @Override
    public double evaluateViability(Believes arg0) throws KernellAgentEventExceptionBESA {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evaluateViability'");
    }

    @Override
    public boolean goalSucceeded(Believes arg0) throws KernellAgentEventExceptionBESA {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'goalSucceeded'");
    }

    @Override
    public boolean predictResultUnlegality(StateBDI arg0) throws KernellAgentEventExceptionBESA {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'predictResultUnlegality'");
    }

    @Override
    public double calculateCriticality() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateCriticality'");
    }
    
}
