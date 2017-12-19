package enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 
@Entity
public class Aluno {
	@Id
	@GeneratedValue
	@Column(name = "alunoid", nullable = false)
private Long alunoid;

public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}
@Column(nullable = false)
private String senha;
@Column(nullable = false)
private String nome;
@Column(nullable = false)
private String endereco;
@Column(nullable = false)
private String email;

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

}