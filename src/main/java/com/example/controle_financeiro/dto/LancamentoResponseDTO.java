package com.example.controle_financeiro.dto;

import com.example.controle_financeiro.model.TipoLancamento;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LancamentoResponseDTO {

    private String id;
    private String descricao;
    private BigDecimal valor;
    private TipoLancamento tipo;
    private String categoria;
    private String data;
}
