package modelo;

public class Array {
    private int posicaoAtual = 0;
    private Object[] listaReferencia;

    public void add(Object referencia){
        this.listaReferencia[posicaoAtual] = referencia;
        posicaoAtual += 1;
    }

    public int getTamanhoArray(){
        return posicaoAtual;
    }

    public Object getReferencia(int numero){
        return listaReferencia[numero];
    }

}
