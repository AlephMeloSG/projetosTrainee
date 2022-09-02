public class TesteReferencias {
    public static void main(String[] args) {
        ContaPoupanca primeiraConta = new ContaPoupanca(3455,322);

        primeiraConta.deposita(300);

        ContaPoupanca segundaConta = primeiraConta;

        System.out.println("Primeira Conta tem: " +  primeiraConta.getSaldo());
        System.out.println("Segunda Conta tem: " +  segundaConta.getSaldo());
    }
}
