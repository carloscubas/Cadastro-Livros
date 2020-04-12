package br.biblioteca.livros.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.biblioteca.livros.dtos.AutorDTO;
import br.biblioteca.livros.dtos.LivroDTO;
import br.biblioteca.livros.facade.ApiFacade;

@RestController
@RequestMapping("/api")
public class ApitController {

	@Autowired
	ApiFacade apiFacade;

	@GetMapping("/livros/list")
	public ResponseEntity<List<LivroDTO>> listaLivros() {
		return ResponseEntity.ok(apiFacade.findAllBooks());
	}

	@GetMapping("/autor/list")
	public ResponseEntity<List<AutorDTO>> listaAutor() {
		return ResponseEntity.ok(apiFacade.findAllAutor());
	}
}
