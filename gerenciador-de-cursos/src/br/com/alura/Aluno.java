package br.com.alura;

import java.util.Collections;
import java.util.Set;

public class Aluno {
    private String nome;
    private int numeroMatricula;

    public Aluno(String nome, int numeroMatricula) {
        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    @Override
    public String toString() {
        return "Aluno: " + nome + " | Matricula: " + numeroMatricula;
    }

    @Override
    public boolean equals(Object obj) {
        Aluno aluno = (Aluno)obj;
        return this.nome.equals((aluno.nome));
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }
}
