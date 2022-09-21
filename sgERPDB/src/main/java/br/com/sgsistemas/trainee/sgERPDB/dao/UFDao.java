package br.com.sgsistemas.trainee.sgERPDB.dao;


import br.com.sgsistemas.trainee.sgERPDB.modelo.UF;

import javax.persistence.EntityManager;
import java.util.List;

public class UFDao {
    private EntityManager entityManager;
    public UFDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastra(UF uf){
        this.entityManager.persist(uf);

    }
    public void atualizar(UF uf){
        this.entityManager.merge(uf);
    }
    public void deletar(UF uf){
        uf = entityManager.merge(uf);
        this.entityManager.remove(uf);
    }
    public List<UF> buscarTodos(){
        String jpql = "select c from UF c";
        return entityManager.createQuery(jpql,UF.class).getResultList();
    }
    public UF buscarUF(UF uf){
        String jpql = "select c from UF c where c.id = :id";
        return entityManager.createQuery(jpql,UF.class)
                .setParameter("id",uf.getSigla())
                .getSingleResult();
    }

}
