public abstract class Funcionario {
    private String nome;
    private String cpf;
    private Double salario;
    private static int totalFuncionarios;

    public Funcionario(){
        Funcionario.totalFuncionarios += 1;
    }

    public abstract double getBoneficacao();

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

    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public static int getTotalFuncionarios() {
        return totalFuncionarios;
    }
}
