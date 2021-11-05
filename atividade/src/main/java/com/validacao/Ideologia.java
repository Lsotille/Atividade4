package com.validacao;

import com.entity.Partidos;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class Ideologia {

    private String x ="CENTRO";
    private String y ="DIREITA";
    private String z ="ESQUERDA";
    private String h ="CENTRO-DIREITA";
    private String w ="CENTRO-ESQUERDA";

    List<String> listaDeIdeologias = Arrays.asList(x,y,z,h,w);

    public void validarIdeologia(Partidos partidos){
        String pegaIdeologia = partidos.getIdeologia();
        if (!listaDeIdeologias.contains(pegaIdeologia)){
            throw new RuntimeException (pegaIdeologia + "nao e' ideologia ou esta escrito incorretamente");
        }

    }
}
