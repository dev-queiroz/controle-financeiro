package com.example.controle_financeiro.controller;

import com.example.controle_financeiro.dto.LancamentoRequestDTO;
import com.example.controle_financeiro.dto.LancamentoResponseDTO;
import com.example.controle_financeiro.service.ExportacaoCSVService;
import com.example.controle_financeiro.service.LancamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/lancamentos")
@RequiredArgsConstructor
public class LancamentoController {

    private final LancamentoService service;

    @Autowired
    private final ExportacaoCSVService exportacaoCSVService;

    @PostMapping
    public LancamentoResponseDTO salvar(@RequestBody @Valid LancamentoRequestDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<LancamentoResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/saldo")
    public BigDecimal saldoAtual() {
        return service.calcularSaldoAtual();
    }

    @GetMapping("/periodo")
    public List<LancamentoResponseDTO> listarPorPeriodo(
            @RequestParam String inicio,
            @RequestParam String fim) {
        LocalDate dataInicio = LocalDate.parse(inicio);
        LocalDate dataFim = LocalDate.parse(fim);
        return service.listarPorPeriodo(dataInicio, dataFim);
    }

    @GetMapping(value = "/lancamentos/exportar", produces = "text/csv")
    public ResponseEntity<String> exportarCSV() {
        String csv = exportacaoCSVService.gerarCSV();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=lancamentos.csv")
                .body(csv);
    }
}
