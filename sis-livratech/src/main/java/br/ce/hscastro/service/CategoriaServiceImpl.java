package br.ce.hscastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ce.hscastro.dao.CategoriaDao;
import br.ce.hscastro.domain.Categoria;


/**Projeto Livraria ABC
 * Desenvolvedor: Antonio Halyson - email:halisonsc5@gmail.com
 * Data: 28/01/2021 as 10:21
 */

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaDao dao;
	
	@Transactional(readOnly = false)
	@Override
	public void salvar(Categoria categoria) {
		
		dao.save(categoria);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Categoria categoria) {
		
		dao.update(categoria);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {

		dao.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Categoria buscarPorId(Long id) {
		
		return dao.findById(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Categoria> buscarTodos() {
		
		return dao.findAll();
	}

	@Override
	public boolean departamentoTemCargo(Long id) {
		if(buscarPorId(id).getLivros().isEmpty()) {
			return false;
		}
		return true;
	}

}
