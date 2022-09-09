package br.com.sgsistemas.java.trainee.modulo;

import functions.Funcoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ImportaReceita {
    private ArrayList<NaturezaReceita> naturezaReceitas = new ArrayList<>();

    public void importaTabela(String arquivo) {
        boolean existe = Funcoes.existFile(arquivo);
        if (existe == false) {
            return;
        }
        String texto = Funcoes.readFile(arquivo, "windows-1252");
        ArrayList<String> linhas = new ArrayList<>(Funcoes.contentSeparation(texto, "\n"));
        linhas.remove(0);

        for(String linha : linhas){
            boolean receitaExiste = true;
            for (NaturezaReceita naturezaReceita : naturezaReceitas) {
                if(naturezaReceita.getCodigo().equals(Funcoes.contentSeparation(linha,"|").get(0))){
                    System.out.println("ja existe");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
                    receitaExiste = false;
                }
            }
            if (receitaExiste) {
                NaturezaReceita naturezaReceita = new NaturezaReceita(Funcoes.contentSeparation(linha,"|"));
                naturezaReceitas.add(naturezaReceita);
            }
        }
    }

    public void ImprimirReceita() {
        for (NaturezaReceita naturezaReceita : naturezaReceitas) {
            System.out.println(naturezaReceita.toString());
        }

    }
}