package prontoAtendimento.controller;

import functions.Funcoes;
import prontoAtendimento.dao.EspecialidadesDao;
import prontoAtendimento.modulo.Especialidades;

import java.sql.Connection;

public class ControllerEspecialidade {
    public static int criarEspecialidade(Connection connection) {
        String nome = Funcoes.inputStr("Especialidade: ");
        Especialidades especialidade = new Especialidades(nome);
        EspecialidadesDao especialidadesDao = new EspecialidadesDao(connection);
        especialidadesDao.inserir(especialidade);
        return especialidade.getId();
    }
}
