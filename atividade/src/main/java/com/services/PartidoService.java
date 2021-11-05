package com.services;

import com.dto.PartidoDTO;
import com.dto.PartidoFormDTO;

import java.util.List;

public interface PartidoService {

    PartidoDTO salvar(PartidoFormDTO corpo);

    List<PartidoDTO> listar(String ideologia);

    PartidoDTO procurar(Long id);

    PartidoDTO atualizar(Long id, PartidoFormDTO body);

    void remover(Long id);

    PartidoDTO listarAssociados(Long id);
}
