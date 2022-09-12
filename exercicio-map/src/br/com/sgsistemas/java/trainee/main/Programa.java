package br.com.sgsistemas.java.trainee.main;

import java.util.HashMap;
import java.util.Map;

public class Programa {
    public static void main(String[] args) {

        Map<Integer, String> pessoas = new HashMap<>();

        pessoas.put(21, "Leonardo Cordeiro");
        pessoas.put(27, "Fabio Pimentel");
        pessoas.put(19, "Silvio Mattos");
        pessoas.put(23, "Romulo Henrique");

        pessoas.forEach((chave, pessoa) -> System.out.println("Pessoa: "+pessoa+"\n"+"chave: "+chave+"\n"));
    }
}
