package br.com.sgsistemas.trainee.devsg.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    private Equipe equipe;

    public Produto(String nome, Equipe equipe) {
        this.nome = nome;
        this.equipe = equipe;
    }
}
