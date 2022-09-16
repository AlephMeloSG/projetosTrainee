package prontoAtendimento.controller;

import functions.Funcoes;
import prontoAtendimento.dao.MedicamentoDao;
import prontoAtendimento.dao.MedicoDao;
import prontoAtendimento.modulo.Medico;

import java.sql.Connection;
import java.util.Date;
import java.util.Set;

public class ControllerMedico {
    private static Medico cadastroMedico(int documentoId,int especialid){
        System.out.println("Preencha os campos:");
        String campo = Funcoes.inputStr("Nome: ");
        int campo1 = Funcoes.inputInt("crm: ");
        return new Medico(campo,documentoId,campo1,especialid);
    }
    public static void controle(int escolhaAcao, Connection connection) {
        switch (escolhaAcao){
            case 1:{
                MedicoDao medicoDao = new MedicoDao(connection);
                Set<Medico> medicos = medicoDao.buscar();
                medicos.forEach(o -> System.out.println(o));
                break;
            }
            case 2:{
                System.out.println("a");
                break;

            }
            case 3:{
                System.out.println();
                break;
            }
            case 4:{

                int documentoId = ControllerDocumento.criarDocumento(connection);
                int especialidadeId = ControllerEspecialidade.criarEspecialidade(connection);
                Medico medico = cadastroMedico(documentoId,especialidadeId);
                MedicoDao medicoDao = new MedicoDao(connection);
                medicoDao.inserir(medico);
                break;
            }
        }
    }
}
