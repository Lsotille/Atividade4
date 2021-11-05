package com.entity;

import com.constants.CargoPolitico;
import com.constants.Genero;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "associados")
public class Associados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private CargoPolitico cargo;

    private Date dataNascimento;

    private Genero genero;

    @ManyToOne
    private Partidos partidos;

}
