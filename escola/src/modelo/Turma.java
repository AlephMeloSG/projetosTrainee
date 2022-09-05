package modelo;

import exceptions.AlunoAdicionadoException;
import exceptions.TurmaException;

import java.util.ArrayList;

public class Turma {
    private static int totalTurmas;
    private String numeroClasse;
    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    private Escola escola;
    private static ArrayList<String> numeroClasses = new ArrayList<String>();


    public Turma(Escola escola, String numeroClasse){
        if (numeroClasses.contains(numeroClasses)){
            throw new TurmaException("modelo.Turma já existente!");
        }
        numeroClasses.add(numeroClasse);
        Turma.totalTurmas += 1;
        this.escola = escola;
        escola.addTurma(this);
        this.numeroClasse = numeroClasse;
    }

    public String getNumeroClasse() {
        return this.numeroClasse;
    }

    public ArrayList<Aluno> getListaAlunos(){
        return this.alunos;
    }

    private String getListaAlunosNome() {
        String texto = "Alunos: ";
        for (Aluno aluno : this.alunos){
            if (this.alunos.get(this.alunos.size()-1) == aluno) {
                texto += aluno.getNome() + ".";
            } else {
                texto += aluno.getNome() + ", ";
            }
        }
        return texto;
    }

    public void alunoInfo(String cpf){
        for(Aluno aluno: this.alunos) {
            if (aluno.getCpf().equals(cpf)){
                System.out.println(aluno.toString());
            }
        }
    }

    public void addAluno(Aluno aluno) {
        if (this.alunos.contains(aluno)){
            throw new AlunoAdicionadoException("modelo.Aluno(a) já adicionado(a)!");
        }
        for (Turma turma : escola.getTurmas()){
            if(turma.alunos.contains(aluno)){
                throw new AlunoAdicionadoException("modelo.Aluno(a) já se encontra em outra turma!");
            }
        }
        this.alunos.add(aluno);
        aluno.setTurma(this);
    }

    public String getEscolaNome() {
        return this.escola.getNomeEscola();
    }

    public static int getTotalTurmas(){
        return Turma.totalTurmas;
    }

    @Override
    public String toString() {
        return "modelo.Turma:  " + this.numeroClasse + '\n' +
                getListaAlunosNome() + '\n' +
                "Nome da modelo.Escola: " + this.escola.getNomeEscola() + '\n';
    }
}
