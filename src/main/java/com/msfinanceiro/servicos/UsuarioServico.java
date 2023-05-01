package com.msfinanceiro.servicos;

import com.msfinanceiro.exceptions.UsuarioException;
import com.msfinanceiro.modelo.dtos.UsuarioEntradaDTO;
import com.msfinanceiro.modelo.dtos.UsuarioRetornoDTO;
import com.msfinanceiro.modelo.entidades.Usuario;
import com.msfinanceiro.modelo.parsers.UsuarioParser;
import com.msfinanceiro.repositorios.UsuarioRepository;
import com.msfinanceiro.uteis.CripitografarSenhaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServico {

    @Autowired UsuarioRepository usuarioRepository;
    @Autowired UsuarioParser usuarioParser;
    @Autowired CripitografarSenhaUtil cripitografarSenhaUtil;

    public UsuarioRetornoDTO salvar(UsuarioEntradaDTO usuarioEntradaDTO){

        validarUsuarioExiste(usuarioEntradaDTO);

        String senha = cripitografarSenhaUtil.obterMD5(usuarioEntradaDTO.getSenha());

        Usuario usuario =
                usuarioRepository.save(
                        usuarioParser.parserUsuarioEntradaDTO(usuarioEntradaDTO,senha));

        return usuarioParser.builderRetornoUsuario(usuario);
    }

    public List<UsuarioRetornoDTO> retonarTodosUsuarios(){

        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarioParser.builderRetornoListaUsuarios(usuarios);
    }

    private void validarUsuarioExiste(UsuarioEntradaDTO usuarioEntradaDTO){
        Optional<Usuario> nomeUsuario = usuarioRepository.findByNomeUsuario(usuarioEntradaDTO.getNomeUsuario());
        if(nomeUsuario.isPresent()){
            throw new UsuarioException("Nome usuário informado já existe.");
        }

        Optional<Usuario> email = usuarioRepository.findByEmail(usuarioEntradaDTO.getEmail());
        if (email.isPresent()){
            throw new UsuarioException(("Email informado já existe."));
        }
    }
}
