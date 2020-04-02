package br.biblioteca.livros.restcontroler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.biblioteca.livros.entities.Livro;
import br.biblioteca.livros.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroRestController {
	
    @Autowired
    private LivroRepository livroRepository;
	
    @GetMapping("/lista")
    public ResponseEntity<List<Livro>> livros() {
        return ResponseEntity.ok(livroRepository.findAll());
    }

}
