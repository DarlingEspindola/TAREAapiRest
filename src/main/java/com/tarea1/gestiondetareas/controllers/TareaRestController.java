package com.tarea1.gestiondetareas.controllers;

import com.tarea1.gestiondetareas.models.Tarea;
import com.tarea1.gestiondetareas.services.TareaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarea")
public class TareaRestController {

    @Autowired
    TareaServiceImpl tareaService;

    @GetMapping("/listaTarea")
    public List<Tarea> listaTareas(){
        List<Tarea> mostrarListaTarea= tareaService.listaDeTareas();
        return mostrarListaTarea;

    }
    @PostMapping("/tarea/nueva")
    public  Tarea guardarNuevaTarea(@RequestBody Tarea tareaNueva) {
        Tarea tareaParaGuardar = tareaService.guardarTarea(tareaNueva);
        return tareaParaGuardar;
    }

    @DeleteMapping("/tarea/borrar")
    public String borrarTareaPorId(@RequestParam Long id) {
        tareaService.borrarTarea(id);
        return "La tarea ha sido borrada";
    }
}
