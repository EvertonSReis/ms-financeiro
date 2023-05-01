package com.msfinanceiro.controladores;

import com.msfinanceiro.modelo.dtos.LojaEntradaDTO;
import com.msfinanceiro.modelo.dtos.LojaRetornoDTO;
import com.msfinanceiro.servicos.LojaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/loja", produces = "application/json")
public class LojaController {
    
    @Autowired LojaServico lojaServico;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> salvar(@RequestBody LojaEntradaDTO lojaEntradaDTO){

        LojaRetornoDTO loja = lojaServico.salvar(lojaEntradaDTO);

        return new ResponseEntity<>(loja, HttpStatus.OK);
    }
}
