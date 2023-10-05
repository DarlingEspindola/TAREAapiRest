package com.tarea1.gestiondetareas.services;

import com.tarea1.gestiondetareas.models.Tarea;
import com.tarea1.gestiondetareas.models.Usuario;


import java.util.List;

public interface TareaService {

    List<Tarea> listaDeTareas();

    Tarea guardarTarea(Tarea tarea);

    void borrarTarea(Long id);

    Tarea editarTareaPorId(Long id, Tarea tareaActualizada);


}
