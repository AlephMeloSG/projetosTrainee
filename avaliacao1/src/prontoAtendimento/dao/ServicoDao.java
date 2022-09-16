package prontoAtendimento.dao;

import prontoAtendimento.modulo.Servico;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ServicoDao {
    Connection connection;

    public ServicoDao(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Servico servico){
        String sql = "insert into servico (nome, atendimento_id) values(?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,servico.getNome());
            preparedStatement.setInt(2,servico.getAtendimentoId());
            preparedStatement.execute();
            connection.commit();
            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                resultSet.next();
                int id = resultSet.getInt("id");
                System.out.println("Item inserido! Codigo: "+id);
                servico.setId(id);
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            try {
                connection.rollback();
            }catch (SQLException ex){
                System.out.println("Falha ao cancelar a execução com o banco");
            }
        }
    }
    public Set buscar(){
        String sql = "select * from servico";
        Set<Servico>set = new HashSet<>();
        Servico servico;
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)){
            preparedStatement.execute();
            connection.commit();
            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    int atendimentoId = resultSet.getInt("atendimento_id");
                    String nome = resultSet.getString("nome");
                    servico = new Servico(nome, atendimentoId);
                    servico.setId(id);
                    set.add(servico);
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return set;
    }
    public String atualizar(Servico servico){
        String sql = "update servico nome = ?, atendimento_id = ? where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,servico.getNome());
            preparedStatement.setInt(2,servico.getAtendimentoId());
            preparedStatement.setInt(3,servico.getId());
            preparedStatement.execute();
            connection.commit();
            return "modificados: " + preparedStatement.getUpdateCount();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            try {
                connection.rollback();
            }catch (SQLException ex){
                System.out.println("Falha ao cancelar a execução com o banco");
            }
        }
        return null;
    }
    public String deletar(Servico servico){
        String sql = "delete from servico where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,servico.getId());
            preparedStatement.execute();
            connection.commit();
            return "modificados: " + preparedStatement.getUpdateCount();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            try {
                connection.rollback();
            }catch (SQLException ex){
                System.out.println("Falha ao cancelar a execução com o banco");
            }
        }
        return null;
    }
}
