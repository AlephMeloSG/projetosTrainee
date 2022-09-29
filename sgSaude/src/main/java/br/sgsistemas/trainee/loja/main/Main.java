package br.sgsistemas.trainee.loja.main;

import br.sgsistemas.trainee.loja.util.JPAUtil;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}