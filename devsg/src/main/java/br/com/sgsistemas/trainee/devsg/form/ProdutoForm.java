package br.com.sgsistemas.trainee.devsg.form;

import br.com.sgsistemas.trainee.devsg.modelo.Equipe;
import br.com.sgsistemas.trainee.devsg.modelo.Produto;
import br.com.sgsistemas.trainee.devsg.repository.EquipeRepository;
import br.com.sgsistemas.trainee.devsg.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoForm {
    private Long id;
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String nomeEquipe;
    public Produto converter(EquipeRepository equipeRepository) {
        Optional<Equipe> equipe = equipeRepository.findByNome(nomeEquipe.toLowerCase());
        if(equipe.isPresent()) {
            return new Produto(nome.toLowerCase(), equipe.get());
        } else {
            return null;
        }
    }

    public Produto converterComId(ProdutoRepository produtoRepository, EquipeRepository equipeRepository) {
        Equipe equipeModel;
        if (nomeEquipe != null && !nomeEquipe.isEmpty()) {
            equipeModel = equipeRepository.findByNome(nomeEquipe.toLowerCase()).get();
        } else {
            equipeModel = produtoRepository.findById(id).get().getEquipe();
        }
        return new Produto(id,nome.toLowerCase(),equipeModel);
    }
}
