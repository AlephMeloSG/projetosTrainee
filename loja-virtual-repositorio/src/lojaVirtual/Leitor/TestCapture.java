package lojaVirtual.Leitor;

import functions.Funcoes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TestCapture {
    public static void main(String[] args) {
        String texto = Funcoes.readFile("src/lojaVirtual/arquivos/1.txt", "windows-1252");
        ArrayList<String> line = new ArrayList<>();
        line.addAll(Funcoes.contentSeparation(texto,"\n"));
        System.out.println(line.get(0));
        System.out.println(line.get(2));


    }
}
