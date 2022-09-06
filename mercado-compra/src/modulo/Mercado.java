package modulo;

import java.util.ArrayList;

public class Mercado {
    private static ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

    public static void addProduto(Produto produto){
        listaProdutos.add(produto);
    }
    public static void listaProdutosString(){
        listaProdutos.sort(( produto1,  produto2) -> Double.compare(produto1.getValor(),produto2.getValor()));
        listaProdutos.sort(( produto1,  produto2) -> Character.compare(produto1.getProdutoNome().charAt(0),produto2.getProdutoNome().charAt(0)));

        System.out.println("Produtos");
        listaProdutos.forEach((produto) -> System.out.println("Codigo: " + produto.getCodigo() + " Produto: " + produto.getProdutoNome() + " Valor: " + produto.getValor()));
    }

    public static ArrayList<Produto> getListaProdutos(){
        return listaProdutos;
    }
}
