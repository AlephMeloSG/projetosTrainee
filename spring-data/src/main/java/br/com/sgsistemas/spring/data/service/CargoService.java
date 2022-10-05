package br.com.sgsistemas.spring.data.service;

import br.com.sgsistemas.spring.data.model.Cargo;
import br.com.sgsistemas.spring.data.repository.CargoRepository;
import functions.Funcoes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CargoService {
    private final CargoRepository cargoRepository;
    private Cargo cargo;
    private String descricao;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void inicial() {
        boolean system = true;
        while (system) {
            System.out.println("1.Voltar");
            System.out.println("2.Criar");
            System.out.println("3.Atualizar");
            System.out.println("4.Deletar Cargo");
            System.out.println("5.Deletar Todos");
            System.out.println("6.Visualizar");
            int acao = Funcoes.inputInt("Digite o numero correspondente: ", 1, 6);
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
        System.out.println("Descricao do cargo");
        this.descricao = Funcoes.inputStr("Descricao: ");
        cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);
        System.out.println("Cargo Salvo: " + descricao);
    }

    private void atualizar() {
        System.out.println("Digite a id do Cargo Desejado para atualizar");
        int id = Funcoes.inputInt("Id do Cargo: ");
        this.descricao = Funcoes.inputStr("Descricao: ");
        cargo = new Cargo();
        this.cargo.setId(id);
        this.cargo.setDescricao(descricao);
        this.cargoRepository.save(cargo);
        System.out.println("Cargo Atualizado!");
    }

    private void deletarPorId(){
        System.out.println("Digite id do Cargo para deletar");
        int id = Funcoes.inputInt("Id do cargo: ");
        cargoRepository.deleteById(id);
        System.out.println("Deletado com sucesso!");

    }
    private void deletarTodos(){
        cargoRepository.deleteAll();
        System.out.println("Deletado com sucesso!");

    }

    private void visualizar(){
        Pageable pageable = PageRequest.of(0,100, Sort.unsorted());
        Page<Cargo> cargos = cargoRepository.findAll(pageable);
        System.out.println("Cargos pag.0/" + cargos.getTotalPages());
        int pagina = Funcoes.inputInt("Digite o numero da pagina: ") - 1;
        pageable = PageRequest.of(pagina,100,Sort.unsorted());
        cargos = cargoRepository.findAll(pageable);
        System.out.println("Pagina: " + pagina + " Total de cargos: " + cargos.getNumber());
        System.out.println();
        for (Cargo cargo1 : cargos) {
            System.out.println(cargo1);
        }
        System.out.println();
    }
}
