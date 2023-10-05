package com.tarea1.gestiondetareas.repository;


import com.tarea1.gestiondetareas.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {





}
