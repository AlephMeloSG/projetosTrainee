package br.sgsistemas.trainee.loja.main;

import br.sgsistemas.trainee.loja.dao.CategoriaDao;
import br.sgsistemas.trainee.loja.dao.ProdutoDao;
import br.sgsistemas.trainee.loja.modelo.Categoria;
import br.sgsistemas.trainee.loja.modelo.Produto;
import br.sgsistemas.trainee.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {
    public static void main(String[] args) {

        cadastrarProduto();

        EntityManager entityManager = JPAUtil.entityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);

        Produto produto = produtoDao.buscarPorId(1l);
        System.out.println(produto.getPreco());

        List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("Celulares");
        todos.forEach(produto1 -> System.out.println(produto1.getNome()));
    }

    private static void cadastrarProduto(){
        Categoria celulares = new Categoria("Celulares");
        Produto celular = new Produto("Poco X3 Pro", "Octa-core", new BigDecimal("1000"),celulares);

        EntityManager entityManager = JPAUtil.entityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        entityManager.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
