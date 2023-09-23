package com.besa.PwAAgent.db.model.userprofile;


import BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.UserProfile;
import BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.Context.MedicalContext;
import rational.data.InfoData;

public class PwAProfile extends UserProfile{

    @Override
    public boolean update(InfoData arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public PwAExerciseProfile getExerciseProfile() {
        PwAUserContext context = (PwAUserContext)this.getUserContext();
        return context.getExerciseProfile();
    }

    public MedicalContext getUserMedicalContext() {
        return this.getUserContext().getMedicalContext();
    }

    public void setTieneProgramaEjercicio(boolean b) {
    }

    public void setExerciseProfile(PwAExerciseProfile nuevoPwAExerciseProfile) {
    }

    public void updateProfileInBelieves(String userId) {
    }

}
