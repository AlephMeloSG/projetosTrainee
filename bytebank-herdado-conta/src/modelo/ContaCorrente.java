package modelo;

import interfaces.Tributaveis;

//new br.com.sgsistemas.java.treinee.modelo.ContaCorrente()
public class ContaCorrente extends Conta implements Tributaveis {

	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero);
	}
	
	@Override
	public void saca(double valor) {
		double valorASacar = valor + 0.2;
		super.saca(valorASacar);
	}

	@Override
	public void deposita(double valor) {
        super.deposita(valor);
    }

	@Override
	public double getValorImposto() {
		return super.saldo * 0.01;
	}
}
