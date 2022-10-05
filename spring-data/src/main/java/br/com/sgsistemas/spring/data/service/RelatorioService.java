package br.com.sgsistemas.spring.data.service;

import br.com.sgsistemas.spring.data.model.Funcionario;
import br.com.sgsistemas.spring.data.repository.FuncionarioRepository;
import functions.Funcoes;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RelatorioService {
    private FuncionarioRepository funcionarioRepository;

    public RelatorioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void incial(){
        boolean system = false;
        System.out.println("Opções extras");
        System.out.println("1.Voltar");
        System.out.println("2.Funcionario");
        int acao = Funcoes.inputInt("Numero correspondente: ",1,2);
        switch (acao){
            case 1:{
                system = false;
                break;
            }
            case 2:{
                System.out.println("1.Cancelar");
                System.out.println("2.Buscar Por Nome");
                acao = Funcoes.inputInt("Numero correspondente: ",1,2);
                switch (acao){
                    case 1:{
                        break;
                    }
                    case 2:{
                        buscaFuncionarioByName();
                    }
                }
                break;
            }
        }
    }

    private void buscaFuncionarioByName(){
        String nome = Funcoes.inputStr("Nome do Funcionario: ");
        Optional<Funcionario> funcionario = funcionarioRepository.findByNomeLike(nome);
        System.out.println(funcionario.get());
    }
}
