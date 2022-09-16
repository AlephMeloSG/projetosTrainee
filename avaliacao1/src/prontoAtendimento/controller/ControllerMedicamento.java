package prontoAtendimento.controller;

import prontoAtendimento.dao.MedicamentoDao;
import prontoAtendimento.modulo.Medicamento;

import java.sql.Connection;

public class ControllerMedicamento {
    public static void criarMedicamento(String nome, int id, Connection connection) {
        Medicamento medicamento = new Medicamento(nome,id);
        MedicamentoDao medicamentoDao = new MedicamentoDao(connection);
        medicamentoDao.inserir(medicamento);
    }
}
