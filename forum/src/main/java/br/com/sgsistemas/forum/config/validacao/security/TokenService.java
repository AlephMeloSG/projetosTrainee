//package br.com.sgsistemas.forum.config.validacao.security;
//
//import br.com.sgsistemas.forum.modelo.Usuario;
//import io.jsonwebtoken.Jwts;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
//@Service
//public class TokenService {
//
//
//
//    public String gerarToken(Authentication authentication) {
//        Usuario logado = (Usuario) authentication.getPrincipal();
//        Date hoje = new Date();
//
//        return Jwts.builder().setIssuer("API do forum da Alura").setSubject(logado.getId().toString()).setIssuedAt(hoje).setExpiration(exp);
//    }
//}
