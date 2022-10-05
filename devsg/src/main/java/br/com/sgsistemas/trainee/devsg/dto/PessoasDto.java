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
public class PessoasDto {
    private Long id;
    private String nome;
    private String cargo;

    public PessoasDto(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.cargo = pessoa.getCargo().toString();
        this.id = pessoa.getId();
    }
}
