package com.msfinanceiro.modelo.parsers;

import com.msfinanceiro.modelo.dtos.UsuarioEntradaDTO;
import com.msfinanceiro.modelo.dtos.UsuarioRetornoDTO;
import com.msfinanceiro.modelo.entidades.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioParser {

    public Usuario parserUsuarioEntradaDTO(UsuarioEntradaDTO usuarioEntradaDTO, String senha){
        return Usuario.builder()
                .nomeUsuario(usuarioEntradaDTO.getNomeUsuario())
                .senha(senha)
                .email(usuarioEntradaDTO.getEmail())
                .role(usuarioEntradaDTO.getRole())
                .build();
    }

    public UsuarioRetornoDTO builderRetornoUsuario(Usuario usuario){
        return UsuarioRetornoDTO.builder()
                .idUsuario(usuario.getIdUsuario())
                .nomeUsuario(usuario.getNomeUsuario())
                .email(usuario.getEmail())
                .role(usuario.getRole())
                .build();
    }

    public List<UsuarioRetornoDTO> builderRetornoListaUsuarios(List<Usuario> usuarios) {
        List<UsuarioRetornoDTO> usuarioRetornoLista = new ArrayList<>();
        usuarios.forEach(usuario -> usuarioRetornoLista.add(UsuarioRetornoDTO.builder()
                .idUsuario(usuario.getIdUsuario())
                .nomeUsuario(usuario.getNomeUsuario())
                .email(usuario.getEmail())
                .role(usuario.getRole()).build()));

        return usuarioRetornoLista;
    }
}
