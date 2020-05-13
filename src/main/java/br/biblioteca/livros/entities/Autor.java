package br.biblioteca.livros.entities;

/**
 * @author s2it_csilva
 * @version : $<br/>
 * : $
 * @since 5/15/19 1:10 PM
 */

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Autor implements Serializable {

	private static final long serialVersionUID = -2931921441183751443L;

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	@OneToMany
	private Set<Livro> livros = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Livro> getLivros() {
		return livros;
	}

	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + "]";
	}
}
