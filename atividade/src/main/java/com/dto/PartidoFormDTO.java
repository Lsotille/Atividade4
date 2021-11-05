package com.dto;

import com.constants.Ideologia;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Data
public class PartidoFormDTO {

    private String nomeDoPartido;

    private String sigla;

    private Ideologia ideologia;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT-03")
    private Date dataFundacao;


}
