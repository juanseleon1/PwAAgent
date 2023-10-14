package com.besa.PwAAgent.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.besa.PwAAgent.db.model.ActXPreferencia;
import com.besa.PwAAgent.db.model.ActXPreferenciaPK;

public interface ActivityPreferencesRepository extends JpaRepository<ActXPreferencia, ActXPreferenciaPK>{
    
}
