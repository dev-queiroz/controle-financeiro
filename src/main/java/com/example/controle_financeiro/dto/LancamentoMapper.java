package com.example.controle_financeiro.dto;

import com.example.controle_financeiro.model.Lancamento;

import java.time.LocalDate;

public class LancamentoMapper {

    public static Lancamento toEntity(LancamentoRequestDTO dto) {
        return Lancamento.builder()
                .descricao(dto.getDescricao())
                .valor(dto.getValor())
                .tipo(dto.getTipo())
                .categoria(dto.getCategoria())
                .data(LocalDate.parse(dto.getData()))
                .build();
    }

    public static LancamentoResponseDTO toDTO(Lancamento l) {
        return LancamentoResponseDTO.builder()
                .id(l.getId())
                .descricao(l.getDescricao())
                .valor(l.getValor())
                .tipo(l.getTipo())
                .categoria(l.getCategoria())
                .data(l.getData().toString())
                .build();
    }
}
