package br.com.sgsistemas.trainee.devsg.dto;

import br.com.sgsistemas.trainee.devsg.modelo.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {
    private Long id;
    private String nome;
    private String equipe;
    public ProdutoDto(Produto produto) {
        nome = produto.getNome();
        equipe = produto.getEquipe().getNome();
        id = produto.getId();
    }
}
