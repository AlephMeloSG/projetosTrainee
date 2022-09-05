package modelo;

import exceptions.AlunoException;

import java.util.ArrayList;

public class Aluno {
    private static int totalAlunos;
    private String nome;
    private String cpf;
    private int idade;
    private String sexo = "Não citado";
    private Endereco endereco;
    private Turma turma;
    private static ArrayList<String> cpfs = new ArrayList<String>();



    public Aluno(String nome, String cpf, Endereco endereco) {
        if (cpfs.contains(cpf)){
            throw new AlunoException("modelo.Aluno já existente!");
        }
        cpfs.add(cpf);
        Aluno.totalAlunos += 1;
        this.endereco = endereco;
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTurma() {
        return this.turma.getNumeroClasse();
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public static int getTotalAlunos() {
        return Aluno.totalAlunos;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return
        "modelo.Turma: " + getTurma() + "\n" +
        "Nome: " + getNome() + "\n" +
        "CPF: " + getCpf() + "\n" +
        "Idade: " + getIdade() + "\n" +
        "Sexo: " + getSexo() + "\n" +
        "Endereço: " + getEndereco().getCidade() + " - " + getEndereco().getRua() + " - " + getEndereco().getNumero()+ "\n";
    }
}
