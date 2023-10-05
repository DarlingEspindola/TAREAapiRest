package com.tarea1.gestiondetareas.controllers;

import com.tarea1.gestiondetareas.models.Usuario;
import com.tarea1.gestiondetareas.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/listaUsuarios")
    public List<Usuario> listaUsuarios(){
        List<Usuario> mostrarListaUsuario= usuarioService.listaDeUsuarios();
        return mostrarListaUsuario;
    }

    @PostMapping("/usuario/nuevo")
    public Usuario guardarNuevoUsuario(@RequestBody Usuario usuarioNuevo) {
        Usuario usuarioParaGuardar = usuarioService.guardarUsuario(usuarioNuevo);
        System.out.println(usuarioParaGuardar.getNombreUsuario());
        return usuarioParaGuardar;

    }


    @DeleteMapping("/usuario/borrar")
        public String borrarUsuarioPorId(@RequestParam Long id) {
        usuarioService.borrarUsuario(id);
        return "El usuario ha sido borrado";
    }


    @PutMapping("/usuario/editar/{id}")
    public Usuario editarEstudiantePorId(@PathVariable Long id,
                                            @RequestBody Usuario usuarioActualizado) {
        Usuario usuarioEditado = usuarioService.editarUsuarioPorId(id,
                usuarioActualizado);

        return usuarioEditado;
    }


    @GetMapping("/usuario/{id}")
    public Usuario usuarioPorId(@PathVariable Long id){
        Usuario usuarioMostrar = usuarioService.buscarUsuarioPorId(id);
        return  usuarioMostrar;
    }

}
