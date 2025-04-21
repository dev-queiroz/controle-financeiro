package com.example.controle_financeiro.service;

import com.example.controle_financeiro.model.Lancamento;
import com.example.controle_financeiro.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExportacaoCSVService {

    @Autowired
    private LancamentoRepository repository;

    public String gerarCSV() {
        List<Lancamento> lista = repository.findAll();
        StringBuilder sb = new StringBuilder();
        sb.append("Descricao,Valor,Tipo,Data\n");
        for (Lancamento l : lista) {
            sb.append(String.format("\"%s\",%.2f,%s,%s\n",
                    l.getDescricao(),
                    l.getValor(),
                    l.getTipo(),
                    l.getData()));
        }
        return sb.toString();
    }
}
