package lojaVirtual.main;

import functions.Funcoes;
import lojaVirtual.modulo.Produto;

import java.sql.*;
import java.util.*;

public class TesteConexao {
    public static void main(String[] args) throws SQLException {
        //Set<Produto> produtos = new HashSet<>();

        ArrayList<Produto> produtos = new ArrayList<>();
        Funcoes.showInfo = true;
        try (Connection connection = Funcoes.postgressConnectionFactory()){
//            Connection connection = Funcoes.postgressConnect("jdbc:postgresql://localhost:5432/loja_virtual","postgres", "senha1"); // Abre conexao

            Statement statement = connection.createStatement();
            statement.execute("select id,nome,descricao from produto");
            ResultSet resultSet = statement.getResultSet();
            statement.close();

            while (resultSet.next()){
                produtos.add(new Produto(resultSet.getInt("id"),resultSet.getString("nome"),resultSet.getString("descricao")));
            }

            produtos.forEach(produto -> System.out.println(produto));


//            connection.close(); // fecha conexao
            resultSet.close();
            Funcoes.postgressDisconnect(connection); // Fecha Conexao

        } catch (SQLException e){
            //System.out.println(e.getMessage());
            System.out.println();
        }

    }
}

//            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/loja_virtual","postgres", "senha1");
//            System.out.println("fechando");
//            connection.close();