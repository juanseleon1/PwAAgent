package com.besa.PwAAgent.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.besa.PwAAgent.db.model.Horario;

public interface HorarioRepository extends JpaRepository<Horario, Integer>{
    
}
