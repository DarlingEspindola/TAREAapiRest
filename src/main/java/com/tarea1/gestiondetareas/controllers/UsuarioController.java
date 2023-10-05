package com.tarea1.gestiondetareas.controllers;


import com.tarea1.gestiondetareas.models.Usuario;
import com.tarea1.gestiondetareas.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsuarioController {


    @Autowired
    UsuarioServiceImpl usuarioService;

    @RequestMapping(value = "/lista_usuarios",method = RequestMethod.GET)
    public String enlistarUsuario(Model model){
        List<Usuario> listaDeUsuarios = usuarioService.listaDeUsuarios();
        model.addAttribute("lista_usuarios", listaDeUsuarios);
        return "lista_usuarios";
    }



    @GetMapping("/registro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/nuevo")
    public String guardarUsuario(@ModelAttribute Usuario nuevoUsuario){
        usuarioService.guardarUsuario(nuevoUsuario);
        return "redirect:/usuarios";
    }

    @PostMapping("/borrar/{id}")
    public String borrarUsuarioPorId(@PathVariable Long id){
        usuarioService.borrarUsuario(id);
        return  "redirect:/usuarios";
    }

    @PostMapping("/editar/{id}")
    public String editarUsuarioPorId(@PathVariable Long id, Usuario usuarioActualizado){
        usuarioService.editarUsuarioPorId(id,usuarioActualizado);
return  editarUsuarioPorId(id,usuarioActualizado);
    }
}
