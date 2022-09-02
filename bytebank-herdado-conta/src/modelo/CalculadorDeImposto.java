package modelo;

import interfaces.Tributaveis;

public class CalculadorDeImposto {
    double TotalImposto;
    public void registra(Tributaveis tributaveis){
            this.TotalImposto += tributaveis.getValorImposto();
    }
    public double getTotalImposto(){
        return this.TotalImposto;
    }
}
