package com.example.controle_financeiro.repository;

import com.example.controle_financeiro.model.Lancamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LancamentoRepository extends MongoRepository<Lancamento, String> {

    List<Lancamento> findByDataBetween(LocalDate inicio, LocalDate fim);
}
