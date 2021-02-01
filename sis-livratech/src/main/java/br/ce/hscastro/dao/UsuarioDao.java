package br.ce.hscastro.dao;

import java.util.List;

import br.ce.hscastro.domain.Usuario;


public interface UsuarioDao {
	
	void save(Usuario usuario);
	
	void update(Usuario usuario);
	
	void delete(Long id);
	
	Usuario findById(Long id);
	
	List<Usuario> findAll();
	
	Usuario findByLoginAndSenha(String login, String senha);

}
