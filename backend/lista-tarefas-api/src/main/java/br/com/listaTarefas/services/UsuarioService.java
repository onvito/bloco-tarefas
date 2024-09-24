package br.com.listaTarefas.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.listaTarefas.model.Usuario;
import br.com.listaTarefas.model.vos.UsuarioDTO;
import br.com.listaTarefas.repositorios.UsuarioRepository;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
//    private final BCryptPasswordEncoder passwordEncoder;

//    public UsuarioService(UsuarioRepository usuarioRepository) {
//        this.usuarioRepository = usuarioRepository;
//        this.passwordEncoder = new BCryptPasswordEncoder(); // Cria o encoder para senhas
//    }

	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}

	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario buscarPorId(UUID id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	public void deletar(UUID id) {
		usuarioRepository.deleteById(id);
	}

	public Usuario salvarUsuario(UsuarioDTO usuarioDTO) {
		
		
    	Usuario usuario = new Usuario();
    	   
    	usuario.setNome(usuarioDTO.getNome());
    	usuario.setEmail(usuarioDTO.getEmail());
    	usuario.setSenha(usuarioDTO.getSenha());
    	
    	return usuarioRepository.save(usuario);
    			
    		
    }
}
