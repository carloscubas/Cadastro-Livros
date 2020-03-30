package br.biblioteca.livros;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.controladores.LivroController;
import br.biblioteca.livros.entities.Livro;
import br.biblioteca.livros.repository.AutorRepository;
import br.biblioteca.livros.repository.LivroRepository;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LivrosApplicationTests {

	@LocalServerPort
	private int port;

	@Mock
	private LivroRepository livroRepository;

	@Mock
	private AutorRepository autorRepository;

	@InjectMocks
	private LivroController livroController;

	@Test
	public void bringListOfBooks() throws Exception {
		Mockito.when(livroRepository.findAll()).thenReturn(Arrays.asList(new Livro(), new Livro()));
		ModelAndView lista = livroController.livros();
		List<Livro> livros = (List<Livro>) lista.getModel().get("livros");
		assertEquals(2, livros.size());
	}

}
