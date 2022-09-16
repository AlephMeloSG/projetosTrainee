package prontoAtendimento.controller;

import prontoAtendimento.dao.ServicoDao;
import prontoAtendimento.modulo.Servico;

import java.sql.Connection;

public class ControllerServico {
    public static void criarServico(String nome, int id, Connection connection) {
        Servico servico = new Servico(nome,id);
        ServicoDao servicoDao = new ServicoDao(connection);
        servicoDao.inserir(servico);
    }
}
