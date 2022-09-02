public class TesteContas {
    public static void main(String[] args) {
        ContaCorrente primeiraConta = new ContaCorrente(3455,322);
        primeiraConta.deposita(200);

        ContaPoupanca contaPoupanca = new ContaPoupanca(3455,322);
        contaPoupanca.deposita(100);

        System.out.println("A Primeira conta tem: " + primeiraConta.getSaldo());
        System.out.println("A Segunda conta tem: " + contaPoupanca.getSaldo());

        contaPoupanca.saque(20);
        primeiraConta.transferencia(100,contaPoupanca);

        System.out.println("A Primeira conta tem: " + primeiraConta.getSaldo());
        System.out.println("A Segunda conta tem: " + contaPoupanca.getSaldo());

    }
}
