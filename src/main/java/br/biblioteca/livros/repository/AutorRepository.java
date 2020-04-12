package br.biblioteca.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author s2it_csilva
 * @version : $<br/>
 * : $
 * @since 5/15/19 1:13 PM
 */

import br.biblioteca.livros.entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
