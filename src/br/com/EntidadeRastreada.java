package br.com;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.UsuarioUtil;
import enity.Aluno;

/**
 * Inclui mecanismos de grava��o de data de cria��o, data de atualiza��o, e
 * usu�rio de atualiza��o de uma entidade.<br/>
 * Deve ser estendido pelas entidades que quiserem utilizar
 * esses atributos.
 *  
 * @author Aline e Izadora
 * @since 07 de Dezembro de 2017
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class EntidadeRastreada implements ObjetoPersistivel {

	/** Data de cria��o do registro. */
	@Column(name="criado_em", nullable = false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date criadoEm;
	
	/** Usu�rio que criou o registro. */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_criado_por", referencedColumnName = "alunoid", nullable=false, updatable=false)
	protected Aluno criadoPor;
	
	/** Data da �ltima atualiza��o do registro. */
	@Column(name="atualizado_em")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date atualizadoEm;
	
	/** Usu�rio que atualizou o registro pela �ltima vez. */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_atualizado_por", referencedColumnName = "usuarioid")
	protected Aluno atualizadoPor;
	
	@PrePersist
	/*
	 * @param
	 *  m�todo para retornar a data que o aluno foi cadastrado e a data que foi atualizado os dados
	 * 
	 * @return String Create e Update*/
	 
	protected void onCreate(){
		criadoEm = new Date();
		criadoPor = UsuarioUtil.getAlunoLogado();
	}
	
	@PreUpdate
	protected void onUpdate(){
		atualizadoEm = new Date();
		atualizadoPor = UsuarioUtil.getAlunoLogado();
	}
	

	public Date getCriadoEm() {
		return criadoEm;
	}

	public Aluno getCriadoPor() {
		return criadoPor;
	}

	public Date getAtualizadoEm() {
		return atualizadoEm;
	}

	public Aluno getAtualizadoPor() {
		return atualizadoPor;
	}

	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}

	public void setCriadoPor(Aluno criadoPor) {
		this.criadoPor = criadoPor;
	}

	public void setAtualizadoEm(Date atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}

	public void setAtualizadoPor(Aluno atualizadoPor) {
		this.atualizadoPor = atualizadoPor;
	}
	
}
