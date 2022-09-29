package lojaVirtual.view;

import functions.Funcoes;
import lojaVirtual.modulo.Produto;

import java.sql.*;
import java.util.*;

public class TesteConexao {
    public static void main(String[] args) throws SQLException {
        //Set<Produto> produtos = new HashSet<>();

        ArrayList<Produto> produtos = new ArrayList<>();
        Funcoes.showInfo = true;
        try (Connection connection = Funcoes.postgressDriverConnectionFactory()){
//            Connection connection = Funcoes.postgressDriverConnect("jdbc:postgresql://localhost:5432/loja_virtual","postgres", "senha1"); // Abre conexao

            Statement statement = connection.createStatement();
            statement.execute("select id,nome,descricao from produto");
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()){
                Produto produto = new Produto(resultSet.getString("nome"),resultSet.getString("descricao"));
                produto.setId(resultSet.getInt("id"));
                produtos.add(produto);
            }

            produtos.forEach(produto -> System.out.println(produto));


            resultSet.close();
            statement.close();
            Funcoes.postgressDriverDisconnect(connection); // Fecha Conexao

        } catch (SQLException e){
            //System.out.println(e.getMessage());
            System.out.println();
        }

    }
}