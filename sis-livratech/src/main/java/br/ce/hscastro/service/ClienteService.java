package br.ce.hscastro.service;

import java.util.List;
import br.ce.hscastro.domain.Cliente;

public interface ClienteService {
	
	void salvar(Cliente cliente);
	
	void editar(Cliente cliente);
	
	void excluir(Long id);
	
	Cliente buscarPorId(Long id);
	
	List<Cliente> buscarTodos();

	List<Cliente> buscarPorNome(String nome);

	List<Cliente> buscarPorCargo(Long id);
	
}
