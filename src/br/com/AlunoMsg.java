package br.com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/* @author Aline e Izadora
 * @since 28 de novembro de 2017
 */
@Entity

public class AlunoMsg {
	@Id
	@GeneratedValue
	@Column(name = "alunoid", nullable = false)
	private Long alunoid;
	@Column(nullable = false)

	
	private String nome;
	@Column(nullable = false)
	private String endereco;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String msg;

	public Long getAlunoid() {
		return alunoid;
	}

	public void setAlunoid(Long alunoid) {
		this.alunoid = alunoid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
