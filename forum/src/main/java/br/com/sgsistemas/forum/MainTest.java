package br.com.sgsistemas.forum;

import br.com.sgsistemas.forum.drawings.Drawings;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import functions.Funcoes;

public class MainTest {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
