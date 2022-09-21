package br.com.sgsistemas.trainee.sgERPDB.controller;

import br.com.sgsistemas.trainee.sgERPDB.dao.EnderecoDao;
import br.com.sgsistemas.trainee.sgERPDB.modelo.Cidade;
import br.com.sgsistemas.trainee.sgERPDB.modelo.Endereco;
import functions.Funcoes;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.ArrayList;

public class EnderecoController {
    private static ArrayList<Endereco> arrayList = null;
    public static Endereco criaEndereco(Cidade cidade, EntityManager entityManager){
        String logradouro = Funcoes.inputStr("Logradouro: ").toUpperCase();
        String numero = Funcoes.inputStr("Numero: ").toUpperCase();
        String bairro = Funcoes.inputStr("Bairro: ").toUpperCase();
        EnderecoDao enderecoDao = new EnderecoDao(entityManager);
        try {
            return enderecoDao.buscaExisteEndereco(new Endereco(logradouro,numero,bairro,cidade));
        } catch (NoResultException e){
            return new Endereco(logradouro,numero,bairro,cidade);
        }
    }

    public static int escolhaEndereco(EntityManager entityManager){
        EnderecoDao enderecoDao = new EnderecoDao(entityManager);
        int numeracao = 1;
        if (arrayList == null){
            arrayList = (ArrayList<Endereco>) enderecoDao.buscarTodos();
        }
        if (arrayList.size() == 0){
            System.out.println("Nao existem enderecos atualmente.");
            return -1;
        }
        for (Endereco endereco : arrayList) {
            System.out.println(numeracao + "." + endereco.getLogradouro() + ", " + endereco.getNumero());
        }
        return Funcoes.inputInt("Digite o numero correspondente: ",1, arrayList.size()) - 1;
    }

    public static void controle(int escolhaAcao, EntityManager entityManager) {
        EnderecoDao enderecoDao = new EnderecoDao(entityManager);
        switch (escolhaAcao){
            case 1: {
                System.out.println("1.Buscar Todos");
                System.out.println("2.Busca Especifica");
                int escolha = Funcoes.inputInt("Numero Correspondente: ", 1, 2);
                switch (escolha){
                    case 1:{
                        arrayList = (ArrayList<Endereco>) enderecoDao.buscarTodos();
                        arrayList.forEach(o -> System.out.println(o));
                    }
                    case 2:{
                        Endereco endereco = enderecoDao.buscarEndereco(arrayList.get(escolhaEndereco(entityManager)));
                        System.out.println(endereco);
                    }
                }
                break;
            }
            case 2: {
                enderecoDao.atualizar(arrayList.get(escolhaEndereco(entityManager)));
                break;

            }
            case 3: {
                enderecoDao.deletar(arrayList.get(escolhaEndereco(entityManager)));
                break;
            }
            case 4: {
                Endereco endereco = EnderecoController.criaEndereco(CidadeController.criaCidade(UFController.criaUF(entityManager),entityManager),entityManager);
                enderecoDao.cadastra(endereco);
                break;
            }
        }
    }
}
