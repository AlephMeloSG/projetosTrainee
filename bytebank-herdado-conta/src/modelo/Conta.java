package modelo;

import Exceptions.SaldoInsuficienteException;
import Exceptions.ValorNegativoException;

public abstract class Conta {

    protected double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total = 0;
    
    public Conta(int agencia, int numero){
        Conta.total++;
        //System.out.println("O total de contas é " + br.com.sgsistemas.java.treinee.modelo.Conta.total);
        setAgencia(agencia);
        setNumero(numero);
        //this.saldo = 100;
        //System.out.println("Estou criando uma conta " + this.numero);
    }

    /**
     *
     * @param valor
     * Valor precisa-se ser positivo
     * @throws ValorNegativoException
     * Excecao em caso o Valor seja negativo
     */
    public void deposita(double valor){
        if (valor <= 0) {
            throw new ValorNegativoException("Não é possivel usar valor negativo.");
        }
        this.saldo += valor;
    };

    public void saca(double valor) {
        if(this.saldo < valor) {
            throw new SaldoInsuficienteException("Valor acima do saldo. Saldo: " + this.saldo + " Valor: " + valor);
        } else if (valor <= 0) {
            throw new ValorNegativoException("Não é possivel usar valor negativo.");
        }
        this.saldo -= valor;
    }

    public void transfere(double valor, Conta destino) {
        this.saca(valor);
        destino.deposita(valor);
    }

    public double getSaldo(){
        return this.saldo;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        if(agencia < 0) {
            throw new ValorNegativoException("Valor precisa ser positivo, não negativo");
        }
        this.numero = numero;
    }

    public int getAgencia(){
        return this.agencia;
    }

    public void setAgencia(int agencia){
       if(agencia < 0) {
           throw new ValorNegativoException("Valor precisa ser positivo, não negativo");
       }
       this.agencia = agencia;
    }

    public void setTitular(Cliente titular){
        this.titular = titular;
    }

    public Cliente getTitular(){
        return this.titular;
    }

    public static int getTotal(){
        return Conta.total;
    }
}