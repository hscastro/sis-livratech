package br.ce.hscastro.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.ce.hscastro.domain.Cliente;

@Repository
public class ClienteDaoImpl extends AbstractDao<Cliente, Long> implements ClienteDao {


	@Override
	public List<Cliente> findByName(String nome) {
		
		TypedQuery<Cliente> query = getEntityManager()
			.createQuery("select f from Cliente f where f.nome like :nome", Cliente.class);
				query.setParameter("nome", "%"+ nome +"%");
				
		return query.getResultList();
	}

	@Override
	public List<Cliente> findByCargo(Long id) {
		return createQuery("select f from Cliente f where f.cargo.id = ?1", id);
	}

}
