package lojaVirtual.modulo;

import org.postgresql.ds.PGConnectionPoolDataSource;


import javax.sql.DataSource;
import javax.sql.PooledConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static boolean showInfo = true;

    public static Connection postgressConnectPool(){
        try {
            PGConnectionPoolDataSource connectionPoolDataSource = new PGConnectionPoolDataSource();
            connectionPoolDataSource.setURL("jdbc:postgresql://localhost:5432/loja_virtual");
            connectionPoolDataSource.setUser("postgres");
            connectionPoolDataSource.setPassword("senha1");
            Connection connection = connectionPoolDataSource.getConnection();
            if (showInfo) {
                System.out.println("Conexão realizada: " + connection);
                System.out.println();
            }
            return connection;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Connection postgressConnect(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/loja_virtual","postgres", "senha1");
            if (showInfo) {
                System.out.println("Conexão realizada: " + connection);
                System.out.println();
            }
            return connection;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
