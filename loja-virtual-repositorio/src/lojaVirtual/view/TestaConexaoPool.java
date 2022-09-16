package lojaVirtual.view;

import functions.Funcoes;
import lojaVirtual.modulo.ConnectionFactory;

import javax.sql.PooledConnection;
import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexaoPool {
    public static void main(String[] args) throws SQLException {

        Connection connection = ConnectionFactory.postgressConnectPool();
        connection.close();

        Funcoes.showInfo = true;
        connection = Funcoes.postgressConnectionFactoryPool();
        Funcoes.postgressDisconnect(connection);
    }
}
