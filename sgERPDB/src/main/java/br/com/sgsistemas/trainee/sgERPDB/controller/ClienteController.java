package br.com.sgsistemas.trainee.sgERPDB.controller;

import br.com.sgsistemas.trainee.sgERPDB.dao.CidadeDao;
import br.com.sgsistemas.trainee.sgERPDB.dao.ClienteDao;
import br.com.sgsistemas.trainee.sgERPDB.dao.EnderecoDao;
import br.com.sgsistemas.trainee.sgERPDB.dao.UFDao;
import br.com.sgsistemas.trainee.sgERPDB.modelo.Cidade;
import br.com.sgsistemas.trainee.sgERPDB.modelo.Cliente;
import br.com.sgsistemas.trainee.sgERPDB.modelo.Endereco;
import br.com.sgsistemas.trainee.sgERPDB.modelo.UF;
import functions.Funcoes;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteController {
    private static ArrayList<Cliente> arrayList = null;

    public static Cliente criaCliente(Endereco endereco, EntityManager entityManager){
        String nome = Funcoes.inputStr("Nome: ").toUpperCase();
        String cpf = Funcoes.inputStr("cpf: ");
        Date dataNascimento = Funcoes.inputDate("DataNascimento: ");
        ClienteDao clienteDao = new ClienteDao(entityManager);
        try {
            return clienteDao.buscarClienteNome(new Cliente(nome,cpf,dataNascimento,endereco));
        } catch (NoResultException e){
            return new Cliente(nome,cpf,dataNascimento,endereco);
        }
    }

    public static int escolhaCliente(EntityManager entityManager){
        ClienteDao clienteDao = new ClienteDao(entityManager);
        int numeracao = 1;
        if (arrayList == null){
            arrayList = (ArrayList<Cliente>) clienteDao.buscarTodos();
        }
        if (arrayList.size() < 1){
            System.out.println("Nao existem clientes atualmente.");
            return -1;
        }
        for (Cliente cliente : arrayList) {
            System.out.println(numeracao + "." + cliente.getNome());
        }
        return Funcoes.inputInt("Digite o numero correspondente: ",1, arrayList.size()) - 1;
    }

    public static void controle(int escolhaAcao, EntityManager entityManager) {
        ClienteDao clienteDao = new ClienteDao(entityManager);
        EnderecoDao enderecoDao =new EnderecoDao(entityManager);
        CidadeDao cidadeDao =new CidadeDao(entityManager);
        switch (escolhaAcao){
            case 1: {
                System.out.println("1.Buscar Todos");
                System.out.println("2.Busca Especifica");
                int escolha = Funcoes.inputInt("Numero Correspondente: ", 1, 2);
                System.out.println();
                switch (escolha){
                    case 1:{
                        arrayList = (ArrayList<Cliente>) clienteDao.buscarTodos();
                        arrayList.forEach(o -> System.out.println(o));
                        break;
                    }
                    case 2:{
                        Cliente cliente = clienteDao.buscarCliente(arrayList.get(escolhaCliente(entityManager)));
                        System.out.println(cliente);
                        break;
                    }
                }
                break;
            }
            case 2: {
                Cliente cliente = arrayList.get(escolhaCliente(entityManager));
                cliente.setNome(Funcoes.inputStr("Nome: ").toUpperCase());
                cliente.setCpf(Funcoes.inputStr("cpf: "));
                Endereco novoEndereco = EnderecoController.criaEndereco(
                        CidadeController.criaCidade(UFController.criaUF(entityManager),entityManager),entityManager);
                cliente.setDataNascimento(Funcoes.inputDate("DataNascimento: "));
                cliente.getEndereco().setBairro(novoEndereco.getBairro());
                cliente.getEndereco().setCidade(novoEndereco.getCidade());
                cliente.getEndereco().setLogradouro(novoEndereco.getLogradouro());
                cliente.getEndereco().setNumero(novoEndereco.getNumero());
                cliente.getEndereco().getCidade().setNome(novoEndereco.getCidade().getNome());
                cliente.getEndereco().getCidade().getUf().setSigla(novoEndereco.getCidade().getUf().getSigla());
                cliente.getEndereco().getCidade().getUf().setDescricao(novoEndereco.getCidade().getUf().getDescricao());

                clienteDao.atualizar(cliente);
                break;

            }
            case 3: {
                int escolha = escolhaCliente(entityManager);
                ArrayList<Cliente> resultado = (ArrayList<Cliente>) clienteDao.buscarConectados(arrayList.get(escolha).getEndereco());
                clienteDao.deletar(arrayList.get(escolha));
                if (resultado.size() < 2) {
                    enderecoDao.deletar(arrayList.get(escolha).getEndereco());
                    break;
                }
            }
            case 4: {
                UF uf = UFController.criaUF(entityManager);
                Cidade cidade = CidadeController.criaCidade(uf,entityManager);
                Endereco endereco = EnderecoController.criaEndereco(cidade,entityManager);
                Cliente cliente = criaCliente(endereco,entityManager);
                UFDao ufDao = new UFDao(entityManager);
                ufDao.cadastra(uf);
                cidadeDao.cadastra(cidade);
                enderecoDao.cadastra(endereco);
                clienteDao.cadastra(cliente);
                break;
            }
        }
        System.out.println();
        entityManager.flush();
    }
}
