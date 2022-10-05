package br.com.sgsistemas.trainee.devsg.dto;

import br.com.sgsistemas.trainee.devsg.modelo.Equipe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipeDto {
    private Long id;
    private String nome;
    public EquipeDto(Equipe equipe) {
        id = equipe.getId();
        nome = equipe.getNome();
    }
}
