package prontoAtendimento.view;
import prontoAtendimento.controller.*;
import functions.Funcoes;
import prontoAtendimento.dao.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class Programa {
    public static void main(String[] args) {
        int escolhaAcao = -1;
        Connection connection = ConnectionFactory.connectServer();

        while (true) {
            System.out.println("Pronto Atendimento SG Saude\n");
            System.out.println("1.Buscar");
            System.out.println("2.Atualizar");
            System.out.println("3.Deletar");
            System.out.println("4.Inserir");
            System.out.println("5.Sair");

            escolhaAcao = Funcoes.inputInt("Digite o numero correspondente: ", 1, 5);
            if (escolhaAcao == 5){
                try {
                    connection.close();
                }catch (SQLException e){
                    System.out.println("falha ao fechar conexão");
                }
                break;
            }
            System.out.println();
            System.out.println("1.Paciente");
            System.out.println("2.Medico");
            System.out.println("3.Atendimento");

            int escolhaTipo = Funcoes.inputInt("Digite o numero correspondente: ",1,3);
            System.out.println();

            switch (escolhaTipo){
                case 1:{
                    ControllerPaciente.controle(escolhaAcao,connection);
                    break;
                }
                case 2:{
                    ControllerMedico.controle(escolhaAcao,connection);
                    break;
                }
                case 3:{
                    ControllerAtendimento.controle(escolhaAcao,connection);
                    break;
                }
            }

        }
    }
}
