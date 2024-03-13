package com.carrijo.santander.banklineapi.service;

import com.carrijo.santander.banklineapi.dto.NovaMovimentacao;
import com.carrijo.santander.banklineapi.model.Correntista;
import com.carrijo.santander.banklineapi.model.Movimentacao;
import com.carrijo.santander.banklineapi.model.MovimentacaoTipo;
import com.carrijo.santander.banklineapi.repository.CorrentistaRepository;
import com.carrijo.santander.banklineapi.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save(NovaMovimentacao novaMovimentacao) {
        Movimentacao movimentacao = new Movimentacao();
        Double valor = novaMovimentacao.getTipo()== MovimentacaoTipo.RECEITA ?
                novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;

        movimentacao.setDatahora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());
        movimentacao.setTipo(novaMovimentacao.getTipo());
        movimentacao.setValor(valor);

        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
        if (correntista != null){
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }

        repository.save(movimentacao);
    }
}
