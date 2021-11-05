package com.dto;

import com.validacao.CargoPolitico;
import com.validacao.Genero;
import lombok.Data;

import java.util.Date;

@Data
public class AssociadoDTO {

    private Long id;

    private String nome;

    private CargoPolitico cargo;

    private Date dataNascimento;

    private String genero;

    private PartidoDTO partido;
}
