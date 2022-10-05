package br.com.sgsistemas.trainee.devsg.service;

import br.com.sgsistemas.trainee.devsg.form.LinguagemForm;
import br.com.sgsistemas.trainee.devsg.modelo.Linguagem;
import br.com.sgsistemas.trainee.devsg.repository.LinguagemRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class LinguagemService {
    private final LinguagemRepository linguagemRepository;

    public Optional<Linguagem> buscaPorNome(String nome) {
        Optional<Linguagem> linguagem = linguagemRepository.findByNome(nome.toLowerCase());
        return linguagem;
    }

    public Linguagem cadastrar(LinguagemForm form) {
        Linguagem linguagem = form.converter();
        linguagemRepository.save(linguagem);
        return linguagem;
    }

    public Linguagem deletePorId(Long id) {
        Linguagem linguagem = linguagemRepository.findById(id).get();
        linguagemRepository.deleteById(id);
        return linguagem;
    }

    public Linguagem atualizar(LinguagemForm form) {
        Linguagem linguagem = form.converterComId();
        linguagemRepository.save(linguagem);
        return linguagem;
    }
}
