package br.biblioteca.livros.repository;

import br.biblioteca.livros.beans.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author s2it_csilva
 * @version : $<br/>
 * : $
 * @since 5/14/19 1:06 PM
 */
public interface LivroRepository  extends JpaRepository<Livro, Long> {


}
