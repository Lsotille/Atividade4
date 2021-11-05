package com.services;

import com.dto.AssociadoDTO;
import com.dto.AssociadoFormDTO;
import com.dto.PartidoDTO;

import java.util.List;

public interface AssociadoService {


    AssociadoDTO salvar(AssociadoFormDTO body);

    AssociadoDTO vincularPartido(long id,long ida);

    List<AssociadoDTO> listar(String cargo);

    AssociadoDTO procurar(Long id);

    AssociadoDTO atualizar(Long id, AssociadoFormDTO body);

    void remover(Long id);

    AssociadoDTO desvincularPartido(long id);
}
