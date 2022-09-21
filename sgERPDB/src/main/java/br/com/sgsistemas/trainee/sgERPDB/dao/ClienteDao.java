package br.com.sgsistemas.trainee.sgERPDB.dao;


import br.com.sgsistemas.trainee.sgERPDB.modelo.Cliente;
import br.com.sgsistemas.trainee.sgERPDB.modelo.Endereco;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDao {
    private EntityManager entityManager;
    public ClienteDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastra(Cliente cliente){
        this.entityManager.persist(cliente);

    }
    public void atualizar(Cliente cliente){
        this.entityManager.merge(cliente);
    }
    public void deletar(Cliente cliente){
        cliente = entityManager.merge(cliente);
        this.entityManager.remove(cliente);
    }
    public List<Cliente> buscarTodos(){
        String jpql = "select c from Cliente c";
        return entityManager.createQuery(jpql,Cliente.class).getResultList();
    }
    public Cliente buscarCliente(Cliente cliente){
        String jpql = "select c from Cliente c where c.id = :id";
        return entityManager.createQuery(jpql,Cliente.class)
                .setParameter("id",cliente.getId())
                .getSingleResult();
    }
    public Cliente buscarClienteNome(Cliente cliente){
        String jpql = "select c from Cliente c where c.nome = :nome";
        return entityManager.createQuery(jpql,Cliente.class)
                .setParameter("nome",cliente.getNome())
                .getSingleResult();
    }
    public List<Cliente> buscarConectados(Endereco endereco){
        String jpql = "select c from Cliente c where c.endereco = :endereco";
        return entityManager.createQuery(jpql,Cliente.class).setParameter("endereco",endereco).getResultList();
    }
}
