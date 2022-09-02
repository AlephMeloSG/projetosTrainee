public class TesteGerente {
    public static void main(String[] args) {
        Gerente gerente1 = new Gerente();
        gerente1.setNome("TRIBUTO BBA");
        gerente1.setCpf("067399976-64");
        gerente1.setSalario(3000.0);

        gerente1.setSenha(2222);

        int digiteSenha = 2222;

        if (gerente1.autenticaSenha(digiteSenha)) {
            System.out.println(
                    "Nome: " + gerente1.getNome() + "\n"
                            + "CPF: " + gerente1.getCpf() + "\n"
                            + "Salario: " + gerente1.getSalario() + "\n"
                            + "Bonificacao: " + gerente1.getBoneficacao()
            );
        } else {
            System.out.println("Senha invalida!");
        }

        Editor funcionario1 = new Editor();
        funcionario1.setNome("Aleph");
        funcionario1.setCpf("067399976-64");
        funcionario1.setSalario(2500.0);

        System.out.println(
                "\nNome: " + funcionario1.getNome() + "\n"
                        + "CPF: " + funcionario1.getCpf() + "\n"
                        + "Salario: " + funcionario1.getSalario() + "\n"
                        + "Bonificacao: " + funcionario1.getBoneficacao() + "\n"
        );

        Editor editor = new Editor();
        editor.setNome("Aleph");
        editor.setCpf("067399976-64");
        editor.setSalario(1500.0);

        System.out.println(
                "\nNome: " + editor.getNome() + "\n"
                        + "CPF: " + editor.getCpf() + "\n"
                        + "Salario: " + editor.getSalario() + "\n"
                        + "Bonificacao: " + editor.getBoneficacao() + "\n"
        );

        ControleBonificacao controle = new ControleBonificacao();

        controle.registra(funcionario1);
        controle.registra(gerente1);
        controle.registra(editor);
        System.out.println(controle.totalBonificacaoFuncionarios());
        System.out.println("Total de Gerentes: " + Gerente.getTotalGerentes());
        System.out.println("Total de funcionarios: " + Funcionario.getTotalFuncionarios());
    }
}










