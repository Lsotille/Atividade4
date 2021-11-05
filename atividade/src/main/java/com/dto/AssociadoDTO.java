package com.dto;

import com.constants.CargoPolitico;
import com.constants.Genero;
import lombok.Data;

import java.util.Date;

@Data
public class AssociadoDTO {

    private Long id;

    private String nome;

    private CargoPolitico cargo;

    private Date dataNascimento;

    private Genero genero;

    private PartidoDTO partido;
}
