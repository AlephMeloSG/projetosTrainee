package br.com.sgsistemas.java.trainee.main;

import br.com.sgsistemas.java.trainee.modulo.ImportaReceita;
import functions.Funcoes;

import java.lang.reflect.Type;

//ArrayList<String> arrayList = new ArrayList<String>();

public class Programa {
    public static void main(String[] args) {

        int quantiaTabela = 7;
        ImportaReceita tabelaInfo = new ImportaReceita();

        while (true) {
            System.out.println("tabelas:");
            for (int i = 1; i <= quantiaTabela; i++) {
                System.out.println(i + ".tabela");
            }
            System.out.println();

            int escolha = Funcoes.inputInt("Numero Correspondente: ", 1, quantiaTabela);
            System.out.println();
            switch (escolha){
                case 1:{
                    tabelaInfo.importaTabela("arquivos/Tabela_4_3_10.txt");
                    tabelaInfo.ImprimirReceita();
                    break;
                }
                case 2:{
                    tabelaInfo.importaTabela("arquivos/Tabela_4_3_11.txt");
                    tabelaInfo.ImprimirReceita();
                    break;
                }
                case 3:{
                    tabelaInfo.importaTabela("arquivos/Tabela_4_3_12.txt");
                    tabelaInfo.ImprimirReceita();
                    break;
                }
                case 4:{
                    tabelaInfo.importaTabela("arquivos/Tabela_4_3_13.txt");
                    tabelaInfo.ImprimirReceita();
                    break;
                }
                case 5:{
                    tabelaInfo.importaTabela("arquivos/Tabela_4_3_14.txt");
                    tabelaInfo.ImprimirReceita();
                    break;
                }
                case 6:{
                    tabelaInfo.importaTabela("arquivos/Tabela_4_3_15.txt");
                    tabelaInfo.ImprimirReceita();
                    break;
                }
                case 7:{
                    tabelaInfo.importaTabela("arquivos/Tabela_4_3_16.txt");
                    tabelaInfo.ImprimirReceita();
                    break;
                }
            }
            System.out.println();
            System.out.println();
        }
        //
    }
}
