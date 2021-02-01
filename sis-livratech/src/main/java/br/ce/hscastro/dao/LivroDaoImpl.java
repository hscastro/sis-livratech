package br.ce.hscastro.dao;


import org.springframework.stereotype.Repository;
import br.ce.hscastro.domain.Livro;

@Repository
public class LivroDaoImpl extends AbstractDao<Livro, Long> implements LivroDao {

}
