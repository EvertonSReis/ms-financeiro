package com.msfinanceiro.seguranca;

import com.msfinanceiro.servicos.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
@EnableWebSecurity
public class WebConfig {

    @Autowired UsuarioServico usuarioServico;
    @Autowired JwtService jwtService;

    @Bean
    public OncePerRequestFilter jwtFilter(){return new JwtAuthFilter(jwtService, usuarioServico);}

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((auth) -> {
            try {
                auth.requestMatchers("/usuario/cadastrar",
                                "/usuario/auth")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                        .and()
                        .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .and()
                        .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class)
                        .csrf()
                        .disable();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
                })
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
