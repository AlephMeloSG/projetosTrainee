package testes;

import modelo.ContaCorrente;
import modelo.ContaPoupanca;

public class TesteContas {
	public static void main(String[] args) {

		try {
			ContaCorrente contaCorrente = new ContaCorrente(100,222);
			ContaPoupanca contaPoupanca = new ContaPoupanca(222,222);
			contaCorrente.deposita(100.00);
			contaPoupanca.deposita(200.00);
			System.out.println("CC: " + contaCorrente.getSaldo());
			System.out.println("CP: " + contaPoupanca.getSaldo());
			contaCorrente.transfere(10.00,contaPoupanca);
			contaPoupanca.transfere(100, contaCorrente);
			contaCorrente.saca(400);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

		System.out.println("Fim do codigo.");
	}
}
