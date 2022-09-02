public class Programa {
    public static void main(String[] args) {

        Endereco enderecoEscola1 = new Endereco("Maringa", "Rua 061", "107");
        Escola escola1 = new Escola("Colegio Estadual Joao de Faria Pioli", enderecoEscola1);

        System.out.println(
                escola1.getNomeEscola() + "\n" +
                escola1.getEndereco().getCidade() + "\n" +
                escola1.getEndereco().getRua() + "\n");

        Turma turma1Escola1 = new Turma(escola1.getNomeEscola(),"A-5");

        Endereco enderecoAluno1 = new Endereco("Maringa", "Rua 101", "1213");
        Aluno aluno1 = new Aluno("Aleph", "060.660.006-33",enderecoAluno1);
        Endereco enderecoAluno2 = new Endereco("Maringa", "Rua 333", "234");
        Aluno aluno2 = new Aluno("Ricardo", "120.320.564-22",enderecoAluno2);
        Endereco enderecoAluno3 = new Endereco("Sarandi","Rua sao joao","213-a");
        Aluno aluno3 = new Aluno("Fernando", "312.243.567.23",enderecoAluno3);

        turma1Escola1.addAluno(aluno1.getNome());
        turma1Escola1.addAluno(aluno2.getNome());

        System.out.println(
                turma1Escola1.getNumeroClasse() + "\n" +
                turma1Escola1.getEscolaNome() + "\n" +
                "Alunos:\n" +
                turma1Escola1.getListaAlunos() + "\n"
        );

        System.out.println(
                aluno1.getNome() + "\n" +
                aluno1.getCpf() + "\n" +
                aluno1.getEndereco().getRua() + "\n" +
                aluno1.getEndereco().getNumero()
        );

        System.out.println("Total Alunos Criados:" + Aluno.getTotalAlunos());


    }
}
