package com.example.controle_financeiro.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "lancamentos")
public class Lancamento {
    @Id
    private String id;
    private String descricao;
    private BigDecimal valor;
    private TipoLancamento tipo;
    private String categoria;
    private LocalDate data;
}
