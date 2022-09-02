package modelo;

import interfaces.Tributaveis;

public class SeguroDeVida implements Tributaveis {

    @Override
    public double getValorImposto() {
        return 42;
    }
}
