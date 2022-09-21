package br.sgsistemas.trainee.loja.dao;

import br.sgsistemas.trainee.loja.modelo.Cliente;

import javax.persistence.EntityManager;

public class ClienteDao {
    private EntityManager entityManager;
    public ClienteDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Cliente cliente){
        this.entityManager.persist(cliente);
    }

    public Cliente atualizar(Cliente cliente) {
        this.entityManager.merge(cliente);
        return cliente;
    }

    public void remover(Cliente cliente){
        this.entityManager.remove(atualizar(cliente));
    }
    public Cliente buscarPorId(Long id) {
        return entityManager.find(Cliente.class, id);
    }
}
