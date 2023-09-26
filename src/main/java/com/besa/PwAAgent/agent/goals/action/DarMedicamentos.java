package com.besa.PwAAgent.agent.goals.action;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.besa.PwAAgent.agent.tasks.DarMedicamentos.EsperarConfirmacion;
import com.besa.PwAAgent.agent.tasks.DarMedicamentos.RecordarSobreMedicamentos;
import com.besa.PwAAgent.db.model.userprofile.FranjaMedicamento;
import com.besa.PwAAgent.db.model.userprofile.PwAMedicalContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.Kernel.Agent.Event.KernellAgentEventExceptionBESA;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srbdi.ServiceGoal;
import rational.RationalRole;
import rational.mapping.Believes;
import rational.mapping.Plan;
import rational.mapping.Task;

public class DarMedicamentos extends ServiceGoal<DarMedicamentosContext> {
    private static String descrip = "Medicamentos";

    public static DarMedicamentos buildGoal() {
        RecordarSobreMedicamentos retro = new RecordarSobreMedicamentos();
        EsperarConfirmacion recomCuento = new EsperarConfirmacion();

        List<Task> taskList;
        Plan rolePlan = new Plan();

        rolePlan.addTask(retro);

        taskList = new ArrayList<>();
        taskList.add(retro);
        rolePlan.addTask(recomCuento, taskList);

        RationalRole medicamentoRole = new RationalRole(descrip, rolePlan);
        DarMedicamentos b = new DarMedicamentos(MotivationAgent.getPlanID(), medicamentoRole);
        return b;
    }

    public DarMedicamentos(int id, RationalRole role) {
        super(id, role, descrip, 100, new DarMedicamentosContext());
    }

    @Override
    public double detectGoal(Believes beliefs) throws KernellAgentEventExceptionBESA {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        PwAMedicalContext medicalContext = miPerfil.getUserMedicalContext();
        return medicalContext.getTomaMedicamentos();
    }

    @Override
    public double evaluateContribution(StateBDI stateBDI) throws KernellAgentEventExceptionBESA {
        BeliefAgent blvs = (BeliefAgent) stateBDI.getBelieves();
        String currUser = blvs.getActiveUsers().get(0);
        PwAProfile miPerfil = (PwAProfile) blvs.getUserProfile(currUser);
        double result = 0;
        PwAMedicalContext medicalContext = miPerfil.getUserMedicalContext();
        
        LocalTime now = LocalTime.now();
        FranjaMedicamento franja = null;
        
        for (FranjaMedicamento franjas : medicalContext.getFranjaMedicamentoList()) {
            
            if (now.isBefore(franjas.getHora().minusMinutes(5))) {
                franja = franjas;
                break;
            }
        }

        if(franja != null){
            result+=1;
        }
        return result;
    }

    @Override
    public double evaluatePlausibility(Believes beliefs) throws KernellAgentEventExceptionBESA {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        List<String> users = blvs.getActiveUsers();
        return users != null && users.size() > 0 ? 1 : 0;
    }

    @Override
    public double evaluateViability(Believes beliefs) throws KernellAgentEventExceptionBESA {
        return 1;
    }

    @Override
    public boolean goalSucceeded(Believes beliefs) throws KernellAgentEventExceptionBESA {
        BeliefAgent blvs = (BeliefAgent) beliefs;
        DarMedicamentosContext context = (DarMedicamentosContext)blvs.getServiceContext(DarMedicamentosContext.class);
        return context.isConfirmacionMedicamentos();
    }

    @Override
    public boolean predictResultUnlegality(StateBDI stateBDI) throws KernellAgentEventExceptionBESA {
        return true;
    }

    @Override
    public double calculateCriticality(Believes believes) {
        return 1;
    }

}
