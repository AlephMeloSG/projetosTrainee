package br.com.sgsistemas.trainee.sgERPDB.modelo;


import javax.persistence.*;

@Entity
@Table(name = "uf")
public class UF {
    @Id
    String sigla;
    String descricao;

    public UF() {
    }
    public UF(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
