package br.com.sgsistemas.trainee.sgERPDB.controller;

import br.com.sgsistemas.trainee.sgERPDB.dao.UFDao;
import br.com.sgsistemas.trainee.sgERPDB.modelo.UF;
import functions.Funcoes;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.ArrayList;

public class UFController {
    private static ArrayList<UF> arrayList = null;
    public static UF criaUF(EntityManager entityManager) {
        String sigla = Funcoes.inputStr("UF-Sigla: ").toUpperCase();
        String descricao = Funcoes.inputStr("Estado: ").toLowerCase();
        UFDao ufDao = new UFDao(entityManager);
        try {
            return ufDao.buscarUF(new UF(sigla,descricao));
        } catch (NoResultException e){
            return new UF(sigla,descricao);
        }
    }

    public static int escolhaUF(EntityManager entityManager){
        UFDao ufDao = new UFDao(entityManager);
        int numeracao = 1;
        if (arrayList == null){
            arrayList = (ArrayList<UF>) ufDao.buscarTodos();
        }
        if (arrayList.size() < 1){
            System.out.println("Nao existem ufs atualmente.");
            return -1;
        }
        for (UF uf : arrayList) {
            System.out.println(numeracao + "." + uf.getSigla() + ", " + uf.getDescricao());
        }
        return Funcoes.inputInt("Digite o numero correspondente: ",1, arrayList.size()) - 1;
    }

    public static void controle(int escolhaAcao, EntityManager entityManager) {
        UFDao ufDao = new UFDao(entityManager);
        switch (escolhaAcao){
            case 1: {
                System.out.println("1.Buscar Todos");
                System.out.println("2.Busca Especifica");
                int escolha = Funcoes.inputInt("Numero Correspondente: ", 1, 2);
                switch (escolha){
                    case 1:{
                        arrayList = (ArrayList<UF>) ufDao.buscarTodos();
                        arrayList.forEach(o -> System.out.println(o));
                    }
                    case 2:{
                        UF uf = ufDao.buscarUF(arrayList.get(escolhaUF(entityManager)));
                        System.out.println(uf);
                    }
                }
                break;
            }
            case 2: {
                ufDao.atualizar(arrayList.get(escolhaUF(entityManager)));
                break;

            }
            case 3: {
                ufDao.deletar(arrayList.get(escolhaUF(entityManager)));
                break;
            }
            case 4: {
                UF uf = UFController.criaUF(entityManager);
                ufDao.cadastra(uf);
                break;
            }
        }
    }
}
