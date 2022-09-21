package br.sgsistemas.trainee.loja.dao;

import br.sgsistemas.trainee.loja.modelo.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {
    private EntityManager entityManager;
    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria){
        this.entityManager.persist(categoria);
    }

    public Categoria atualizar(Categoria categoria) {
        this.entityManager.merge(categoria);
        return categoria;
    }

    public void remover(Categoria categoria){
        this.entityManager.remove(atualizar(categoria));
    }

}
