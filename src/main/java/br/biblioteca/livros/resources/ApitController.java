package br.biblioteca.livros.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.biblioteca.livros.dtos.AutorDTO;
import br.biblioteca.livros.dtos.AvaliacaoDTO;
import br.biblioteca.livros.dtos.LivroDTO;
import br.biblioteca.livros.facade.ApiFacade;

@RestController
@RequestMapping("/api")
public class ApitController {

	@Autowired
	ApiFacade apiFacade;

	@GetMapping("/livro/list")
	public ResponseEntity<List<LivroDTO>> listaLivros() {
		return ResponseEntity.ok(apiFacade.findAllBooks());
	}

	@GetMapping("/autor/list")
	public ResponseEntity<List<AutorDTO>> listaAutor() {
		return ResponseEntity.ok(apiFacade.findAllAutor());
	}

	@PostMapping("/livro/avaliacao/{id}")
	public ResponseEntity<Long> comentario(@PathVariable("id") Long id, @RequestBody AvaliacaoDTO avaliacao) {
		try {
			return ResponseEntity.ok(apiFacade.salvaAvaliacao(id, avaliacao));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

}
