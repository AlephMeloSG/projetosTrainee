package modulo;

import java.util.ArrayList;

public class Mercado {
    private static ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

    public static void addProduto(Produto produto){
        listaProdutos.add(produto);
    }
    public static void listaProdutos(){
        System.out.println("Produtos");
        for (Produto produto : listaProdutos){
            System.out.println("Codigo: " + produto.getCodigo() + " Produto: " + produto.getProdutoNome() + " Valor: " + produto.getValor());
        }
    }
}
