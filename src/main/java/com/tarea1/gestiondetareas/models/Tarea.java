package com.tarea1.gestiondetareas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.jetbrains.annotations.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tarea_de_usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tareaId;

    @NotNull
    private String tituloTarea;

    private String descripcionTarea;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaDeVencimiento;


    @ManyToOne
    @JoinColumn(name = "usuario_id",nullable = false)
    private Usuario usuario;



    @OneToMany(mappedBy = "tarea", cascade = CascadeType.ALL)
    private  List<Comentario> comentariosTarea;







}
