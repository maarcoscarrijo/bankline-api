package com.carrijo.santander.banklineapi.repository;

import com.carrijo.santander.banklineapi.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
}
