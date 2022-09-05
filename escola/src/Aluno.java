public class Aluno {
    private static int totalAlunos;
    private String nome;
    private String cpf;
    private int idade;

    private String sexo = "Não citado";
    private Endereco endereco;

    private String turma;

    public Aluno(String nome, String cpf, Endereco endereco) {
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

    public String getTurma() {
        return this.turma;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public static int getTotalAlunos() {
        return Aluno.totalAlunos;
    }

    public void setTurma(String numeroClasse) {
        this.turma = numeroClasse;
    }

    @Override
    public String toString() {
        return
        "Turma: " + getTurma() + "\n" +
        "Nome: " + getNome() + "\n" +
        "CPF: " + getCpf() + "\n" +
        "Idade: " + getIdade() + "\n" +
        "Sexo: " + getSexo() + "\n" +
        "Endereço: " + getEndereco().getCidade() + " - " + getEndereco().getRua() + " - " + getEndereco().getNumero()+ "\n";
    }
}
