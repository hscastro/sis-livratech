package br.ce.hscastro.dao;

import java.util.List;
import br.ce.hscastro.domain.Cliente;

public interface ClienteDao {

	void save(Cliente cliente);
	
	void update(Cliente cliente);
	
	void delete(Long id);
	
	Cliente findById(Long id);
	
	List<Cliente> findAll();

	List<Cliente> findByName(String nome);

	List<Cliente> findByCargo(Long id);
	
}
