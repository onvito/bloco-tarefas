package br.com.listaTarefas.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.listaTarefas.model.Tarefa;
import br.com.listaTarefas.repositorios.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Tarefa buscarPorId(UUID id) {
        return tarefaRepository.findById(id).orElse(null);
    }

    public void deletar(UUID id) {
        tarefaRepository.deleteById(id);
    }
}
