package lojaVirtual.view;

import functions.Funcoes;
import lojaVirtual.modulo.Produto;
import lojaVirtual.modulo.ProdutoDao;

import java.sql.Connection;
import java.util.Set;

public class TesteComProdutoDAO {
    public static void main(String[] args) {
        Funcoes.showInfo = true;
        Connection connection = Funcoes.postgressDriverConnectionFactoryPool();

        ProdutoDao produtoDao = new ProdutoDao(connection);

        Produto produto = produtoDao.buscar(2);
        Set<Produto> produtosEspecifico = produtoDao.buscar("Placa de video");
        Set<Produto> produtos = produtoDao.buscar();

        Produto produto1 = new Produto("Impressora","HPLaserJet1020");
        System.out.println(produtoDao.inserir(produto1));
        Funcoes.postgressDriverDisconnect(connection);
    }
}
