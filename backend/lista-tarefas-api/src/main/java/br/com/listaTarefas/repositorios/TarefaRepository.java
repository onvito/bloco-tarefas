package br.com.listaTarefas.repositorios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.listaTarefas.model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, UUID>{

}
