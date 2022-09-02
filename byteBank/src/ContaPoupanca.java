public class ContaPoupanca extends Conta{

    public ContaPoupanca(int agencia, int numero){
        super( agencia, numero);
    }

    @Override
    public void deposita(double valorDeposita) {
        super.saldo += valorDeposita * 1.05;
    }

    public boolean saque(double sacarValor) {
        if ((super.getSaldo() + 0.2) >= sacarValor && sacarValor > 0) {
            sacarValor += 0.5;
            super.saque(sacarValor);
            return true;
        }
        return false;
    }
}
