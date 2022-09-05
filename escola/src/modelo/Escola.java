package modelo;

import exceptions.AlunoAdicionadoException;

import java.util.ArrayList;

public class Escola {
    private static int totalEscolas;
    private String nomeEscola;
    private String diretor = "não citado";
    private String horarioEntrada = "não citado";
    private String horarioSaida = "não citado";
    private ArrayList<Turma> turmas = new ArrayList<Turma>();
    private Endereco endereco;


    public Escola(String nomeEscola, Endereco endereco){
        Escola.totalEscolas += 1;
        this.nomeEscola = nomeEscola;
        this.endereco = endereco;
    }

    public String getNomeEscola() {
        return this.nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public String getDiretor() {
        return this.diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getHorarioEntrada() {
        return this.horarioEntrada;
    }

    public void setHorarioEntrada(String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public String getHorarioSaida() {
        return this.horarioSaida;
    }

    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public static int getTotalEscolas(){
        return Escola.totalEscolas;
    }

    public void addTurma(Turma turma){
        if (this.turmas.contains(turma)){
            throw new AlunoAdicionadoException("modelo.Turma já adicionado(a)!");
        }
        this.turmas.add(turma);
    }

    public ArrayList<Turma> getTurmas(){
        return this.turmas;
    }

    private String getTurmasNumeroClasse(){
        String texto = "";
        for (Turma turma : this.turmas){
            if (this.turmas.get(this.turmas.size()-1) == turma) {
                texto += turma.getNumeroClasse() + ".";
            } else {
                texto += turma.getNumeroClasse() + ", ";
            }
        }
        return texto;
    }

    @Override
    public String toString() {
        return  "modelo.Escola: " + this.nomeEscola + '\n' +
                "Diretor: " + this.diretor + '\n' +
                "Turmas: " + getTurmasNumeroClasse() + '\n' +
                "Horario Entrada: " + this.horarioEntrada + '\n' +
                "Horario Saida: " + this.horarioSaida + '\n' +
                "Endereço: " + getEndereco().getCidade() + " - " + getEndereco().getRua() + " - " + getEndereco().getNumero()+ "\n";
    }
}
