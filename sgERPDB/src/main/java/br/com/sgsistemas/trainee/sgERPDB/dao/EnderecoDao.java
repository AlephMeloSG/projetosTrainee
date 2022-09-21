package br.com.sgsistemas.trainee.sgERPDB.dao;

import br.com.sgsistemas.trainee.sgERPDB.modelo.Endereco;

import javax.persistence.EntityManager;
import java.util.List;

public class EnderecoDao {
    private EntityManager entityManager;
    public EnderecoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastra(Endereco endereco){
        this.entityManager.persist(endereco);

    }
    public void atualizar(Endereco endereco){
        this.entityManager.merge(endereco);
    }
    public void deletar(Endereco endereco){
        endereco = entityManager.merge(endereco);
        this.entityManager.remove(endereco);
    }
    public List<Endereco> buscarTodos(){
        String jpql = "select e from Endereco c";
        return entityManager.createQuery(jpql,Endereco.class).getResultList();
    }
    public Endereco buscarEndereco(Endereco endereco){
        String jpql = "select e from Endereco e where c.id = :id";
        return entityManager.createQuery(jpql,Endereco.class)
                .setParameter("id",endereco.getId())
                .getSingleResult();
    }

    public Endereco buscaExisteEndereco(Endereco endereco) {
        String jpql = "select e from Endereco e where e.logradouro = :logradouro and e.numero = :numero and e.cidade.nome = :nome";
        return entityManager.createQuery(jpql,Endereco.class)
                .setParameter("logradouro",endereco.getLogradouro())
                .setParameter("numero",endereco.getNumero())
                .setParameter("nome",endereco.getCidade().getNome())
                .getSingleResult();
    }
}
