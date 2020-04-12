package br.biblioteca.livros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.biblioteca.livros.entities.Livro;

/**
 * @author s2it_csilva
 * @version : $<br/>
 *          : $
 * @since 5/14/19 1:06 PM
 */
public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query(value = " from #{#entityName} l left join fetch l.autor a order by l.quantidadePaginas desc ")
	List<Livro> listaLivros();

}
