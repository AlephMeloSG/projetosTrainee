package lojaVirtual.main;

import lojaVirtual.modulo.ConnectionFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
    public static void main(String[] args) throws SQLException {
        Statement statement = ConnectionFactory.postgressConnect().createStatement();
        statement.execute("insert into produto (nome,descricao) values('Mouse', 'LogiTech g300s')", Statement.RETURN_GENERATED_KEYS);

        ResultSet resultSet = statement.getGeneratedKeys();
        while (resultSet.next()){
            Integer id = resultSet.getInt("id");
            System.out.println("Id do item: " + id);
        }
        statement.getConnection().close();
    }
}
