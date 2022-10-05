package br.com.sgsistemas.trainee.devsg.dto;

import br.com.sgsistemas.trainee.devsg.modelo.Equipe;
import br.com.sgsistemas.trainee.devsg.modelo.Linguagem;
import br.com.sgsistemas.trainee.devsg.modelo.Pessoa;
import br.com.sgsistemas.trainee.devsg.modelo.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class EquipeDtoCompleto {
    private String nome;
    private List<PessoasDtoSemID> pessoas;
    private List<LinguagemDtoSemID> linguagens;
    private List<String> produtos;

    public EquipeDtoCompleto(Equipe equipe) {
        this.nome = equipe.getNome();
        this.pessoas = new ArrayList<>();
        this.linguagens = new ArrayList<>();
        this.produtos = new ArrayList<>();
        for (Pessoa pessoa : equipe.getPessoas()) {
            PessoasDtoSemID pessoasDto = new PessoasDtoSemID(pessoa.getNome(),pessoa.getCargo().toString());
            this.pessoas.add(pessoasDto);
        }
        for (Linguagem linguagem : equipe.getLinguagens()) {
            LinguagemDtoSemID linguagemDto = new LinguagemDtoSemID(linguagem.getNome());
            this.linguagens.add(linguagemDto);
        }
        for (Produto produto : equipe.getProdutos()) {
            System.out.println(produto.getNome());
            this.produtos.add(produto.getNome());
        }
    }
}
