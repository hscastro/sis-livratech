package br.ce.hscastro.dao;

import java.util.List;

import br.ce.hscastro.domain.Livro;


public interface LivroDao {
	
	void save(Livro livro);
	
	void update(Livro livro);
	
	void delete(Long id);
	
	Livro findById(Long id);
	
	List<Livro> findAll();

}
