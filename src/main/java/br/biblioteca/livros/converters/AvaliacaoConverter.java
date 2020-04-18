package br.biblioteca.livros.converters;

import java.util.List;
import java.util.stream.Collectors;

import br.biblioteca.livros.dtos.AvaliacaoDTO;
import br.biblioteca.livros.entities.Avaliacao;

public class AvaliacaoConverter {

	public static Avaliacao toEntity(AvaliacaoDTO avaliacaoDTO) {
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setComentario(avaliacaoDTO.getComentario());
		avaliacao.setNota(avaliacaoDTO.getNota());
		return avaliacao;
	}

	public static AvaliacaoDTO toDTO(Avaliacao avaliacao) {
		AvaliacaoDTO dto = new AvaliacaoDTO();
		dto.setComentario(avaliacao.getComentario());
		dto.setNota(avaliacao.getNota());
		return dto;
	}

	public static List<AvaliacaoDTO> toDTO(List<Avaliacao> avaliacoes) {
		return avaliacoes.stream().map(l -> toDTO(l)).collect(Collectors.toList());
	}

}
