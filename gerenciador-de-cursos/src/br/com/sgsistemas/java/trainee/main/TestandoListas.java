package br.com.sgsistemas.java.trainee.main;

import java.awt.font.ShapeGraphicAttribute;
import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {
    public static void main(String[] args) {
        ArrayList<String> listaJogos = new ArrayList<>();
        listaJogos.add("Super Mario 64");
        listaJogos.add("Need For Speed Carbon");
        listaJogos.add("Street Fighter 3");
        listaJogos.add("The Room");

        listaJogos.forEach(jogo -> System.out.println("Jogo: " + jogo));
        System.out.println();

        listaJogos.remove("Street Fighter 3");
//        listaJogos.remove(2);

        listaJogos.forEach(jogo -> System.out.println("Jogo: " + jogo));

        System.out.println("Primeiro jogo da lista: " + listaJogos.get(0));

        System.out.println("\n Ordem Alfabética:");
        Collections.sort(listaJogos);
        listaJogos.forEach(jogo -> System.out.println("Jogo: " + jogo));

        //ArrayIndexOutOfBoundsException - erro
    }
}
