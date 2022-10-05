package br.com.sgsistemas.trainee.devsg.service;

import br.com.sgsistemas.trainee.devsg.form.ProdutoForm;
import br.com.sgsistemas.trainee.devsg.modelo.Produto;
import br.com.sgsistemas.trainee.devsg.repository.EquipeRepository;
import br.com.sgsistemas.trainee.devsg.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final EquipeRepository equipeRepository;

    public Optional<Produto> buscaPorNome(String nome) {
        Optional<Produto> produto = produtoRepository.findByNome(nome.toLowerCase());
        return produto;
    }

    public Produto cadastrar(ProdutoForm form) {
        Produto produto = form.converter(equipeRepository);
        produtoRepository.save(produto);
        return produto;
    }

    public Produto deletePorId(Long id) {
        Produto produto = produtoRepository.findById(id).get();
        produtoRepository.deleteById(id);
        return produto;
    }

    public Produto atualizar(ProdutoForm form) {
        Produto produto = form.converterComId(produtoRepository,equipeRepository);
        produtoRepository.save(produto);
        return produto;
    }
}
