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
public class PessoasDtoSemID {
    private String nome;
    private String cargo;
}
