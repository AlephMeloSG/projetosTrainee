public class Faxineiro extends Funcionario {

    public double getBoneficacao() {
        System.out.println("Bonificacao do faxineiro.");
        return getSalario() * 1;
    }
}
