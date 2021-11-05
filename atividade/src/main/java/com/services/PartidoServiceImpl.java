package com.services;

import com.dto.PartidoDTO;
import com.dto.PartidoFormDTO;
import com.entity.Partidos;
import com.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PartidoServiceImpl implements PartidoService {

    @Autowired
    private PartidoRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public PartidoDTO salvar(PartidoFormDTO body) {
        Partidos partidos = mapper.map(body, Partidos.class);
        Partidos partidosResponse = this.repository.save(partidos);
        return mapper.map(partidosResponse, PartidoDTO.class);
    }

    @Override
    public List<PartidoDTO> listar(String ideologia) {
        List<PartidoDTO> partido = new ArrayList<>();
        if (ideologia != null){
            partido = this.repository.findByIdeologia(ideologia).stream().map(st -> mapper.map(st, PartidoDTO.class)).collect(Collectors.toList());
        }else
            partido = this.repository.findAll().stream().map(st -> mapper.map(st, PartidoDTO.class)).collect(Collectors.toList());
        return partido;
    }

    @Override
    public PartidoDTO procurar(Long id) {
        Optional<Partidos> state = this.repository.findById(id);
        if (state.isPresent() == true) {
            return mapper.map(state.get(), PartidoDTO.class);
        }
        throw new RuntimeException("Partido não encontrado");
    }

    @Override
    public PartidoDTO atualizar(Long id, PartidoFormDTO body) {
        Optional<Partidos> state = this.repository.findById(id);
        if (state.isPresent() == true) {
            state.get().setNomeDoPartido(body.getNomeDoPartido());
            Partidos st = this.repository.save(state.get());
            return mapper.map(st, PartidoDTO.class);
        }
        throw new RuntimeException("Partido não encontrado");
    }

    @Override
    public void remover(Long id) {
        Partidos partidos = this.repository.findById(id).get();
        this.repository.delete(partidos);
    }

    @Override
    public PartidoDTO listarAssociados(Long id) {
        Optional<Partidos> partido = this.repository.findById(id);
        if (partido.isPresent() == true) {
            return mapper.map(partido.get().getAssociados(), PartidoDTO.class);
        }
        throw new RuntimeException("Partido não encontrado");
    }

}
