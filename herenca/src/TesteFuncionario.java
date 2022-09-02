public class TesteFuncionario {
    public static void main(String[] args) {
        Editor funcionario1 = new Editor();
        funcionario1.setNome("Aleph");
        funcionario1.setCpf("067399976-64");
        funcionario1.setSalario(2600.0);


        System.out.println(
                "Nome: " + funcionario1.getNome() + "\n"
                + "CPF: " + funcionario1.getCpf() + "\n"
                + "Salario: " + funcionario1.getSalario() + "\n"
                + "Bonificacao: " + funcionario1.getBoneficacao()
        );


        System.out.println("\nTotal de funcionarios: " + Funcionario.getTotalFuncionarios());
    }
}
