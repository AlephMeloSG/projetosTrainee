package br.com.sgsistemas.trainee.devsg.preview;

import br.com.sgsistemas.trainee.devsg.modelo.Equipe;
import br.com.sgsistemas.trainee.devsg.modelo.Linguagem;
import br.com.sgsistemas.trainee.devsg.modelo.Pessoa;
import br.com.sgsistemas.trainee.devsg.modelo.Produto;
import functions.Funcoes;

import java.util.Optional;

public class Preview {
    public static String visualizar(Optional<Equipe> equipe) {
        Equipe equipe1 = equipe.get();

        String visualizacao =
                "Equipe: " + equipe1.getNome() + "\n\n" +
                "Linguagens: \n";

        for (Linguagem linguagem : equipe1.getLinguagens()) {
            visualizacao += "- " + linguagem.getNome() + "\n";
        }
        visualizacao +=
                "\n" +
                "Produtos: \n";

        for (Produto produto : equipe1.getProdutos()) {
            visualizacao += "- " + produto.getNome() + "\n";
        }
        visualizacao += "\n" +
                "Pessoas: \n";
        for (Pessoa pessoa : equipe1.getPessoas()) {
            visualizacao += "- " + pessoa.getNome() + " -> Cargo: " + pessoa.getCargo().toString() + "\n";
        }
        return Funcoes.breaklineToBr(visualizacao);
    }
}
