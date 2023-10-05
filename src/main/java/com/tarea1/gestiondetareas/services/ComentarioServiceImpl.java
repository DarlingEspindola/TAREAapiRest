package com.tarea1.gestiondetareas.services;

import com.tarea1.gestiondetareas.models.Comentario;

import com.tarea1.gestiondetareas.repository.ComentarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    ComentarioRepository comentarioRepository;

    @Override
    public List<Comentario> listaDeComentarios() {
        return comentarioRepository.findAll();
    }

    @Override
    public Comentario guardarComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public void borrarComentario(Long id) {
        comentarioRepository.deleteById(id);
    }


    @Override
    public Comentario editarComentarioPorId(Long id, Comentario comentarioActualizado) {
        Boolean existe = comentarioRepository.existsById(id);

        if (existe) {

            Comentario comentarioSeleccionado = comentarioRepository.findById(id).get();

            comentarioSeleccionado.setTextoComentario(comentarioActualizado.getTextoComentario());
            comentarioSeleccionado.setFechaCreacionComentario(comentarioActualizado.getFechaCreacionComentario());
            return comentarioRepository.save(comentarioSeleccionado);
        } else {
            System.out.println("El Comentario no existe o el id es inválido");
            return null;
        }

    }

}

