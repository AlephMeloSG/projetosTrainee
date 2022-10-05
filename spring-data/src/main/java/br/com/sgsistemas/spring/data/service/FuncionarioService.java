package br.com.sgsistemas.spring.data.service;

import br.com.sgsistemas.spring.data.model.Funcionario;
import br.com.sgsistemas.spring.data.model.UnidadeTrabalho;
import br.com.sgsistemas.spring.data.repository.CargoRepository;
import br.com.sgsistemas.spring.data.repository.FuncionarioRepository;
import br.com.sgsistemas.spring.data.repository.UnidadeTrabalhoRepository;
import functions.Funcoes;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
    private final CargoRepository cargoRepository;
    private Funcionario funcionario;
    private String model = "Funcionario";

    public FuncionarioService(FuncionarioRepository funcionarioRepository, UnidadeTrabalhoRepository unidadeTrabalhoRepository, CargoRepository cargoRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
        this.cargoRepository = cargoRepository;
    }

    public void inicial() {
        boolean system = true;
        while (system) {
            System.out.println();
            System.out.println("1.Voltar");
            System.out.println("2.Criar");
            System.out.println("3.Atualizar");
            System.out.println("4.Deletar "+model);
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
        int cargoId = Funcoes.inputInt("Digite o id do Cargo: ");
        funcionario = new Funcionario(nome,cpf,salario,localDate);
        funcionario.setCargo(cargoRepository.findById(cargoId).get());
        funcionario.setUnidadeTrabalhos(unidade());
        funcionarioRepository.save(funcionario);
    }

    private void atualizar() {
        System.out.println("Digite a id do "+model+" para atualizar");
        int id = Funcoes.inputInt("Id: ");
        String nome = Funcoes.inputStr("Nome: ");
        String cpf = Funcoes.inputStr("CPF: ");
        Integer salario = Funcoes.inputInt("Salario: ",1);
        LocalDate localDate = Funcoes.inputLocalDate("Data de contratacao:");
        int cargoId = Funcoes.inputInt("Digite o id do Cargo: ");
        funcionario = new Funcionario(nome,cpf,salario,localDate);
        funcionario.setId(id);
        funcionario.setCargo(cargoRepository.findById(cargoId).get());
        funcionario.setUnidadeTrabalhos(unidade());
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

    private List<UnidadeTrabalho> unidade(){
        boolean system = true;
        List<UnidadeTrabalho> unidadeTrabalhos = new ArrayList<>();

        while (system){
            System.out.println();
            System.out.println("Unidade de trabalhos");
            System.out.println("Digite o numero da acao:");
            System.out.println("1.Adicionar");
            System.out.println("2.Remover");
            System.out.println("3.Visualizar Unidades");
            System.out.println("4.Visualizar Unidades Adicionadas");
            System.out.println("5.Voltar");
            int acao = Funcoes.inputInt("Numero Correspondente: ",1,5);
            System.out.println();
            if (acao==5){
                system = false;
            }else {
                switch (acao) {
                    case 1:{
                        int id = Funcoes.inputInt("Digite o id da Unidade de Trabalho: ");
                        Optional<UnidadeTrabalho> unidade = unidadeTrabalhoRepository.findById(id);
                        unidadeTrabalhos.add(unidade.get());
                        break;
                    }case 2:{
                        int id = Funcoes.inputInt("Digite o id da Unidade de Trabalho: ");
                        Optional<UnidadeTrabalho> unidade = unidadeTrabalhoRepository.findById(id);
                        unidadeTrabalhos.remove(unidade.get());
                        break;
                    }case 3:{
                        for (UnidadeTrabalho unidadeTrabalho : unidadeTrabalhoRepository.findAll()) {
                            System.out.println(unidadeTrabalho);
                        }
                        break;
                    }case 4:{
                        for (UnidadeTrabalho unidadeTrabalho : unidadeTrabalhos) {
                            System.out.println(unidadeTrabalho);
                        }
                        break;
                    }
                }
            }
        }
        return unidadeTrabalhos;
    }
}
