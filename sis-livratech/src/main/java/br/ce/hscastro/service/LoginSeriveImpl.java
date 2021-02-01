package br.ce.hscastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ce.hscastro.dao.UsuarioDao;
import br.ce.hscastro.domain.Usuario;


/**Projeto Livraria ABC
 * Desenvolvedor: Antonio Halyson - email:halisonsc5@gmail.com
 * Data: 29/01/2021 
 */

@Service  @Transactional(readOnly = false)
public class LoginSeriveImpl implements LoginService {
	
	@Autowired
	private UsuarioDao dao;

	@Override
	public void salvar(Usuario usuario) {
		
		dao.save(usuario);
	}

	@Override
	public void editar(Usuario usuario) {
		
		dao.update(usuario);
	}

	@Override
	public void excluir(Long id) {
		
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Usuario buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Usuario> buscarTodos() {
		
		return dao.findAll();
	}

	@Override
	public Usuario findByLoginAndSenha(String login, String senha) {		
		return dao.findByLoginAndSenha(login, senha);
	}

}
