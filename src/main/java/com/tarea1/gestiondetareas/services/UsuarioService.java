package com.tarea1.gestiondetareas.services;

import com.tarea1.gestiondetareas.models.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listaDeUsuarios();

    Usuario guardarUsuario(Usuario usuario);
    void borrarUsuario(Long id);

    Usuario editarUsuarioPorId(Long id, Usuario usuarioActualizado);

    //nuevo
    Usuario buscarUsuarioPorId(Long id);


}
