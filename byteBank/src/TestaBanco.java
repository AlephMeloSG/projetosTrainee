public class TestaBanco {
    public static void main(String[] args) {

        // PARTE 0

        Cliente cliente = new Cliente();
        cliente.setNome("Marialva pereira");

        Endereco endereco = new Endereco();
        endereco.setCidade("Maringa");
        endereco.setLogradouro("algo");
        endereco.setBairro("algo22");
        endereco.setCep("999999");
        endereco.setComplemento("casa");

        cliente.setEndereco(endereco);


        ContaCorrente conta1 = new ContaCorrente(3455,322);
        conta1.setTitular(cliente);

        ContaPoupanca conta = new ContaPoupanca(3455,322);

        double valorDeTransferencia = 800;


        System.out.printf(
                "Dados Do Cliente:\n" +
                "Nome: %s\n" +
                "Logradouro: %s\n" +
                "Bairro: %s\n" +
                "Cep: %s\n" +
                "complemento: %s\n",
                cliente.getNome(),
                cliente.getEndereco().getLogradouro(),
                cliente.getEndereco().getBairro(),
                cliente.getEndereco().getCep(),
                cliente.getEndereco().getComplemento());

        conta.deposita(750);
        System.out.println("Saldo atual no banco: " + conta.getSaldo() + "\n");

        // (SAQUE)

        double valorDeSaque = 100;
        if (conta.saque(valorDeSaque)){
            System.out.println("Saque feito com sucesso!");
            System.out.println("Saldo atual no banco: " + conta.getSaldo() + "\n");
        } else {
            System.out.println("Não foi possivel realizar o saque.");
            System.out.println("Saldo Requisitado: " + valorDeSaque);
            System.out.println("Saldo disponivel no banco: " + conta.getSaldo());
            System.out.println("Saldo Faltante no banco: " + (valorDeSaque - conta.getSaldo()) + "\n");
        }

        // (TRANSFERENCIA)

        if (conta.transferencia(valorDeTransferencia, conta1)){
            System.out.println("Transferencia feito com sucesso!");
            System.out.println("Saldo atual no banco: " + conta.getSaldo() + "\n");
        } else {
            System.out.println("Não foi possivel realizar á Transferencia para " + "\"" + conta1.getTitular().getNome() + "\"" + ".");
            System.out.println("Saldo Requisitado: " + valorDeTransferencia);
            System.out.println("Saldo disponivel no banco: " + conta.getSaldo());
            System.out.println("Saldo Faltante no banco: " + (valorDeTransferencia - conta.getSaldo()) + "\n");
        }

        System.out.println("Saldo da conta1: " + conta1.getSaldo() + "\n" +
                "Totais de contas criadas:" + Conta.getTotalContas());

    }
}
