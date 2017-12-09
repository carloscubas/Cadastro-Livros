package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.beans.Livro;
import com.example.demo.repository.LivroRepository;

@Controller
public class Index {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping("/")
	public ModelAndView home() {
		
		return new ModelAndView("index");
		
	}
	
	@GetMapping("/livros")
	public ModelAndView livros() {
		Iterable<Livro> livros = livroRepository.findAll();
		return new ModelAndView("livros", "livros", livros);
	}


}

