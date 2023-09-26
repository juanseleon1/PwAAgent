package com.besa.PwAAgent.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.besa.PwAAgent.db.model.userprofile.PwAPreferenceContext;

public interface PwAPreferenceProfileRepository extends JpaRepository<PwAPreferenceContext, String>{
    
}
