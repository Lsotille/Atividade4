package com.validacao;


import com.entity.Associados;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class Genero {
    private String x = "MASCULINO";
    private String y = "FEMININO";


 List<String>listaDeGeneros = Arrays.asList(x,y);

 public void validarGenero (Associados associados){
     String pegaGenero = associados.getGenero();
     if(!listaDeGeneros.contains(pegaGenero)){
         throw new RuntimeException(pegaGenero + "nao e'um genero valido");
     }
 }
}
