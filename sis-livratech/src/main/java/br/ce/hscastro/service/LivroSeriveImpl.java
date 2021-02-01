package br.ce.hscastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ce.hscastro.dao.LivroDao;
import br.ce.hscastro.domain.Livro;

/**Projeto Livraria ABC
 * Desenvolvedor: Antonio Halyson - email:halisonsc5@gmail.com
 * Data: 28/01/2021 
 */

@Service  @Transactional(readOnly = false)
public class LivroSeriveImpl implements LivroService {
	
	@Autowired
	private LivroDao dao;

	@Override
	public void salvar(Livro livro) {
		
		dao.save(livro);
	}

	@Override
	public void editar(Livro livro) {
		
		dao.update(livro);
	}

	@Override
	public void excluir(Long id) {
		
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Livro buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Livro> buscarTodos() {
		
		return dao.findAll();
	}

//	@Override
//	public boolean cargoTemFuncionario(Long id) {
//		if(dao.findById(id).getFuncionarios().isEmpty()) {
//			return false;
//		}
//		return true;
//	}


}
