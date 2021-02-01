package br.ce.hscastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ce.hscastro.dao.ClienteDao;
import br.ce.hscastro.domain.Cliente;

@Service @Transactional(readOnly = true)
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao dao;
	
	@Transactional(readOnly = false)
	@Override
	public void salvar(Cliente cliente) {
		
		dao.save(cliente);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Cliente cliente) {
		
		dao.update(cliente);
	}

	@Override @Transactional(readOnly = false) 
	public void excluir(Long id) {
		
		dao.delete(id);
	}

	@Override
	public Cliente buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override
	public List<Cliente> buscarTodos() {
		
		return dao.findAll();
	}

	@Override
	public List<Cliente> buscarPorNome(String nome) {
		return dao.findByName(nome);
	}

	@Override
	public List<Cliente> buscarPorCargo(Long id) {
		return dao.findByCargo(id);
	}

}
