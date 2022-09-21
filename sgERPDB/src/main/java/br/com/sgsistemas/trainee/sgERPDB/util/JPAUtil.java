package br.com.sgsistemas.trainee.sgERPDB.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("sgERPDB");

    public static EntityManager entityManager(){
        return FACTORY.createEntityManager();
    }
}
