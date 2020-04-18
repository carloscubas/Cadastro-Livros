package br.biblioteca.livros.dtos;

import java.util.ArrayList;
import java.util.List;

public class LivroDTO {

	private String nome;

	private int paginas;

	private String autor;

	private List<AvaliacaoDTO> avaliacoes = new ArrayList<AvaliacaoDTO>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public List<AvaliacaoDTO> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<AvaliacaoDTO> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

}
