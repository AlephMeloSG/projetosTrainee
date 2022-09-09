package br.com.sgsistemas.java.trainee.main;

import functions.Funcoes;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TesteVelocidade {
    public static void main(String[] args) {

        Date ini = new Date();

        int numeross = 1000;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (arrayList.size()<numeross){
            arrayList.add(arrayList.size());
        }
        arrayList.forEach(numero ->{arrayList.contains(numero);});

        Date fim = new Date();
        long resultado = fim.getTime() - ini.getTime();
        System.out.println("ms:" + resultado);
        System.out.println("Segs: " + (double)resultado/1000);
        System.out.println("Mins: " + ((double)resultado/1000)/60);


        ini = new Date();

        Set<Integer> set = new HashSet<>();
        while (set.size()<numeross){
            set.add(set.size());
        }
        set.forEach(numero ->{set.contains(numero);});

        fim = new Date();
        resultado = fim.getTime() - ini.getTime();
        System.out.println("ms:" + resultado);
        System.out.println("Segs: " + (double)resultado/1000);
        System.out.println("Mins: " + ((double)resultado/1000)/60);

    }
}
