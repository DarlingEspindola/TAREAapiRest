package com.tarea1.gestiondetareas.repository;

import com.tarea1.gestiondetareas.models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository <Tarea, Long>{



}
