package com.msfinanceiro.controladores;

import com.msfinanceiro.modelo.dtos.CrendenciaisDTO;
import com.msfinanceiro.modelo.dtos.TokenDTO;
import com.msfinanceiro.modelo.dtos.UsuarioEntradaDTO;
import com.msfinanceiro.modelo.dtos.UsuarioRetornoDTO;
import com.msfinanceiro.servicos.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario", produces = "application/json")
public class UsuarioController {

    @Autowired UsuarioServico usuarioServico;

    @PostMapping("/auth")
    public ResponseEntity<?> autenticarEntrada(@RequestBody CrendenciaisDTO crendenciaisDTO){

        TokenDTO tokenDTO = usuarioServico.autenticarEntrada(crendenciaisDTO);

        return new ResponseEntity<>(tokenDTO, HttpStatus.CREATED);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> salvar(@RequestBody UsuarioEntradaDTO usuarioEntradaDTO){

        UsuarioRetornoDTO usuario = usuarioServico.salvar(usuarioEntradaDTO);

        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @GetMapping("/todos-os-usuarios")
    public ResponseEntity<?> retornarTodosUsuario(){

        List<UsuarioRetornoDTO> usuarios = usuarioServico.retonarTodosUsuarios();

        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
}
