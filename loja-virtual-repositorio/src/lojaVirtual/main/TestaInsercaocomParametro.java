package lojaVirtual.main;

import lojaVirtual.modulo.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaocomParametro {
    public static void main(String[] args) throws SQLException {
        String nome = "algo";
        String descricao = "algo2";

        PreparedStatement statement = ConnectionFactory.postgressConnect().prepareStatement("insert into produto (nome,descricao) values(?, ?)", Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,nome);
        statement.setString(2,descricao);
        statement.execute();

        ResultSet resultSet = statement.getGeneratedKeys();
        while (resultSet.next()){
            Integer id = resultSet.getInt("id");
            System.out.println("Id do item: " + id);
        }
        statement.getConnection().close();
    }
}
