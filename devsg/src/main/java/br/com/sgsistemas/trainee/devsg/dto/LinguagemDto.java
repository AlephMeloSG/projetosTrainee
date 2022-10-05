package br.com.sgsistemas.trainee.devsg.dto;

import br.com.sgsistemas.trainee.devsg.modelo.Linguagem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinguagemDto {
    private Long id;
    private String nome;


    public LinguagemDto(Linguagem linguagem) {
        id = linguagem.getId();
        nome = linguagem.getNome();
    }
}
