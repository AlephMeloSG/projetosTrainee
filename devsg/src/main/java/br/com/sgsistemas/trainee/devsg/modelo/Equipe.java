package br.com.sgsistemas.trainee.devsg.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Equipe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "equipe")
    private List<Pessoa> pessoas;
//    @ManyToMany(mappedBy = "equipes")
    @ManyToMany
    private List<Linguagem> linguagens;
    @OneToMany(mappedBy = "equipe")
    private List<Produto> produtos;

    public Equipe(String nome, List<Pessoa> pessoas, List<Linguagem> linguagens) {
        this.nome = nome;
        this.pessoas = pessoas;
        this.linguagens = linguagens;
    }

    public Equipe(String nome, List<Linguagem> linguagens) {
        this.nome = nome;
        this.linguagens = linguagens;
    }
}
