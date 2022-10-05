package br.com.sgsistemas.trainee.devsg.dto;

import br.com.sgsistemas.trainee.devsg.modelo.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDtoSemId {
    private String nome;
    private String equipe;
    public ProdutoDtoSemId(Produto produto) {
        nome = produto.getNome();
        equipe = produto.getEquipe().getNome();
    }
}
