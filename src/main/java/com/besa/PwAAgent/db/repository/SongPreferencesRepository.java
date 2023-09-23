package com.besa.PwAAgent.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.besa.PwAAgent.db.model.PreferenciaXCancion;
import com.besa.PwAAgent.db.model.PreferenciaXCancionPK;

public interface SongPreferencesRepository extends JpaRepository<PreferenciaXCancion, PreferenciaXCancionPK>{
    
}
