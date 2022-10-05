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
public class Linguagem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
//    @ManyToMany
    @ManyToMany(mappedBy = "linguagens")
    private List<Equipe> equipes;

    public Linguagem(String nome, List<Equipe> equipes) {
        this.nome = nome;
        this.equipes = equipes;
    }

    public Linguagem(String nome) {
        this.nome = nome;
    }
}
