package br.com.sgsistemas.trainee.devsg.dto;

import br.com.sgsistemas.trainee.devsg.modelo.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoasDtoComEquipe {
    private String nome;
    private String cargo;
    private String equipe;


    public PessoasDtoComEquipe(Pessoa pessoa) {
        nome = pessoa.getNome();
        cargo = pessoa.getCargo().toString();
        equipe = pessoa.getEquipe().getNome();
    }
}
