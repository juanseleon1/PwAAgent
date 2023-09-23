package com.besa.PwAAgent.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.besa.PwAAgent.db.model.userprofile.PwAExerciseProfile;

public interface PwAExerciseProfileRepository extends JpaRepository<PwAExerciseProfile, String>{
    
}
