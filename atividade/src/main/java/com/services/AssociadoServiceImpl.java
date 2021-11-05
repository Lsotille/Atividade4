package com.services;

import com.dto.AssociadoDTO;
import com.dto.AssociadoFormDTO;
import com.entity.Associados;
import com.entity.Partidos;
import com.repository.AssociadoRepository;
import com.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AssociadoServiceImpl implements AssociadoService {
    @Autowired
    private AssociadoRepository repository;

    @Autowired
    private PartidoRepository repositoryP;

    @Autowired
    private ModelMapper mapper;

    @Override
    public AssociadoDTO salvar(AssociadoFormDTO body) {
        Associados associados = mapper.map(body, Associados.class);
        Associados associadosResponse = this.repository.save(associados);
        return mapper.map(associadosResponse, AssociadoDTO.class);
    }

    @Override
    public AssociadoDTO vincularPartido(long idA,long idP) {
        Optional<Associados> associados = this.repository.findById(idA);
        if (associados.isPresent() == true) {
            Optional<Partidos> partidos = this.repositoryP.findById(idP);
            associados.get().setPartidos(partidos.get());
            Associados st = this.repository.save(associados.get());
            return mapper.map(st, AssociadoDTO.class);
        }
        throw new RuntimeException("Associado não encontrado");
    }

    @Override
    public List<AssociadoDTO> listar(String cargo) {
        List<AssociadoDTO> associadoDTOList = new ArrayList<>();
        if (cargo != null){
            associadoDTOList = this.repository.findByCargo(cargo).stream().map(st -> mapper.map(st, AssociadoDTO.class)).collect(Collectors.toList());
        }else
            associadoDTOList = this.repository.findAll().stream().map(st -> mapper.map(st, AssociadoDTO.class)).collect(Collectors.toList());
        return associadoDTOList;
    }


    @Override
    public AssociadoDTO procurar(Long id) {
        Optional<Associados> state = this.repository.findById(id);
        if (state.isPresent() == true) {
            return mapper.map(state.get(), AssociadoDTO.class);
        }
        throw new RuntimeException("Associado não encontrado");
    }

    @Override
    public AssociadoDTO atualizar(Long id, AssociadoFormDTO body) {
        Optional<Associados> associados = this.repository.findById(id);
        if (associados.isPresent() == true) {
            associados.get().setCargo(body.getCargo());
            Associados st = this.repository.save(associados.get());
            return mapper.map(st, AssociadoDTO.class);
        }
        throw new RuntimeException("Associado não encontrado");
    }

    @Override
    public void remover(Long id) {
        Associados associados = this.repository.findById(id).get();
        this.repository.delete(associados);
    }

    @Override
    public AssociadoDTO desvincularPartido(long id) {
        Optional<Associados> associados = this.repository.findById(id);
        if (associados.isPresent() == true) {
            associados.get().setPartidos(null);
            Associados st = this.repository.save(associados.get());
            return mapper.map(st, AssociadoDTO.class);
        }
        throw new RuntimeException("Associado não encontrado");
    }


}
