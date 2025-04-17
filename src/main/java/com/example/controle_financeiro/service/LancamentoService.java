package com.example.controle_financeiro.service;

import com.example.controle_financeiro.dto.LancamentoMapper;
import com.example.controle_financeiro.dto.LancamentoRequestDTO;
import com.example.controle_financeiro.dto.LancamentoResponseDTO;
import com.example.controle_financeiro.model.Lancamento;
import com.example.controle_financeiro.model.TipoLancamento;
import com.example.controle_financeiro.repository.LancamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LancamentoService {
    private final LancamentoRepository repository;

    public LancamentoResponseDTO salvar(LancamentoRequestDTO dto) {
        Lancamento lancamento = LancamentoMapper.toEntity(dto);
        Lancamento salvo = repository.save(lancamento);
        return LancamentoMapper.toDTO(salvo);
    }

    public List<LancamentoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(LancamentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BigDecimal calcularSaldoAtual() {
        return repository.findAll().stream()
                .map(l -> l.getTipo() == TipoLancamento.ENTRADA
                        ? l.getValor()
                        : l.getValor().negate())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<LancamentoResponseDTO> listarPorPeriodo(LocalDate inicio, LocalDate fim) {
        return repository.findByDataBetween(inicio, fim).stream()
                .map(LancamentoMapper::toDTO)
                .collect(Collectors.toList());
    }
}
