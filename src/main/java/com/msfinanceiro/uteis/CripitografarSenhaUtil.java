package com.msfinanceiro.uteis;

import com.msfinanceiro.exceptions.FinanceiroException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Component
public class CripitografarSenhaUtil {

    public String obterMD5(String texto){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return DatatypeConverter.printHexBinary(
                    md.digest(
                            texto.getBytes(Charset.forName("UTF-8"))));
        } catch (NoSuchAlgorithmException var){
            log.error(var.getMessage(), var);
            throw new FinanceiroException(var);
        }
    }
}
