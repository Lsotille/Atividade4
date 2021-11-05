package com.entity;

import com.constants.Ideologia;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "partidos")
public class Partidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeDoPartido;

    private String sigla;

    private Ideologia ideologia;

    private Date dataFundacao;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Associados> associados;

}
