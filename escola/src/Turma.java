public class Turma {
    private static int totalTurmas;
    private String numeroClasse;

    private String aluno = "";

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
        return this.aluno;
    }

    public void addAluno(String alunoNome) {
        this.aluno += alunoNome + "\n";
    }

    public String getEscolaNome() {
        return escolaNome;
    }

    public static int getTotalTurmas(){
        return Turma.totalTurmas;
    }
}
