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

@Entity
@Table(name = "comentario_usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comentarioId;

    @NotNull
    private String textoComentario;

    @NotNull
    @Column(name = "Fecha_creacion")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaCreacionComentario;


    @ManyToOne
    @JoinColumn(name = "tarea_id",nullable = false)
    private Tarea tarea;


}
