package br.com.sgsistemas.trainee.devsg.service;

import br.com.sgsistemas.trainee.devsg.form.PessoaForm;
import br.com.sgsistemas.trainee.devsg.modelo.Pessoa;
import br.com.sgsistemas.trainee.devsg.repository.EquipeRepository;
import br.com.sgsistemas.trainee.devsg.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class PessoaService {
    private final EquipeRepository equipeRepository;
    private final PessoaRepository pessoaRepository;
    public Pessoa atualiza(PessoaForm form) {
        Pessoa pessoa = form.converterComId(equipeRepository, pessoaRepository);
        pessoaRepository.save(pessoa);
        return pessoa;
    }

    public Optional<Pessoa> buscaPorNome(String nome) {
        Optional<Pessoa> pessoa = pessoaRepository.findByNome(nome.toLowerCase());
        return pessoa;
    }

    public Pessoa cadastra(PessoaForm form) {
        Pessoa pessoa = form.converter(equipeRepository);
        pessoaRepository.save(pessoa);
        return pessoa;
    }

    public Pessoa deletePorId(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        equipeRepository.deleteById(id);
        return pessoa;
    }
}
