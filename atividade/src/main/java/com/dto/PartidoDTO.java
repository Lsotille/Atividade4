package com.dto;

import com.constants.Ideologia;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PartidoDTO {

    private Long id;

    private String nomeDoPartido;

    private String sigla;

    private Ideologia ideologia;


    private Date dataFundacao;

    private List<AssociadoDTO> associadosDTO;

}
