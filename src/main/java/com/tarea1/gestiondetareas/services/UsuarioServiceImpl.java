package com.tarea1.gestiondetareas.services;

import com.tarea1.gestiondetareas.models.Usuario;

import com.tarea1.gestiondetareas.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public List<Usuario> listaDeUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void borrarUsuario(Long id) {usuarioRepository.deleteById(id);}

    @Override
    public Usuario editarUsuarioPorId(Long id, Usuario usuarioActualizado) {
        Boolean existe = usuarioRepository.existsById(id);

        if (existe) {

           Usuario usuarioSeleccionado = usuarioRepository.findById(id).get();
            usuarioSeleccionado.setNombreUsuario(usuarioActualizado.getNombreUsuario());
            usuarioSeleccionado.setEmailUsuario(usuarioActualizado.getEmailUsuario());
            System.out.println("El usuario ha sido actualizado");
            return usuarioRepository.save(usuarioSeleccionado);
        } else {
            System.out.println("El usuario no existe o el id es inválido");
            return null;
        }

    }
    //nuevo
    @Override
    public Usuario buscarUsuarioPorId(Long id){
        Boolean existe = usuarioRepository.existsById(id);
        if (existe){
            Usuario usuarioEscogido = usuarioRepository.findById(id).get();
            return usuarioEscogido;
        }else {
            System.out.println("El id es invalido o el usuario no existe");
            return  null;
        }
    }

}




