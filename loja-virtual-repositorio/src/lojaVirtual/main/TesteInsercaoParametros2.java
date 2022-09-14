package lojaVirtual.main;

import functions.Funcoes;
import lojaVirtual.modulo.ConnectionFactory;

import java.sql.*;

public class TesteInsercaoParametros2 {
    public static void main(String[] args) throws SQLException {
        Connection con = Funcoes.postgressConnectionFactory();
        con.setAutoCommit(false);
        PreparedStatement preparedStatement = con.prepareStatement("insert into produto (nome,descricao) values(?, ?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,"Mouse");
        preparedStatement.setString(2,"HP Gamer USB M160 Preto - Sensor Óptico Ambidestro Resoluções até 1000 DPI e Iluminação Multicolor - 7ZZ79AA");
        preparedStatement.execute();
        con.commit();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        while(resultSet.next()){
            System.out.println(resultSet.getInt("id"));
        }
        Funcoes.postgressDisconnect(con);
    }
}
