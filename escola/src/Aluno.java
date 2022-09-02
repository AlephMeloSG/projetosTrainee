public class Aluno {
    private static int totalAlunos;
    private String nome;
    private String cpf;
    private int idade;

    private String sexo;
    private Endereco endereco;

    private Turma turma;

    public Aluno(String nome, String cpf, Endereco endereco){
        Aluno.totalAlunos += 1;
        this.endereco = endereco;
        this.nome = nome;
        this.cpf = cpf;
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

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Turma getTurma() {
        return turma;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public static int getTotalAlunos(){
        return Aluno.totalAlunos;
    }
}
