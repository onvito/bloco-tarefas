package br.com.listaTarefas.repositorios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.listaTarefas.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{

}
