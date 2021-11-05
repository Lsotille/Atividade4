package com.controllers;

import com.dto.AssociadoDTO;
import com.dto.AssociadoFormDTO;
import com.services.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidos")
public class AssociadoController {

    @Autowired
    private AssociadoService service;

    @PostMapping
    public ResponseEntity<AssociadoDTO> salvar(@RequestBody AssociadoFormDTO body) {
        AssociadoDTO state = this.service.salvar(body);
        return ResponseEntity.ok(state);
    }

    @GetMapping
    public ResponseEntity<List<AssociadoDTO>> listar(@RequestParam(value = "cargo", required = false) String cargo){
        return ResponseEntity.ok(this.service.listar(cargo));
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<AssociadoDTO> procurar (@RequestParam(value = "id", required = true) Long id){
        return ResponseEntity.ok(this.service.procurar(id));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AssociadoDTO> atualizar (@RequestParam(value = "id", required = true) Long id,@RequestBody AssociadoFormDTO body){
        return ResponseEntity.ok(this.service.atualizar(id,body));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AssociadoDTO> remover (@RequestParam(value = "id", required = true) Long id){
        this.service.remover(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/{id}/{id}")
    public ResponseEntity<AssociadoDTO> vincularPartido (@RequestParam(value = "id", required = true) Long id,@RequestParam(value = "id", required = true) Long idP){
        return ResponseEntity.ok(this.service.vincularPartido(id,idP));
    }

    @PatchMapping(path = "/{id}/{id}")
    public ResponseEntity<AssociadoDTO> desvincularPartido (@RequestParam(value = "id", required = true) Long id){
        return ResponseEntity.ok(this.service.desvincularPartido(id));
    }
}