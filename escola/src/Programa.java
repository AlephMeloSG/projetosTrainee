import java.util.List;

public class Programa {
    public static void main(String[] args) {

        Endereco enderecoEscola1 = new Endereco("Maringa", "Rua 061", "107");
        Escola escola1 = new Escola("Colegio Estadual Joao de Faria Pioli", enderecoEscola1);

        Turma turma1Escola1 = new Turma(escola1.getNomeEscola(),"A-5");

        Endereco enderecoAluno1 = new Endereco("Maringa", "Rua 101", "1213");
        Aluno aluno1 = new Aluno("Aleph", "060.660.006-33",enderecoAluno1);
        Endereco enderecoAluno2 = new Endereco("Maringa", "Rua 333", "234");
        Aluno aluno2 = new Aluno("Ricardo", "120.320.564-22",enderecoAluno2);
        Endereco enderecoAluno3 = new Endereco("Sarandi","Rua sao joao","213-a");
        Aluno aluno3 = new Aluno("Fernando", "312.243.567.23",enderecoAluno3);

        turma1Escola1.addAluno(aluno1);
        turma1Escola1.addAluno(aluno2);
        turma1Escola1.addAluno(aluno3);

        System.out.println(escola1.toString()); // info escola

        System.out.println(turma1Escola1.toString()); // info turma

        turma1Escola1.alunoInfo("120.320.564-22"); // info turma aluno

        System.out.println(aluno1.toString()); // info aluno

        System.out.println("Total Alunos Criados:" + Aluno.getTotalAlunos()); // total alunos criados

    }
}
