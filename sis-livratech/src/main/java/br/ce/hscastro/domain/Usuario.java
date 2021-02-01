package br.ce.hscastro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "USUARIOS")
public class Usuario extends AbstractEntity<Long> {	
	
	@Column(name = "login", nullable = false, unique = true,  length = 50)
	private String login;
	
	@Column(name = "senha", nullable = false, length = 33)
	private String senha;
	
	private Integer perfil;
	
	
	public Usuario() {
		this.perfil = 2;
	}
	
	public Usuario(Integer perfil, String login, String senha) {
		this.perfil = perfil;
		this.login = login;
		this.senha = senha;		
	}
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}





	public void setSenha(String senha) {
		this.senha = senha;
	}





	public Integer getPerfil() {
		return perfil;
	}

	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}
	
	
}
