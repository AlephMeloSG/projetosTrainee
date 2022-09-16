package lojaVirtual.view;

import lojaVirtual.modulo.ConnectionFactory;

import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
    public static void main(String[] args) throws SQLException {
        Statement statement = ConnectionFactory.postgressConnect().createStatement();
        statement.execute("delete from produto where id = 3");
        System.out.println("modificados: " + statement.getUpdateCount());
        statement.getConnection().close();
    }
}

