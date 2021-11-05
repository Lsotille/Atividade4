package com.dto;

import com.constants.CargoPolitico;
import com.constants.Genero;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AssociadoFormDTO {

    private String nome;

    private CargoPolitico cargo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT-03")
    private Date dataNascimento;

    private Genero genero;

    private String idpartido;
}
