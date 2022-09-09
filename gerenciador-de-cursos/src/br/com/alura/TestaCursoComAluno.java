package br.com.alura;

public class TestaCursoComAluno {
    public static void main(String[] args) {
        Curso javaColecoes = new Curso("Dominando as coleções do Java","Paulo Silveira");

        javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com coleções", 24));

        Aluno aluno = new Aluno("Tananãnnaná", 1);
        Aluno aluno1 = new Aluno("Cassiano", 2);
        Aluno aluno2 = new Aluno("Hubner", 3);
        Aluno aluno3 = new Aluno("Felipe", 4);
        Aluno aluno4 = new Aluno("Aleph", 5);
        Aluno aluno5 = new Aluno("Passoni", 6);


        javaColecoes.matricula(aluno);
        javaColecoes.matricula(aluno1);
        javaColecoes.matricula(aluno2);
        javaColecoes.matricula(aluno3);
        javaColecoes.matricula(aluno4);

        javaColecoes.getAlunos().forEach(alunos -> System.out.println(alunos));
        javaColecoes.estaMatriculado(aluno);
    }
}
