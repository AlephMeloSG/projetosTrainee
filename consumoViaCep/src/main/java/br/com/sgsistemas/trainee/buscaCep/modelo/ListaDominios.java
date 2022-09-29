package br.com.sgsistemas.trainee.buscaCep.modelo;

import java.util.ArrayList;
import java.util.List;

public class ListaDominios {
    private static List<Dominio> dominios =  new ArrayList<>();
    private static List<String> cepInvalidos = new ArrayList<>();

    public static void adicionaDominio(Dominio dominio){
        dominios.add(dominio);
    }
    public static void adicionaCepInvalido(String cep){
        cepInvalidos.add(cep);
    }

    public static List<Dominio> getDominios() {
        return dominios;
    }
    public static List<String> getCepInvalidos() {
        return cepInvalidos;
    }
}
