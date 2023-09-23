package com.besa.PwAAgent.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.besa.PwAAgent.db.model.PreferenciaXCuento;
import com.besa.PwAAgent.db.model.PreferenciaXCuentoPK;

public interface TalePreferencesRepository extends JpaRepository<PreferenciaXCuento, PreferenciaXCuentoPK>{
    
}
