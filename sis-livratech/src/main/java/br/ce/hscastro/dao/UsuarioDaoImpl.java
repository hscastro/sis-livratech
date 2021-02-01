package br.ce.hscastro.dao;


import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import br.ce.hscastro.domain.Usuario;


@Repository
public class UsuarioDaoImpl extends AbstractDao<Usuario, Long> implements UsuarioDao {
	
	public Usuario findByLoginAndSenha(String login, String senha) {
		String hql = "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha";
		Query query = getEntityManager().createQuery(hql);
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		return (Usuario) query.getSingleResult(); 					
	}

}
