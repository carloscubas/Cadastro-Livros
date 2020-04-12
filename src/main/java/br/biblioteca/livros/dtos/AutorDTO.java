package br.biblioteca.livros.dtos;

import java.util.List;

public class AutorDTO {

	private String nome;

	private List<LivroDTO> livros;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<LivroDTO> getLivros() {
		return livros;
	}

	public void setLivros(List<LivroDTO> livros) {
		this.livros = livros;
	}

}
