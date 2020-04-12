package br.biblioteca.livros.converters;

import java.util.List;
import java.util.stream.Collectors;

import br.biblioteca.livros.dtos.AutorDTO;
import br.biblioteca.livros.entities.Autor;

public class AutorConverter {

	public static AutorDTO toDTO(Autor autor) {
		AutorDTO dto = new AutorDTO();
		dto.setNome(autor.getNome());
		dto.setLivros(autor.getLivros().size() > 0 ? LivroConverter.toDTO(autor.getLivros()) : null);
		return dto;
	}

	public static List<AutorDTO> toDTO(List<Autor> autores) {
		return autores.stream().map(l -> toDTO(l)).collect(Collectors.toList());
	}

}
