package com.tarea1.gestiondetareas.services;
import com.tarea1.gestiondetareas.models.Tarea;
import com.tarea1.gestiondetareas.repository.TareaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TareaServiceImpl implements TareaService{

    @Autowired
    TareaRepository tareaRepository;


    @Override
    public List<Tarea> listaDeTareas(){
        return tareaRepository.findAll();
    }

    @Override
    public Tarea guardarTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public void borrarTarea(Long id) {tareaRepository.deleteById(id);}

    @Override
    public Tarea editarTareaPorId(Long id, Tarea tareaActualizada) {
        Boolean existe = tareaRepository.existsById(id);

        if (existe) {

            Tarea tareaSeleccionada = tareaRepository.findById(id).get();

            tareaSeleccionada.setTituloTarea(tareaActualizada.getTituloTarea());
            tareaSeleccionada.setDescripcionTarea(tareaActualizada.getDescripcionTarea());
            tareaSeleccionada.setFechaDeVencimiento(tareaActualizada.getFechaDeVencimiento());

            System.out.println("El tarea ha sido actualizada");
            return tareaRepository.save(tareaSeleccionada);
        } else {
            System.out.println("La tarea no existe o el id es inválido");
            return null;
        }
    }


}



