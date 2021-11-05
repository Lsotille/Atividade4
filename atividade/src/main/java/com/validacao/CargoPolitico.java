package com.validacao;

import com.entity.Associados;

import java.util.Arrays;
import java.util.List;

public class CargoPolitico {
    private String x = "VEREADOR";
    private String y = "PREFEITO";
    private String z = "DEPUTADOESTADUAL";
    private String v = "DEPUTADOFEDERAL";
    private String b = "SENADOR";
    private String c = "GOVERNADOR";
    private String n = "PRESIDENTE";

  List<String> listaDeCargos = Arrays.asList(x,y,z,v,b,c,n);

  public void validarCargo(Associados associados){
      String pegaCargo = associados.getCargo();
      if (!listaDeCargos.contains(pegaCargo))
          throw new RuntimeException(pegaCargo + "nao e'um cargo valido");
      }

  }


