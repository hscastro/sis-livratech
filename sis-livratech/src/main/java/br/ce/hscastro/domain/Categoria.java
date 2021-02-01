package br.ce.hscastro.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**Projeto Livraria ABC
 * Desenvolvedor: Antonio Halyson - email:halisonsc5@gmail.com
 * Data: 28/01/2021 as 10:11
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "CATEGORIAS")
public class Categoria extends AbstractEntity<Long> {

	@Column(name = "nome", nullable = false, unique = true, length = 80)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@OneToMany(mappedBy = "categoria")
	private List<Livro> livros;

	public List<Livro> getLivros() {
		return livros;
	}

	public void setCargos(List<Livro> livros) {
		this.livros = livros;
	}
}
