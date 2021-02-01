package br.ce.hscastro.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@SuppressWarnings("serial")
@Entity
@Table(name = "CLIENTES")
public class Cliente extends AbstractEntity<Long> {

	@Column(name = "nome", nullable = false, length = 80)
	private String nome;
	

	@Column(name = "cpf", nullable = false, unique = true, length = 80)
	private String cpf;
	
	@Column(name = "email", nullable = false, length = 80)
	private String email;
	
	@Column(name = "celular", nullable = false, length = 25)
	private String celular;	
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_nascimento", columnDefinition = "DATE")
	private LocalDate dataNascimento;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereco;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id_fk")
	private Usuario usuario;
	
		
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getLogin() {
		return usuario;
	}

	public void setLogin(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
