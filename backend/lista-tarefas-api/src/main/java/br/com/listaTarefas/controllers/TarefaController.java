package br.com.listaTarefas.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.listaTarefas.model.Tarefa;
import br.com.listaTarefas.services.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<Tarefa> listarTodas() {
        return tarefaService.listarTodas();
    }

    @PostMapping
    public ResponseEntity<Tarefa> salvar(@RequestBody Tarefa tarefa) {
        Tarefa tarefaSalva = tarefaService.salvar(tarefa);
        return ResponseEntity.ok(tarefaSalva);
    }

    @GetMapping("/tarefas/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable UUID id) {
        Tarefa tarefa = tarefaService.buscarPorId(id);
        return tarefa != null ? ResponseEntity.ok(tarefa) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/tarefas/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
