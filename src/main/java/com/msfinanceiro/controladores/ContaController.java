package com.msfinanceiro.controladores;

import com.msfinanceiro.modelo.dtos.ContaEntradaDTO;
import com.msfinanceiro.modelo.dtos.ContaRetornoDTO;
import com.msfinanceiro.servicos.ContaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/conta", produces = "application/json")
public class ContaController {
    
    @Autowired ContaServico contaServico;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> salvar(@RequestBody ContaEntradaDTO contaEntradaDTO){

        ContaRetornoDTO conta = contaServico.salvar(contaEntradaDTO);

        return new ResponseEntity<>(conta, HttpStatus.OK);
    }
    
    @PutMapping("/atualizar/{idConta}")
    public ResponseEntity<?> atualizar(@PathVariable("idConta") Long idConta,@RequestBody ContaEntradaDTO contaEntradaDTO){

        ContaRetornoDTO conta = contaServico.atualizar(contaEntradaDTO, idConta);

        return new ResponseEntity<>(conta, HttpStatus.OK);
    }
}
