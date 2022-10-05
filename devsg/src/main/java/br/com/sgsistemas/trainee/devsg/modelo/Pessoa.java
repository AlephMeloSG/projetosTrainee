package br.com.sgsistemas.trainee.devsg.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    @ManyToOne
    private Equipe equipe;

    public Pessoa(String nome, Cargo cargo, Equipe equipe) {
        this.nome = nome;
        this.cargo = cargo;
        this.equipe = equipe;
    }

}
