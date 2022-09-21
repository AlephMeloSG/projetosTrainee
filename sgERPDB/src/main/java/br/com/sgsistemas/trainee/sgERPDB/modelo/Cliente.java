package br.com.sgsistemas.trainee.sgERPDB.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    @Column (name = "data_nascimento")
    private Date dataNascimento;
    @ManyToOne
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, Date dataNascimento, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
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

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    @Override
    public String toString() {
        return "nome: " + nome + '\n' +
                "cpf: " + cpf + '\n' +
                "dataNascimento: " + dataNascimento + '\n' +
                "logradouro: " + endereco.getLogradouro() + '\n' +
                "numero: " + endereco.getNumero() + '\n' +
                "cidade: " + endereco.getCidade().getNome() + '\n' +
                "Estado: " + endereco.getCidade().getUf().getDescricao();
    }
}
