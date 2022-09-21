package br.sgsistemas.trainee.loja.dao;

import br.sgsistemas.trainee.loja.modelo.Pedido;

import javax.persistence.EntityManager;

public class PedidoDao {
    private EntityManager entityManager;
    public PedidoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Pedido pedido){
        this.entityManager.persist(pedido);
    }

    public Pedido atualizar(Pedido pedido) {
        this.entityManager.merge(pedido);
        return pedido;
    }

    public void remover(Pedido pedido){
        this.entityManager.remove(atualizar(pedido));
    }
}
