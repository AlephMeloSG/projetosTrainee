package lojaVirtual.modulo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static int showInfo = 0;

    public static Connection postgressConnect(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/loja_virtual","postgres", "senha1");
            if (showInfo == 1) {
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
