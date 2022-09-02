package testes;

import modelo.Conta;
import modelo.ContaCorrente;
import modelo.ContaPoupanca;

public class TesteContas {
	public static void main(String[] args) {
		ContaCorrente contaCorrente;
		ContaPoupanca contaPoupanca;
		try {
			contaCorrente = new ContaCorrente(100,222);
			contaPoupanca = new ContaPoupanca(222,222);
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


		ContaCorrente[] contas = new ContaCorrente[10];

		ContaCorrente contaCorrente2 = new ContaCorrente(1233,343);
		ContaCorrente contaCorrente1 = new ContaCorrente(9943, 100);

		contas[0] = contaCorrente1;
		contas[1] = contaCorrente2;

		System.out.println(contas[1].getAgencia());

		System.out.println("Fim do codigo.");
	}
}
