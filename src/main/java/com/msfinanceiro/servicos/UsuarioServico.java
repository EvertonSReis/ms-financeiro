package com.msfinanceiro.servicos;

import com.msfinanceiro.exceptions.UsuarioException;
import com.msfinanceiro.modelo.dtos.CrendenciaisDTO;
import com.msfinanceiro.modelo.dtos.TokenDTO;
import com.msfinanceiro.modelo.dtos.UsuarioEntradaDTO;
import com.msfinanceiro.modelo.dtos.UsuarioRetornoDTO;
import com.msfinanceiro.modelo.entidades.Usuario;
import com.msfinanceiro.modelo.enums.ERole;
import com.msfinanceiro.modelo.parsers.UsuarioParser;
import com.msfinanceiro.repositorios.UsuarioRepository;
import com.msfinanceiro.seguranca.JwtService;
import com.msfinanceiro.uteis.CripitografarSenhaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServico implements UserDetailsService {

    @Autowired UsuarioRepository usuarioRepository;
    @Autowired UsuarioParser usuarioParser;
    @Autowired CripitografarSenhaUtil cripitografarSenhaUtil;
    @Autowired JwtService jwtService;

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNomeUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado na base de dados."));


        String[] roles = usuario.getRole().getValue() == ERole.ADMIN.getValue() ?
                new String[]{"ADMIN", "USER"} : new String[]{"USER"};

        return User
                .builder()
                .username(usuario.getNomeUsuario())
                .password(usuario.getSenha())
                .roles(roles)
                .build();
    }

    public TokenDTO autenticarEntrada(CrendenciaisDTO crendenciaisDTO) {
        try {
            Usuario usuario = Usuario.builder()
                    .nomeUsuario(crendenciaisDTO.getNomeUsuario())
                    .senha(crendenciaisDTO.getSenha())
                    .build();
            autenticar(usuario);
            String token = jwtService.gerarToken(usuario);
            return new TokenDTO(usuario.getNomeUsuario(), token);
        } catch (UsuarioException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

    private UserDetails autenticar(Usuario usuario) {
        UserDetails user = loadUserByUsername(usuario.getNomeUsuario());
        boolean senhasConferem = validarSenha(usuario, user.getPassword());

        if(senhasConferem){
            return user;
        }

        throw new UsuarioException("Senha usuário está incorreta.");
    }

    public boolean validarSenha(Usuario usuario, String senha){
        String senhaUsuarioAtual = cripitografarSenhaUtil.obterMD5(usuario.getSenha());
        return senha.equals(senhaUsuarioAtual);
    }
}
