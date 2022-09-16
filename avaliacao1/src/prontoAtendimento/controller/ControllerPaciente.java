package prontoAtendimento.controller;

import functions.Funcoes;
import prontoAtendimento.dao.PacienteDao;
import prontoAtendimento.modulo.Documento;
import prontoAtendimento.modulo.Paciente;

import java.sql.Connection;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public class ControllerPaciente {

    private static Paciente cadastroPaciente(int documentoId){
        System.out.println("Preencha os campos:");
        String nome = Funcoes.inputStr("Nome: ");
        String mae = Funcoes.inputStr("Nome da mãe: ");
        int numeroCarteirinha = Funcoes.inputInt("numero da carteirinha: ");
        String pulseira = Funcoes.inputStr("cor da pulseira: ");
        return new Paciente(nome,documentoId,mae,numeroCarteirinha,pulseira);
    }

    public static void controle(int escolhaAcao, Connection connection) {
        switch (escolhaAcao) {
            case 1: {
                PacienteDao pacienteDao = new PacienteDao(connection);
                Set<Paciente> pacientes = pacienteDao.buscar();
                pacientes.forEach(o -> System.out.println(o));
                break;
            }
            case 2: {
                PacienteDao pacienteDao = new PacienteDao(connection);
                ArrayList<Paciente> pacientes = new ArrayList<>();
                pacientes.addAll(pacienteDao.buscar());

                for (int i=1; i<pacientes.size()+1;i++){
                    System.out.println(i + "." + pacientes.get(i-1).getNome());
                }
                int escolha = Funcoes.inputInt("Digite o numero correspondente do paciente para alterar: ",1,pacientes.size()+1);

                int documentoId = pacientes.get(escolha-1).getDocumentoId();
                ControllerDocumento.atualizarDocumento(documentoId, connection);
                Paciente paciente = cadastroPaciente(documentoId);
                paciente.setId(pacientes.get(escolha).getId());
                pacienteDao.atualizar(paciente);
                break;

            }
            case 3: {
                System.out.println();
                break;
            }
            case 4: {
                int documentoId = ControllerDocumento.criarDocumento(connection);
                Paciente paciente = cadastroPaciente(documentoId);
                PacienteDao pacienteDao = new PacienteDao(connection);
                pacienteDao.inserir(paciente);
                break;
            }
        }
    }
}
