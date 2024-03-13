package com.carrijo.santander.banklineapi.controller;

import com.carrijo.santander.banklineapi.dto.NovoCorrentista;
import com.carrijo.santander.banklineapi.model.Correntista;
import com.carrijo.santander.banklineapi.repository.CorrentistaRepository;
import com.carrijo.santander.banklineapi.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

    @Autowired
    private CorrentistaRepository repository;


    @Autowired
    private CorrentistaService service;

    @GetMapping
    @CrossOrigin
    public List<Correntista> findAll(){
        return  repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovoCorrentista correntista){
        service.save(correntista);
    }
}
