package br.com.sgsistemas.spring.data.service;

import br.com.sgsistemas.spring.data.model.Cargo;
import br.com.sgsistemas.spring.data.model.Funcionario;
import br.com.sgsistemas.spring.data.repository.CargoRepository;
import br.com.sgsistemas.spring.data.repository.FuncionarioRepository;
import functions.Funcoes;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private Funcionario funcionario;
    private String model = "Funcionario";

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
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
        String nome = Funcoes.inputStr("Nome: ");
        String cpf = Funcoes.inputStr("CPF: ");
        Integer salario = Funcoes.inputInt("Salario: ",1);
        LocalDate localDate = Funcoes.inputLocalDate("Data de contratacao:");
        funcionario = new Funcionario(nome,cpf,salario,localDate);
        funcionarioRepository.save(funcionario);
    }

    private void atualizar() {
        System.out.println("Digite a id do "+model+" para atualizar");
        int id = Funcoes.inputInt("Id: ");
        String nome = Funcoes.inputStr("Nome: ");
        String cpf = Funcoes.inputStr("CPF: ");
        Integer salario = Funcoes.inputInt("Salario: ",1);
        LocalDate localDate = Funcoes.inputLocalDate("Data de contratacao:");
        funcionario = new Funcionario(nome,cpf,salario,localDate);
        funcionario.setId(id);
        funcionarioRepository.save(funcionario);
        System.out.println(model+" Atualizado!");
    }

    private void deletarPorId(){
        System.out.println("Digite id do "+model+" para deletar");
        int id = Funcoes.inputInt("Id: ");
        funcionarioRepository.deleteById(id);
        System.out.println(model+" Deletado!");

    }
    private void deletarTodos(){
        funcionarioRepository.deleteAll();
    }

    private void visualizar(){
        System.out.println(model+": ");
        Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
        for (Funcionario funcionario1 : funcionarios) {
            System.out.println(funcionario1);
        }
    }
}
