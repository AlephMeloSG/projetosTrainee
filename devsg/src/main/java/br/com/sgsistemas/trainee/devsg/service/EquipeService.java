package br.com.sgsistemas.trainee.devsg.service;

import br.com.sgsistemas.trainee.devsg.form.EquipeForm;
import br.com.sgsistemas.trainee.devsg.modelo.Equipe;
import br.com.sgsistemas.trainee.devsg.modelo.Linguagem;
import br.com.sgsistemas.trainee.devsg.repository.EquipeRepository;
import br.com.sgsistemas.trainee.devsg.repository.LinguagemRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EquipeService {
    private final EquipeRepository equipeRepository;
    private final LinguagemRepository linguagemRepository;

    public Optional<Equipe> BuscaPorNome(String nome) {
        Optional<Equipe> equipe = equipeRepository.findByNome(nome.toLowerCase());
        return equipe;
    }

    public Equipe cadastrar(EquipeForm form) {
        Equipe equipe = form.converter(linguagemRepository);
        equipeRepository.save(equipe);
        return equipe;
    }

    public Equipe deletePorId(Long id) {
        Equipe equipe = equipeRepository.findById(id).get();
        equipeRepository.deleteById(id);
        return equipe;
    }

    public Equipe atualizar(EquipeForm form) {
        Equipe equipe = form.converterComId(linguagemRepository, equipeRepository);
        equipeRepository.save(equipe);
        return equipe;
    }
}
