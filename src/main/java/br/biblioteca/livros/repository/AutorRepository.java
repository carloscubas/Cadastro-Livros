package br.biblioteca.livros.repository;

/**
 * @author s2it_csilva
 * @version : $<br/>
 * : $
 * @since 5/15/19 1:13 PM
 */

import br.biblioteca.livros.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}

