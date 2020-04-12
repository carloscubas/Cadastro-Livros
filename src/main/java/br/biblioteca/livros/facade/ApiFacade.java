package br.biblioteca.livros.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.converters.AutorConverter;
import br.biblioteca.livros.converters.LivroConverter;
import br.biblioteca.livros.dtos.AutorDTO;
import br.biblioteca.livros.dtos.LivroDTO;
import br.biblioteca.livros.service.AutorService;
import br.biblioteca.livros.service.LivroService;

@Service
public class ApiFacade {

	@Autowired
	LivroService livroService;

	@Autowired
	AutorService autorService;

	public List<LivroDTO> findAllBooks() {
		return LivroConverter.toDTO(livroService.findAll());
	}

	public List<AutorDTO> findAllAutor() {
		return AutorConverter.toDTO(autorService.findAll());
	}

}
