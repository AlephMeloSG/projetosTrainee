package lojaVirtual.view;

import functions.Funcoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagemParametro2 {
    public static void main(String[] args) throws SQLException {
        Connection con = Funcoes.postgressConnectionFactory();
        PreparedStatement preparedStatement = con.prepareStatement("select id, nome, descricao from produto where id != ?");
        preparedStatement.setInt(1,1);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();

        while (resultSet.next()){
            System.out.print(resultSet.getString("id")+" ");
            System.out.print(resultSet.getString("nome")+" ");
            System.out.print(resultSet.getString("descricao")+" ");
            System.out.println();

        }
    }
}
