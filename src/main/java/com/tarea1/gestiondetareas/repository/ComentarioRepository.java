package com.tarea1.gestiondetareas.repository;

import com.tarea1.gestiondetareas.models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {





}
