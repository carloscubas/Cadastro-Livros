package br.biblioteca.livros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.entities.Livro;
import br.biblioteca.livros.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	public List<Livro> findAll() {
		return livroRepository.listaLivros();
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
