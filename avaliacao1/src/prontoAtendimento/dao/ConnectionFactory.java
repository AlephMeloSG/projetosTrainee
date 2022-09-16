package prontoAtendimento.dao;

import org.postgresql.ds.PGConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection connectServer() {
        PGConnectionPoolDataSource pgConnectionPoolDataSource;
        try {
            pgConnectionPoolDataSource = new PGConnectionPoolDataSource();
            pgConnectionPoolDataSource.setURL("jdbc:postgresql://localhost:5432/avaliacao1");
            pgConnectionPoolDataSource.setUser("postgres");
            pgConnectionPoolDataSource.setPassword("senha1");
            Connection connection = pgConnectionPoolDataSource.getConnection();
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void disconnectServer(Connection connection) {
        try {
            connection.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
