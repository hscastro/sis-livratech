package br.ce.hscastro.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**Projeto Livraria ABC
 * Desenvolvedor: Antonio Halyson - email:halisonsc5@gmail.com
 * Data: 28/01/2021 
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "LIVROS")
public class Livro extends AbstractEntity<Long> {
	
	@Column(name = "isbn", nullable = false, unique = true, length = 20)
	private String isbn;
	
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;


	@ManyToOne
	@JoinColumn(name = "id_categoria_fk")
	private Categoria categoria;
	
	@Column(name = "autor", nullable = true, length = 80)
	private String autor;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_entrada", columnDefinition = "DATE")
	private LocalDate dataEntrada;
	
	public Livro() {
		// TODO Auto-generated constructor stub
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}	
	
}
