package modelo;

import java.math.BigDecimal;

public class ArrayFunctions {

    private String[] ordemLista;
    private int[] listaNumeros;
    private double[] listaDoblue;
    private boolean[] listaBoleano;
    private BigDecimal[] listaBigDecimal;
    private Object[] listaObjetos;
    private String[] listaString;

    private int posicaoAtual = 0;
    private int posicaoMaxima;

    public ArrayFunctions(int QuantidadePosicoes){
        if (QuantidadePosicoes <= 0){
            throw new NumeroException("Apenas Acima de 0.");
        }
        posicaoMaxima = QuantidadePosicoes;
        listaNumeros = new int[QuantidadePosicoes];
        listaDoblue = new double[QuantidadePosicoes];
        listaBoleano = new boolean[QuantidadePosicoes];
        listaBigDecimal = new BigDecimal[QuantidadePosicoes];
        listaObjetos = new Object[QuantidadePosicoes];
        listaString = new String[QuantidadePosicoes];
        ordemLista = new String[QuantidadePosicoes];
    }

    public void arrayAdd(int numero) {
        if (this.posicaoAtual <= this.posicaoMaxima) {
            this.listaNumeros[this.posicaoAtual] = numero;
            this.ordemLista[this.posicaoAtual] = "int";
            this.posicaoAtual += 1;
        }
    }
    public void arrayAdd(double numero){
        if (this.posicaoAtual <= this.posicaoMaxima) {
            this.listaDoblue[this.posicaoAtual] = numero;
            this.ordemLista[this.posicaoAtual] = "double";
            this.posicaoAtual += 1;
        }
    }
    public void arrayAdd(boolean boleano){
        if (this.posicaoAtual <= this.posicaoMaxima) {
            this.listaBoleano[this.posicaoAtual] = boleano;
            this.ordemLista[this.posicaoAtual] = "boolean";
            this.posicaoAtual += 1;
        }
    }
    public void arrayAdd(BigDecimal bigDecimal){
        if (this.posicaoAtual <= this.posicaoMaxima) {
            this.listaBigDecimal[this.posicaoAtual] = bigDecimal;
            this.ordemLista[this.posicaoAtual] = "bigdecimal";
            this.posicaoAtual += 1;
        }
    }
    public void arrayAdd(Object objeto){
        if (this.posicaoAtual <= this.posicaoMaxima) {
            this.listaObjetos[this.posicaoAtual] = objeto;
            this.ordemLista[this.posicaoAtual] = "object";
            this.posicaoAtual += 1;
        }
    }
    public void arrayAdd(String string){
        if (this.posicaoAtual <= this.posicaoMaxima) {
            this.listaString[this.posicaoAtual] = string;
            this.ordemLista[this.posicaoAtual] = "string";
            this.posicaoAtual += 1;
        }
    }
    public void imprimirArray(){
        System.out.print("[");
        for (int i = 0; i < posicaoMaxima-1; i ++){
            switch (ordemLista[i]){
                case "int":{
                    System.out.print(listaNumeros[i] + ", ");
                    break;
                }
                case "double":{
                    System.out.print(listaDoblue[i] + ", ");
                    break;
                }
                case "boolean":{
                    System.out.print(listaBoleano[i] + ", ");
                    break;
                }
                case "bigdecimal":{
                    System.out.print(listaBigDecimal[i] + ", ");
                    break;
                }
                case "object":{
                    System.out.print(listaObjetos[i] + ", ");
                    break;
                }
                case "string":{
                    System.out.print(listaString[i] + ", ");
                    break;
                }
                default:{
                    System.out.println("vazio ");
                    break;
                }
            }
        }
        System.out.println("]");
    }

}
