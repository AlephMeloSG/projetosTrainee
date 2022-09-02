public abstract class Conta {

    private static int totalContas;
    protected double saldo;
    private int agencia;
    private int numero;
    private Cliente titular; // valor default da String é null

    public Conta(int agencia, int numero){
        Conta.totalContas += 1;
    }
    public abstract void deposita(double valorDeposita);

    public boolean saque(double sacarValor) {

        if (this.saldo >= sacarValor && sacarValor > 0) {
            this.saldo -= sacarValor;
            return true;
        }
        return false;
    }

    public boolean transferencia(double valorDeTransferencia, Conta destinatario) {
        if (valorDeTransferencia <= this.saldo) {
            this.saldo -= valorDeTransferencia;
            destinatario.deposita(valorDeTransferencia);
            System.out.println("Transferência de " + valorDeTransferencia + " realizada.");
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public static int getTotalContas(){
        return Conta.totalContas;
    }

    public static void removerContas(int quantidade){
        Conta.totalContas -= quantidade;
    }
}
