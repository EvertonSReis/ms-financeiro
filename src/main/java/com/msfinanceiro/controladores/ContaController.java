package com.msfinanceiro.controladores;

import com.msfinanceiro.modelo.dtos.ContaEntradaDTO;
import com.msfinanceiro.modelo.dtos.ContaRetornoDTO;
import com.msfinanceiro.servicos.ContaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/conta", produces = "application/json")
public class ContaController {
    
    @Autowired ContaServico contaServico;

    @PostMapping("/cadastrar")
    public ResponseEntity<List<ContaRetornoDTO>> salvar(@RequestBody ContaEntradaDTO contaEntradaDTO){

        List<ContaRetornoDTO> conta = contaServico.salvar(contaEntradaDTO);

        return new ResponseEntity<>(conta, HttpStatus.OK);
    }
    
    @PutMapping("/atualizar/{idConta}")
    public ResponseEntity<ContaRetornoDTO> atualizar(@PathVariable("idConta") Long idConta,@RequestBody ContaEntradaDTO contaEntradaDTO){

        ContaRetornoDTO conta = contaServico.atualizar(contaEntradaDTO, idConta);

        return new ResponseEntity<>(conta, HttpStatus.OK);
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<?> deletar(@RequestParam("numeroConta") Long numeroConta,
                                     @RequestParam("numeroParcela") Long numeroParcela){

        contaServico.deletar(numeroConta, numeroParcela);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/todas-as-contas")
    public ResponseEntity<List<ContaRetornoDTO>> retornarTodasContas(){

        List<ContaRetornoDTO> contas = contaServico.retornarTodasContas();

        return new ResponseEntity<>(contas, HttpStatus.OK);
    }
}
