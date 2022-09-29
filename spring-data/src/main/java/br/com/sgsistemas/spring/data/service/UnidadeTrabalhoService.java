package br.com.sgsistemas.spring.data.service;

import br.com.sgsistemas.spring.data.model.Funcionario;
import br.com.sgsistemas.spring.data.model.UnidadeTrabalho;
import br.com.sgsistemas.spring.data.repository.FuncionarioRepository;
import br.com.sgsistemas.spring.data.repository.UnidadeTrabalhoRepository;
import functions.Funcoes;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UnidadeTrabalhoService {
    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
    private UnidadeTrabalho unidadeTrabalho;
    private String model = "Unidade de Trabalho";

    public UnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
    }

    public void inicial() {
        boolean system = true;
        while (system) {
            System.out.println();
            System.out.println("1.Voltar");
            System.out.println("2.Criar");
            System.out.println("3.Atualizar");
            System.out.println("4.Deletar Cargo");
            System.out.println("5.Deletar Todos");
            System.out.println("6.Visualizar");
            int acao = Funcoes.inputInt("Digite o numero correspondente: ", 1, 6);
            System.out.println();
            switch (acao) {
                case 1: {
                    system = false;
                    break;
                }
                case 2: {
                    salvar();
                    break;
                }
                case 3: {
                    atualizar();
                    break;
                }
                case 4:{
                    deletarPorId();
                    break;
                }
                case 5:{
                    if (Funcoes.inputStr("Certeza? ").substring(0,1).toLowerCase().equals("s")) {
                        deletarTodos();
                        System.out.println("Todos foram deletados!");
                    }
                    break;
                }
                case 6:{
                    visualizar();
                    break;
                }
            }
        }
    }

    private void salvar() {
        System.out.println(model+":");
        String descricao = Funcoes.inputStr("Descricao: ");
        String endereco = Funcoes.inputStr("Endereco: ");
        unidadeTrabalho = new UnidadeTrabalho(descricao,endereco);
        unidadeTrabalhoRepository.save(unidadeTrabalho);
    }

    private void atualizar() {
        System.out.println("Digite a id do "+model+" para atualizar");
        int id = Funcoes.inputInt("Id: ");
        String descricao = Funcoes.inputStr("Descricao: ");
        String endereco = Funcoes.inputStr("Endereco: ");
        unidadeTrabalho = new UnidadeTrabalho(descricao,endereco);
        unidadeTrabalho.setId(id);
        unidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println(model+" Atualizado!");
    }

    private void deletarPorId(){
        System.out.println("Digite id do "+model+" para deletar");
        int id = Funcoes.inputInt("Id: ");
        unidadeTrabalhoRepository.deleteById(id);
        System.out.println(model+" Deletado!");

    }
    private void deletarTodos(){
        unidadeTrabalhoRepository.deleteAll();
    }

    private void visualizar(){
        System.out.println(model+": ");
        Iterable<UnidadeTrabalho> unidadeTrabalhos = unidadeTrabalhoRepository.findAll();
        for (UnidadeTrabalho unidadeTrabalho1  : unidadeTrabalhos) {
            System.out.println(unidadeTrabalho1);
        }
    }
}
