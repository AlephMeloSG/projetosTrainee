
public class Programa {
    public static void main(String[] args) {

        Contribuinte Pessoa1 = new Contribuinte();
        Pessoa1.nome = "Aleph Costa Melo";
        Pessoa1.cpf = "034.178.439-79";
        Pessoa1.salario = 4664.69;
        Pessoa1.dataNascimento = "11/08/2004";
        Pessoa1.entregaImpostoRenda = true;

        Contribuinte Pessoa2 = new Contribuinte();
        Pessoa2.nome = "Raphaelle Costa Melo";
        Pessoa2.cpf = "025.128.417-67";
        Pessoa2.salario = 1664.69;
        Pessoa2.dataNascimento = "10/04/2003";
        Pessoa2.entregaImpostoRenda = false;

        if (Pessoa1.entregaImpostoRenda) {
            ImpostoRenda impostoRenda = new ImpostoRenda(Pessoa1);
            impostoRenda.calcular();
            System.out.println(impostoRenda.toString()+"\n");
        }

        if (Pessoa2.entregaImpostoRenda) {
            ImpostoRenda impostoRenda = new ImpostoRenda(Pessoa2);
            impostoRenda.calcular();
            System.out.println(impostoRenda.toString());
        }
    }
}