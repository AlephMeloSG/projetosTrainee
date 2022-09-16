package prontoAtendimento.controller;

import functions.Funcoes;
import prontoAtendimento.dao.AtendimentoDao;
import prontoAtendimento.modulo.Atendimento;
import prontoAtendimento.modulo.Servico;

import java.sql.Connection;
import java.util.Set;

public class ControllerAtendimento {

    public static void controle(int escolhaAcao, Connection connection) {
        switch (escolhaAcao) {
            case 1: {
                AtendimentoDao atendimentoDao = new AtendimentoDao(connection);
                Set<Atendimento> atendimentos = atendimentoDao.buscar();
                atendimentos.forEach(o -> System.out.println(o));
                break;
            }
            case 2: {
                System.out.println("a");
                break;

            }
            case 3: {
                System.out.println();
                break;
            }
            case 4: {
                System.out.println("Preencha os campos:");
                String campo1 = Funcoes.inputStr("Data: ");
                int campo2 = Funcoes.inputInt("paciente Id: ");
                int campo3 = Funcoes.inputInt("medico Id: ");

                Atendimento atendimento = new Atendimento(campo1,campo2, campo3);
                AtendimentoDao atendimentoDao = new AtendimentoDao(connection);
                atendimentoDao.inserir(atendimento);

                int quantiaServicos = Funcoes.inputInt("Cite a quantia de servicos realizados: ",0,5);
                int quantiaMedicamentos = Funcoes.inputInt("Cite a quantia de mediacmentos: ",0,5);
                for(int i = 0; i <quantiaServicos; i++) {
                    String nome = Funcoes.inputStr("Nome do Servico:");
                    ControllerServico.criarServico(nome, atendimento.getId(), connection);
                }
                for(int i = 0; i <quantiaMedicamentos; i++) {
                    String nome = Funcoes.inputStr("Nome do Medicamento:");
                    ControllerMedicamento.criarMedicamento(nome, atendimento.getId(), connection);
                }
                break;
            }
        }
    }
}
