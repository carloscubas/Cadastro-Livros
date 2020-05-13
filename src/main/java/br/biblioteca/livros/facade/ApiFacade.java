package br.biblioteca.livros.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.converters.AutorConverter;
import br.biblioteca.livros.converters.AvaliacaoConverter;
import br.biblioteca.livros.converters.LivroConverter;
import br.biblioteca.livros.dtos.AutorDTO;
import br.biblioteca.livros.dtos.AvaliacaoDTO;
import br.biblioteca.livros.dtos.LivroDTO;
import br.biblioteca.livros.entities.Avaliacao;
import br.biblioteca.livros.entities.Livro;
import br.biblioteca.livros.exception.LivroNotFoundException;
import br.biblioteca.livros.service.AutorService;
import br.biblioteca.livros.service.AvaliacaoService;
import br.biblioteca.livros.service.LivroService;

// rest api controller
@Service
public class ApiFacade {

	@Autowired
	LivroService livroService;

	@Autowired
	AutorService autorService;

	@Autowired
	AvaliacaoService avaliacaoService;

	public Page<Livro> findAllBooks(String filterStr, String rangeStr, String sortStr) {
		return livroService.findAll(filterStr, rangeStr, sortStr);
	}

	public List<LivroDTO> findAllBooks() {
		return LivroConverter.toDTO(livroService.findAll());
	}

	public List<AutorDTO> findAllAutor() {
		return AutorConverter.toDTO(autorService.findAll());
	}

	public Long salvaAvaliacao(Long idLivro, AvaliacaoDTO avaliacaoDto) {
		Optional<Livro> livro = livroService.findById(idLivro);
		if (livro.isPresent()) {
			Avaliacao avaliacao = AvaliacaoConverter.toEntity(avaliacaoDto);
			avaliacao.setLivro(livro.get());
			return avaliacaoService.salva(avaliacao);
		} else {
			throw new LivroNotFoundException();
		}
	}
}
