package com.tarea1.gestiondetareas.controllers;

import com.tarea1.gestiondetareas.models.Comentario;

import com.tarea1.gestiondetareas.services.ComentarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioRestController {

    @Autowired
    ComentarioServiceImpl comentarioService;

    @GetMapping("/listaComentario")
    public List<Comentario> listaComentarios() {
        List<Comentario> mostrarListaComentario = comentarioService.listaDeComentarios();
        return mostrarListaComentario;
    }

    @PostMapping("/comentario/nuevo")
    public Comentario guardarNuevoComentario(@RequestBody Comentario comentarioNuevo) {
        Comentario comentarioParaGuardar = comentarioService.guardarComentario(comentarioNuevo);
        return comentarioParaGuardar;

    }

    @DeleteMapping("/comentario/borrar")//localhost:8080/api/estudiante/borrar?id=2
    public String borrarComentarioPorId(@RequestParam Long id) {
        comentarioService.borrarComentario(id);
        return "El comentario ha sido borrado";
    }
    @PutMapping("/comentario/editar/{id}")
    public Comentario editarComentarioPorId(@PathVariable Long id,
                                         @RequestBody Comentario comentarioActualizado) {
        Comentario comentarioEditado = comentarioService.editarComentarioPorId(id,
                comentarioActualizado);

        return comentarioEditado;
    }
}
