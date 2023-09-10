package BESA.PwARobot.agent;

import BESA.BDI.AgentStructuralModel.Agent.LatentGoalStructure;
import BESA.BDI.AgentStructuralModel.AutonomyManager.AutonomyManager;
import BESA.Exception.ExceptionBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.MotivationAgent;

public class PwAAgent extends MotivationAgent{

    public PwAAgent(LatentGoalStructure goalStruct, AutonomyManager autonomyManager, int threshold)
            throws KernelAgentExceptionBESA, ExceptionBESA {
        super(goalStruct, autonomyManager, threshold);
        //TODO Auto-generated constructor stub
    }
    
}
