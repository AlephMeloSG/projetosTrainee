package br.com.sgsistemas.trainee.sgERPDB.modelo;

import javax.persistence.*;

@Entity
@Table(name = "cidades")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @ManyToOne
    private UF uf;

    public Cidade() {
    }

    public Cidade(String nome, UF uf) {
        this.nome = nome;
        this.uf = uf;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public UF getUf() {
        return uf;
    }
    public void setUf(UF uf) {
        this.uf = uf;
    }
}
