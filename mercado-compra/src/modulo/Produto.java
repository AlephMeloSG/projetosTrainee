package modulo;

import java.util.ArrayList;

public class Produto {
    private String produtoNome;
    private int codigo;
    static private int codigoAtual;
    private double valor;

    private static ArrayList<Produto> produtos = new ArrayList<Produto>();

    public Produto(String produtoNome, double valor){
        codigoAtual++;
        this.codigo = codigoAtual;
        this.produtoNome = produtoNome;
        produtos.add(this);
        Mercado.addProduto(this);
        this.valor = valor;
    }


    public String getProdutoNome() {
        return produtoNome;
    }
    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }
    public int getCodigo() {
        return codigo;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    static public Produto getProduto(int codigo){
        for (Produto produto : produtos){
            if (produto.getCodigo()==codigo){
                return produto;
            }
        }
        throw new RuntimeException("Produto inexistente");
    }

    @Override
    public String toString() {
        return "Produto{" +
                "Produto: " + produtoNome + '\n' +
                "Codigo: " + codigo + "\n" +
                "Valor: " + valor;
    }
}
