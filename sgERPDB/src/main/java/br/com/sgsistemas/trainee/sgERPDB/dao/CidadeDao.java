package br.com.sgsistemas.trainee.sgERPDB.dao;


import br.com.sgsistemas.trainee.sgERPDB.modelo.Cidade;

import javax.persistence.EntityManager;
import java.util.List;

public class CidadeDao {
    private EntityManager entityManager;

    public CidadeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastra(Cidade cidade){
        this.entityManager.persist(cidade);

    }
    public void atualizar(Cidade cidade){
        this.entityManager.merge(cidade);
    }
    public void deletar(Cidade cidade){
        cidade = entityManager.merge(cidade);
        this.entityManager.remove(cidade);
    }
    public List<Cidade> buscarTodos(){
        String jpql = "select c from Cidade c";
        return entityManager.createQuery(jpql,Cidade.class).getResultList();
    }
    public Cidade buscarCidade(Cidade cidade){
        String jpql = "select c from Cidade c where c.id = :id";
        return entityManager.createQuery(jpql,Cidade.class)
                .setParameter("id",cidade.getId())
                .getSingleResult();
    }


    public Cidade buscaExisteCidade(Cidade cidade) {
        String jpql = "select c from Cidade c where c.nome = :nome and c.uf.sigla = :sigla";
        return entityManager.createQuery(jpql,Cidade.class)
                .setParameter("nome",cidade.getNome())
                .setParameter("sigla",cidade.getUf().getSigla())
                .getSingleResult();
    }
}
