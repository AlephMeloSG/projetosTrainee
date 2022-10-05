package br.com.sgsistemas.trainee.devsg.form;

import br.com.sgsistemas.trainee.devsg.modelo.Equipe;
import br.com.sgsistemas.trainee.devsg.modelo.Linguagem;
import br.com.sgsistemas.trainee.devsg.repository.EquipeRepository;
import br.com.sgsistemas.trainee.devsg.repository.LinguagemRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipeForm {
    private Long id;
    @NotNull @NotEmpty @Length(min = 1)
    private String nome;

    private List<String> nomeLinguagens;

    public EquipeForm(String nome, List<String> nomeLinguagens) {
        this.nome = nome;
        this.nomeLinguagens = nomeLinguagens;
    }

    public Equipe converter(LinguagemRepository linguagemRepository){
        List<Linguagem> linguagens = new ArrayList<>();
        for (String nomeLinguagem : nomeLinguagens) {
            Optional<Linguagem> result = linguagemRepository.findByNome(nomeLinguagem.toLowerCase());
            if(!result.isPresent()){
                Linguagem linguagem = new Linguagem(nomeLinguagem.toLowerCase());
                linguagemRepository.save(linguagem);
                linguagens.add(linguagem);
            }else {
                linguagens.add(result.get());
            }
        }
        return new Equipe(nome.toLowerCase(),linguagens);
    }

    public Equipe converterComId(LinguagemRepository linguagemRepository, EquipeRepository equipeRepository) {
        List<Linguagem> linguagens = null;
        if (nomeLinguagens != null && !nomeLinguagens.isEmpty()) {
            linguagens = new ArrayList<>();
            for (String nomeLinguagem : nomeLinguagens) {
                Optional<Linguagem> result = linguagemRepository.findByNome(nomeLinguagem.toLowerCase());
                if (!result.isPresent()) {
                    Linguagem linguagem = new Linguagem(nomeLinguagem.toLowerCase());
                    linguagemRepository.save(linguagem);
                    linguagens.add(linguagem);
                } else {
                    linguagens.add(result.get());
                }
            }
        } else {
            linguagens = equipeRepository.findById(id).get().getLinguagens();
        }
        Equipe equipe = new Equipe(nome.toLowerCase(),linguagens);
        equipe.setId(id);
        return equipe;
    }
}
