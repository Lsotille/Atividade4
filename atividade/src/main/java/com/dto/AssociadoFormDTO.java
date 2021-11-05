package com.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AssociadoFormDTO {

    private String nome;

    private String cargo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT-03")
    private Date dataNascimento;

    private String genero;

    private String idpartido;
}
