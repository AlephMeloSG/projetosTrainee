package br.com.sgsistemas.trainee.sgERPDB.controller;

import br.com.sgsistemas.trainee.sgERPDB.dao.CidadeDao;
import br.com.sgsistemas.trainee.sgERPDB.modelo.Cidade;
import br.com.sgsistemas.trainee.sgERPDB.modelo.UF;
import functions.Funcoes;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.ArrayList;

public class CidadeController {
    private static ArrayList<Cidade> arrayList = null;
    public static Cidade criaCidade(UF uf, EntityManager entityManager) {
        String cidadeTexto = Funcoes.inputStr("Cidade: ").toUpperCase();
        CidadeDao cidadeDao = new CidadeDao(entityManager);
        try {
            return cidadeDao.buscaExisteCidade(new Cidade(cidadeTexto,uf));
        } catch (NoResultException e){
            return new Cidade(cidadeTexto,uf);
        }
    }

    public static int escolhaCidade(EntityManager entityManager){
        CidadeDao cidadeDao = new CidadeDao(entityManager);
        int numeracao = 1;
        if (arrayList == null){
            arrayList = (ArrayList<Cidade>) cidadeDao.buscarTodos();
        }
        if (arrayList.size() < 1){
            System.out.println("Nao existem cidades atualmente.");
            return -1;
        }
        for (Cidade cidade : arrayList) {
            System.out.println(numeracao + "." + cidade.getNome() + ", " + cidade.getUf().getDescricao());
        }
        return Funcoes.inputInt("Digite o numero correspondente: ",1, arrayList.size()) - 1;
    }

    public static void controle(int escolhaAcao, EntityManager entityManager) {
        CidadeDao cidadeDao = new CidadeDao(entityManager);
        switch (escolhaAcao) {
            case 1: {
                System.out.println("1.Buscar Todos");
                System.out.println("2.Busca Especifica");
                int escolha = Funcoes.inputInt("Numero Correspondente: ", 1, 2);
                switch (escolha) {
                    case 1: {
                        arrayList = (ArrayList<Cidade>) cidadeDao.buscarTodos();
                        arrayList.forEach(o -> System.out.println(o));
                    }
                    case 2: {
                        Cidade cidade = cidadeDao.buscarCidade(arrayList.get(escolhaCidade(entityManager)));
                        System.out.println(cidade);
                    }
                }
                break;
            }
            case 2: {
                cidadeDao.atualizar(arrayList.get(escolhaCidade(entityManager)));
                break;

            }
            case 3: {
                cidadeDao.deletar(arrayList.get(escolhaCidade(entityManager)));
                break;
            }
            case 4: {
                Cidade cidade = CidadeController.criaCidade(UFController.criaUF(entityManager),entityManager);
                cidadeDao.cadastra(cidade);
                break;
            }
        }
    }
}
