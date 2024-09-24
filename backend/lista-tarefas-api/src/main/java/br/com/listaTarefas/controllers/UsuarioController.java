package br.com.listaTarefas.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.listaTarefas.model.Usuario;
import br.com.listaTarefas.model.vos.UsuarioDTO;
import br.com.listaTarefas.services.UsuarioService;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/usuarios/")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("listarTodos")
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    @PostMapping("salvar")
    public ResponseEntity<Usuario> salvar(@NotNull @RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioService.salvar(usuario);
        return ResponseEntity.ok(usuarioSalvo);
    }
    
    @PostMapping("salvarUsuario")
    public ResponseEntity<?> salvarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
    	try {
    		Usuario novoUsuario = usuarioService.salvarUsuario(usuarioDTO);
    		return new ResponseEntity<>(novoUsuario, HttpStatus.OK);
    	} catch (Exception e) {
//    		AppLogger.error(e);
			return new ResponseEntity<>("Ocorreu um erro ao salvar usuario", 
					HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

    @GetMapping("usuarios/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable UUID id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("usuarios/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
