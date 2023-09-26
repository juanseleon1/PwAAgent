package com.besa.PwAAgent.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.besa.PwAAgent.db.model.ProgramaEjercicio;

public interface ExerciseProgramsRepository extends JpaRepository<ProgramaEjercicio, String>{
    
}
