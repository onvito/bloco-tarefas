package br.com.listaTarefas.lista_tarefas.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Builder
@Table(name = "tb_usuario")
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="dt_inclusao", updatable=false, nullable=false)
	protected LocalDateTime dtInclusao;
	
	@PrePersist
	protected void onCreate() {
	    this.dtInclusao = LocalDateTime.now();
	}
	
}
