package com.decimo.tarefas.controllers;

import com.decimo.tarefas.Services.TarefaService;
import com.decimo.tarefas.models.TarefaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity <TarefaModel> criarTarefa(@RequestBody TarefaModel tarefaModel) {
        TarefaModel requeste = tarefaService.criarTarefa(tarefaModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(requeste.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @GetMapping
    public ResponseEntity<List<TarefaModel>> findAll() {
        List<TarefaModel> requeste = tarefaService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaModel> findById(@PathVariable Long id) {
        TarefaModel tarefaModel = tarefaService.findById(id);
        return ResponseEntity.ok().body(tarefaModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
