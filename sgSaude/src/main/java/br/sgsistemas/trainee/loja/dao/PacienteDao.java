package br.sgsistemas.trainee.loja.dao;

import br.sgsistemas.trainee.loja.modelo.Paciente;

import javax.persistence.EntityManager;

public class PacienteDao {
    EntityManager entityManager;
    public PacienteDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Paciente paciente){
        entityManager.persist(paciente);
    }
}
