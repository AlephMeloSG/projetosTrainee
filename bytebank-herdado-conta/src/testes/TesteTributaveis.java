package testes;

import modelo.CalculadorDeImposto;
import modelo.ContaCorrente;
import modelo.SeguroDeVida;

public class TesteTributaveis { // pode herdar apenas uma classe, porém pode-se herdar várias interfaces..
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente(4444,222);
        contaCorrente.deposita(100);

        SeguroDeVida seguroDeVida = new SeguroDeVida();

        CalculadorDeImposto calculadorDeImposto = new CalculadorDeImposto();
        calculadorDeImposto.registra(contaCorrente);
        calculadorDeImposto.registra(seguroDeVida);

        System.out.println(calculadorDeImposto.getTotalImposto());
    }
}
