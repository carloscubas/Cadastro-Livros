package br.biblioteca.livros.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.entities.Livro;
import br.biblioteca.livros.repository.LivroRepository;
import springboot.rest.entities.QueryParamWrapper;
import springboot.rest.services.FilterService;
import springboot.rest.utils.QueryParamExtractor;

@Service
public class LivroService {

	@Autowired(required = true)
	private FilterService<Livro, Long> filterService;

	@Autowired
	private LivroRepository livroRepository;

	public List<Livro> findAll() {
		return livroRepository.listaLivros();
	}

	public Page<Livro> findAll(String filterStr, String rangeStr, String sortStr) {
		QueryParamWrapper wrapper = QueryParamExtractor.extract("{nome: Spring boot}", "[0,2]", "[nome,DESC]");
		return filterService.filterBy(wrapper, livroRepository, Arrays.asList("nome"));
	}

	public Livro save(Livro livro) {
		return livroRepository.save(livro);
	}

	public Optional<Livro> findById(Long id) {
		return livroRepository.findById(id);
	}

	public void delete(Livro livro) {
		livroRepository.delete(livro);

	}

}
