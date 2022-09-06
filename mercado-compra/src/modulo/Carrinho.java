package modulo;

import exceptions.AddProdutoException;

import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

    public Carrinho(Cliente cliente) {
        cliente.setCarrinho(this);
    }

    public void addProduto(int codigo, int quantia) {
        for (int i = 1; i <= quantia; i++) {
            listaProdutos.add(Produto.getProduto(codigo));

        }
    }

    public void removerProduto(int codigo, int quantia) {
        for (int i = 0; i < quantia; i++) {
            listaProdutos.remove(Produto.getProduto(codigo));
        }
    }

    public void verCarrinho() {
        System.out.println("Produtos");
        ArrayList<Integer> codigoProduto = new ArrayList<Integer>();
        double total = 0;
        this.listaProdutos.sort(null);
        for (Produto produto : this.listaProdutos) {
            double quantia = 0;
            for (Produto produto1 : this.listaProdutos) {
                if (this.listaProdutos.contains(produto.getCodigo()) != true) {
                    if (produto == produto1) {
                        quantia += 1;
                    }
                }
            }
            if (codigoProduto.contains(produto.getCodigo()) != true) {
                System.out.println("Codigo: " + produto.getCodigo() + " Produto: " + produto.getProdutoNome() + " Quantia: " + quantia + " Valor: " + produto.getValor() * quantia);
                total += quantia * produto.getValor();
                codigoProduto.add(produto.getCodigo());
            }
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("Total: " + total);
        System.out.println();
    }

    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }
}
