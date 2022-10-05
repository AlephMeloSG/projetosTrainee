package br.com.sgsistemas.cadastro.cliente.modelo;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String logradouro;
    String numero;
    String bairro;
    String cep;
    String cidade;
    @ManyToOne
    Cliente cliente;

    public Endereco() {
    }
    public Endereco(String logradouro, String numero, String bairro, String cep, String cidade) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    @Override
    public String toString() {
        return  " id: " + id +
                " logradouro: " + logradouro +
                " numero: " + numero +
                " bairro: " + bairro +
                " cep: " + cep +
                " cidade: " + cidade;
    }
}
