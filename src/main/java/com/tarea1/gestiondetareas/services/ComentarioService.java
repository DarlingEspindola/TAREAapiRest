package com.tarea1.gestiondetareas.services;

import com.tarea1.gestiondetareas.models.Comentario;

import java.util.List;

public interface ComentarioService {

    List<Comentario> listaDeComentarios();

    Comentario guardarComentario(Comentario comentario);

    void  borrarComentario(Long id);

    Comentario editarComentarioPorId(Long id, Comentario comentarioActualizado);


}
