package com.carrijo.santander.banklineapi.repository;

import com.carrijo.santander.banklineapi.model.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {
}
