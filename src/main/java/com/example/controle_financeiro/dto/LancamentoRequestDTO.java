package com.example.controle_financeiro.dto;

import com.example.controle_financeiro.model.TipoLancamento;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LancamentoRequestDTO {

    @NotBlank
    private String descricao;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    private TipoLancamento tipo;

    @NotBlank
    private String categoria;

    @NotNull
    private String data; // ISO-8601 format (yyyy-MM-dd)
}
