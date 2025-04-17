package com.example.controle_financeiro.controller;

import com.example.controle_financeiro.dto.LancamentoRequestDTO;
import com.example.controle_financeiro.dto.LancamentoResponseDTO;
import com.example.controle_financeiro.service.LancamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/lancamentos")
@RequiredArgsConstructor
public class LancamentoController {

    private final LancamentoService service;

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
}
