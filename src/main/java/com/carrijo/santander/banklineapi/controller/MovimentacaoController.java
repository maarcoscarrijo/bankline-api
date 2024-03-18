package com.carrijo.santander.banklineapi.controller;

import com.carrijo.santander.banklineapi.dto.NovaMovimentacao;
import com.carrijo.santander.banklineapi.model.Movimentacao;
import com.carrijo.santander.banklineapi.repository.MovimentacaoRepository;
import com.carrijo.santander.banklineapi.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository repository;


    @Autowired
    private MovimentacaoService service;

    @GetMapping
    @CrossOrigin
    public List<Movimentacao> findAll(){
        return  repository.findAll();
    }

    @GetMapping("/{idConta}")
    public List<Movimentacao> findAll(@PathVariable("idConta") Integer idConta){
        return repository.findByIdConta(idConta);
    }

    @PostMapping
    @CrossOrigin
    public void save(@RequestBody NovaMovimentacao movimentacao){
        service.save(movimentacao);
    }
}
