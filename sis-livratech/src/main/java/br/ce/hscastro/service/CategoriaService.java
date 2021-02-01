package br.ce.hscastro.service;

import java.util.List;

import br.ce.hscastro.domain.Categoria;


public interface CategoriaService {
	
	void salvar(Categoria categoria);
	
	void editar(Categoria categoria);
	
	void excluir(Long id);
	
	Categoria buscarPorId(Long id);
	
	List<Categoria> buscarTodos();

	boolean departamentoTemCargo(Long id);

}
