package com.entity;

import com.validacao.CargoPolitico;
import com.validacao.Genero;
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

    private String cargo;

    private Date dataNascimento;

    private String genero;

    @ManyToOne
    private Partidos partidos;

}
