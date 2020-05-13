package br.biblioteca.livros.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.biblioteca.livros.entities.Livro;
import br.biblioteca.livros.facade.ApiFacade;

@RestController
@RequestMapping("/list")
public class ApiList {

	@Autowired
	ApiFacade apiFacade;

	@GetMapping(value = "/livros")
	public Iterable<Livro> filterBy(@RequestParam(required = false, name = "filter") String filterStr,
			@RequestParam(required = false, name = "range") String rangeStr,
			@RequestParam(required = false, name = "sort") String sortStr) {
		return apiFacade.findAllBooks(filterStr, rangeStr, sortStr);
	}

}
