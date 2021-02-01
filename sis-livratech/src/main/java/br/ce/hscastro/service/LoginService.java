package br.ce.hscastro.service;

import java.util.List;

import br.ce.hscastro.domain.Usuario;


public interface LoginService {

	void salvar(Usuario usuario);
	
	void editar(Usuario usuario);
	
	void excluir(Long id);
	
	Usuario buscarPorId(Long id);
	
	List<Usuario> buscarTodos();
	
	public Usuario findByLoginAndSenha(String login, String senha);

	//boolean cargoTemFuncionario(Long id);

}
