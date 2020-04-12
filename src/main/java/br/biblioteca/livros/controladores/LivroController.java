package br.biblioteca.livros.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.entities.Autor;
import br.biblioteca.livros.entities.Livro;
import br.biblioteca.livros.service.AutorService;
import br.biblioteca.livros.service.LivroService;

@Controller
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@Autowired
	private AutorService autorService;

	@GetMapping("/list")
	public ModelAndView livros() {
		Iterable<Livro> livros = livroService.findAll();
		return new ModelAndView("livros/list", "livros", livros);
	}

	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Livro livro) {
		ModelAndView modelAndView = new ModelAndView("livros/form");
		Iterable<Autor> autores = autorService.findAll();
		modelAndView.addObject("autores", autores);
		return modelAndView;
	}

	@PostMapping(value = "/gravar")
	public ModelAndView create(@Valid Livro livro, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			Iterable<Autor> autores = autorService.findAll();
			return new ModelAndView("livros/form", "autores", autores);
		}
		livro = this.livroService.save(livro);
		return new ModelAndView("redirect:/livros/list");
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		Livro livro = this.livroService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado"));
		Iterable<Autor> autores = autorService.findAll();
		ModelAndView modelAndView = new ModelAndView("livros/form");
		modelAndView.addObject("autores", autores);
		modelAndView.addObject("livro", livro);
		return modelAndView;
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		Livro livro = this.livroService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado"));
		this.livroService.delete(livro);
		return new ModelAndView("redirect:/livros/list");
	}
}
