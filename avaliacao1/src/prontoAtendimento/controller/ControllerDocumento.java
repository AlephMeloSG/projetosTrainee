package prontoAtendimento.controller;

import functions.Funcoes;
import prontoAtendimento.dao.DocumentoDao;
import prontoAtendimento.modulo.Documento;

import java.sql.Connection;
import java.util.Date;

public class ControllerDocumento {
    private static Documento cadastroDocumento(){
        Date dataNascimento = Funcoes.inputDate("Data de Nascimento: ");
        String cpf = Funcoes.inputStr("Cpf: ");
        return new Documento(dataNascimento,cpf);
    }
    public static int criarDocumento(Connection connection) {
        DocumentoDao documentoDao = new DocumentoDao(connection);
        Documento documento = cadastroDocumento();
        documentoDao.inserir(documento);
        return documento.getId();
    }

    public static String atualizarDocumento(int id, Connection connection) {
        DocumentoDao documentoDao = new DocumentoDao(connection);
        Documento documento = cadastroDocumento();
        documento.setId(id);
        return documentoDao.atualizar(documento);
    }
}
