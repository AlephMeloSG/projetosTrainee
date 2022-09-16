package lojaVirtual.modulo;

import javax.sql.PooledConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class ProdutoDao {
    private Connection connection;
    public ProdutoDao(Connection connection) {
        this.connection = connection;
    }

    public Produto buscar(Integer id){
        String sql = "select * from produto where id = ?";
        Produto produto = null;
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next()){
                    String nome = resultSet.getString("nome");
                    String descricao = resultSet.getString("descricao");
                    produto = new Produto(nome, descricao);
                    produto.setId(id);
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return produto;
    }
    public Set buscar(String nome){
        String sql = "select * from produto where nome = ?";
        Set<Produto>set = new HashSet<>();
        Produto produto = null;
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)){
            preparedStatement.setString(1,nome);
            preparedStatement.execute();
            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next()){
                    Integer id = resultSet.getInt("id");
                    String descricao = resultSet.getString("descricao");
                    produto = new Produto(nome, descricao);
                    produto.setId(id);
                    set.add(produto);
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return set;
    }
    public Set buscar(){
        String sql = "select * from produto";
        Set<Produto>set = new HashSet<>();
        Produto produto = null;
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)){
            preparedStatement.execute();
            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next()){
                    Integer id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    String descricao = resultSet.getString("descricao");
                    produto = new Produto(nome, descricao);
                    produto.setId(id);
                    set.add(produto);
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return set;
    }

    public Produto inserir(Produto produto){
        String sql = "insert into produto (nome,descricao) values(?,?)";
        Produto produto1 = null;
        Set<Produto> set = buscar();
        if(set.contains(produto)) {
            return null;
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,produto.getNome());
            preparedStatement.setString(2,produto.getDescricao());
            preparedStatement.execute();
            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                while (resultSet.next()){
                    produto1 = new Produto(resultSet.getString("nome"), resultSet.getString("descricao"));
                    produto1.setId(resultSet.getInt("id"));
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return produto1;
    }
    public String deletar(Produto produto){
        String sql = "delete from produto where nome = ? and descricao = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,produto.getNome());
            preparedStatement.setString(2,produto.getDescricao());
            preparedStatement.execute();
            return "modificados: " + preparedStatement.getUpdateCount();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public String atualizar(Produto produto){
        String sql = "update produto nome = ?, descricao = ? where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,produto.getNome());
            preparedStatement.setString(2,produto.getDescricao());
            preparedStatement.setInt(3,produto.getId());
            preparedStatement.execute();
            return "modificados: " + preparedStatement.getUpdateCount();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
