package com.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PartidoDTO {

    private Long id;

    private String nomeDoPartido;

    private String sigla;

    private String ideologia;


    private Date dataFundacao;

    private List<AssociadoDTO> associadosDTO;

}
