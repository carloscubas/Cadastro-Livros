package com.example.demo.controladores;

import java.nio.file.attribute.FileStoreAttributeView;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.beans.Autor;
import com.example.demo.beans.Livro;
import com.example.demo.infra.FileSaver;
import com.example.demo.repository.AutorRepository;
import com.example.demo.repository.LivroRepository;

@Controller
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private FileSaver fileSaver;

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private AutorRepository autorRepository;

	@GetMapping("/list")
	public ModelAndView livros() {

		Iterable<Livro> livros = livroRepository.findAll();
		return new ModelAndView("livro/list", "livros", livros);

	}

	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Livro livro) {
		
		ModelAndView modelAndView = new ModelAndView("livro/form");
		
		Iterable<Autor> autores = autorRepository.findAll();
		modelAndView.addObject("autores", autores);

		
		return modelAndView;
	}

	@PostMapping(params = "form")
	public ModelAndView create(@RequestParam("capaurl") MultipartFile capaUrl, 
			@ModelAttribute("livro") @Valid Livro livro, 
			BindingResult bindingResult, Model model) {
		
		if (livro.getId() != null) {
			if (capaUrl.getOriginalFilename().length() > 0) {
				incluiCapa(capaUrl, livro, model);
			}
		} else {
			if (capaUrl.getOriginalFilename().equals("")) {
				model.addAttribute("capa", "A capa não pode ser vazia");
			} else {
				incluiCapa(capaUrl, livro, model);
			}
		}
		
		
		if (bindingResult.hasErrors()  || model.containsAttribute("message")) {
			Iterable<Autor> autores = autorRepository.findAll();
			return new ModelAndView("livro/form", "autores", autores);
		}
		
		livro = this.livroRepository.save(livro);
	    return new ModelAndView("redirect:/livros/list");
	}

	private void incluiCapa(MultipartFile capaUrl, Livro livro, Model model) {
		if (capaUrl.getContentType().equals("image/jpeg")) {
			String webPath = fileSaver.write("uploaded-images", capaUrl);
			livro.setCapa(webPath);
		} else {
			model.addAttribute("capa", "Arquivo em formato errado. Permitido apenas jpg");
		}
	}


	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		
		Livro livro = this.livroRepository.findOne(id);
		Iterable<Autor> autores = autorRepository.findAll();
		
		ModelAndView modelAndView = new ModelAndView("livro/form");
		modelAndView.addObject("autores", autores);
		modelAndView.addObject("livro", livro);
		
		return modelAndView;
		
	}
	
	

	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		Livro livro = this.livroRepository.findOne(id);
		this.livroRepository.delete(livro);
		return new ModelAndView("redirect:/livros/list");
	}

}