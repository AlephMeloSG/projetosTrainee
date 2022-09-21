package br.com.sgsistemas.trainee.sgERPDB.main;


import br.com.sgsistemas.trainee.sgERPDB.controller.ClienteController;
import br.com.sgsistemas.trainee.sgERPDB.dao.CidadeDao;
import br.com.sgsistemas.trainee.sgERPDB.dao.ClienteDao;
import br.com.sgsistemas.trainee.sgERPDB.dao.EnderecoDao;
import br.com.sgsistemas.trainee.sgERPDB.dao.UFDao;
import br.com.sgsistemas.trainee.sgERPDB.modelo.Cidade;
import br.com.sgsistemas.trainee.sgERPDB.modelo.Cliente;
import br.com.sgsistemas.trainee.sgERPDB.modelo.Endereco;
import br.com.sgsistemas.trainee.sgERPDB.modelo.UF;
import br.com.sgsistemas.trainee.sgERPDB.util.JPAUtil;
import functions.Funcoes;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        int escolhaAcao = -1;
        EntityManager entityManager = JPAUtil.entityManager();
        entityManager.getTransaction().begin();

        while (true) {
            System.out.println("USO da JPA\n");
            System.out.println("1.Buscar");
            System.out.println("2.Atualizar");
            System.out.println("3.Deletar");
            System.out.println("4.Inserir");
            System.out.println("5.Sair");

            escolhaAcao = Funcoes.inputInt("Digite o numero correspondente: ", 1, 5);
            if (escolhaAcao == 5) {
                entityManager.getTransaction().commit();
                entityManager.close();
                break;
            }
            System.out.println();
            System.out.println("1.Cliente");

            int escolhaTipo = Funcoes.inputInt("Digite o numero correspondente: ", 1, 1);
            System.out.println();

            switch (escolhaTipo) {
                case 1: {
                    ClienteController.controle(escolhaAcao, entityManager);
                    break;
                }
            }

        }
    }
}
