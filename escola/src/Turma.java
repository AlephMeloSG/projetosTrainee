import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Turma {
    private static int totalTurmas;
    private String numeroClasse;

    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();


    private String escolaNome;

    public Turma(String escolaNome, String numeroClasse){
        Turma.totalTurmas += 1;
        this.escolaNome = escolaNome;
        this.numeroClasse = numeroClasse;
    }


    public String getNumeroClasse() {
        return numeroClasse;
    }

    public String getListaAlunos() {
        String texto = "Alunos: ";

        for (Aluno aluno : alunos){
            if (alunos.get(alunos.size()-1) == aluno) {
                texto += aluno.getNome() + ".";
            } else {
                texto += aluno.getNome() + ", ";
            }
        }
        return texto;
    }

    public void alunoInfo(String cpf){
        for(Aluno aluno: alunos) {
            if (aluno.getCpf().equals(cpf)){
                System.out.println(aluno.toString());
            }
        }
    }

    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
        aluno.setTurma(numeroClasse);
    }

    public String getEscolaNome() {
        return escolaNome;
    }

    public static int getTotalTurmas(){
        return Turma.totalTurmas;
    }

    @Override
    public String toString() {
        return "Turma:  " + numeroClasse + '\n' +
                getListaAlunos() + '\n' +
                "Nome da Escola: " + escolaNome + '\n';
    }
}
