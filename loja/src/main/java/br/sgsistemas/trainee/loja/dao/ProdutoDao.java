package br.sgsistemas.trainee.loja.dao;

import br.sgsistemas.trainee.loja.modelo.Produto;
import br.sgsistemas.trainee.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao {
    private EntityManager entityManager;
    public ProdutoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Produto produto){
        this.entityManager.persist(produto);
    }
    public Produto atualizar(Produto produto){
        this.entityManager.merge(produto);
        return produto;
    }
    public void remover(Produto produto){
        this.entityManager.remove(atualizar(produto));
    }

    public Produto buscarPorId(Long id){
        return this.entityManager.find(Produto.class, id);
    }

    public List<Produto> buscarTodos(){
        String jpql = "select p from Produto p";
        return this.entityManager.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> buscarPorNome(String nome){
        String jpql = "select p from Produto p where p.nome = :nome";
        return this.entityManager.createQuery(jpql, Produto.class)
                .setParameter("nome",nome).getResultList();
    }

    public List<Produto> buscarPorNomeDaCategoria(String nome){
        String jpql = "select p from Produto where p.categoria.nome = :nome";
        return this.entityManager.createQuery(jpql, Produto.class)
                .setParameter("nome", nome).getResultList();
    }

    public BigDecimal buscarPrecoDoProdutoComNome(String nome){
        String jpql = "select p.preco from Produto p where p.nome = :nome";
        return this.entityManager.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }
}
