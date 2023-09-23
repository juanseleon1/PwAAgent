package com.besa.PwAAgent.db.model.userprofile;

import BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.Context.UserContext;

public class PwAUserContext extends UserContext{
    private PwAExerciseProfile exerciseProfile;
    public PwAExerciseProfile getExerciseProfile() {
        return exerciseProfile;
    }

}
