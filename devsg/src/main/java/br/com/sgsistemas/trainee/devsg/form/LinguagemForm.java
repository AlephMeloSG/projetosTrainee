package br.com.sgsistemas.trainee.devsg.form;

import br.com.sgsistemas.trainee.devsg.modelo.Linguagem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LinguagemForm {
    private Long id;
    @NotNull @NotEmpty
    private String nome;
    public Linguagem converter() {
        return new Linguagem(nome.toLowerCase());
    }

    public Linguagem converterComId() {
        Linguagem linguagem = new Linguagem(nome.toLowerCase());
        linguagem.setId(id);
        return linguagem;
    }
}
