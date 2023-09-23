package com.besa.PwAAgent.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

public interface PwAProfileRepository extends JpaRepository<PwAProfile, String> {

}