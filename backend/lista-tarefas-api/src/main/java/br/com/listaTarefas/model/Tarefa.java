package br.com.listaTarefas.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
@Table(name = "tb_tarefa")
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario idUsuario;
	
	@Column(name="anotacoes")
	private String anotacoes;
	
	@Column(name="favorito")
	private boolean favorito;
	
	@Column(name="cor")
	private String cor;
	
	@Column(name="dt_inclusao", updatable=false, nullable=false)
	protected LocalDateTime dtInclusao;
	
	@Column(name="dt_alteracao", updatable=true)
	protected LocalDateTime dtAlteracao;
	
	@PrePersist
	protected void onCreate() {
	    this.dtInclusao = LocalDateTime.now();
	    this.dtAlteracao = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
	    this.dtAlteracao = LocalDateTime.now();
	}
	

}
