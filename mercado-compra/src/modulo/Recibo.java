package modulo;

import functions.Funcoes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Recibo {
    Carrinho carrinho;
    public void mostrarcompra(Carrinho carrinho, Cliente cliente){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        Funcoes.printTimes("-",60);
        System.out.println("Compra");
        System.out.println("Data: " + format.format(data));
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Cliente numero: " + Cliente.getCodigo());
        Funcoes.printTimes("-",60);

        ArrayList<Integer> codigoProduto = new ArrayList<Integer>();
        double total = 0;
        System.out.println("Produtos");
        for(Produto produto : carrinho.getListaProdutos()) {
            double quantia = 0;
            for (Produto produto1 :carrinho.getListaProdutos()) {
                if (carrinho.getListaProdutos().contains(produto.getCodigo()) != true) {
                    if (produto == produto1) {
                        quantia += 1;
                    }
                }
            }
            if (codigoProduto.contains(produto.getCodigo()) != true) {
                System.out.println(produto.getProdutoNome() + " Quantia: " + quantia + " Valor: " + produto.getValor() * quantia);
                total += quantia*produto.getValor();
                codigoProduto.add(produto.getCodigo());
            }
        }
        Funcoes.printTimes("-",60);
        System.out.println("Total: " + total);
        Funcoes.printTimes("-",60);
    }
}
