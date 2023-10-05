package com.tarea1.gestiondetareas.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity
@Table(name = "datos_usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @NotNull
    private String nombreUsuario;

    @NotNull
    private String emailUsuario;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Tarea> tareaUsuario;







}
