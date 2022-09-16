package prontoAtendimento.dao;

import prontoAtendimento.modulo.Medicamento;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class MedicamentoDao {
    Connection connection;

    public MedicamentoDao(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Medicamento medicamento){
        String sql = "insert into medicamento (nome, atendimento_id) values(?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,medicamento.getNome());
            preparedStatement.setInt(2,medicamento.getAtendimentoId());
            preparedStatement.execute();
            connection.commit();
            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                resultSet.next();
                int id = resultSet.getInt("id");
                System.out.println("Item inserido! Codigo: "+id);
                medicamento.setId(id);
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
        String sql = "select * from medicamento";
        Set<Medicamento>set = new HashSet<>();
        Medicamento medicamento;
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)){
            preparedStatement.execute();
            connection.commit();
            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    int atendimentoId = resultSet.getInt("atendimento_id");
                    String nome = resultSet.getString("nome");
                    medicamento = new Medicamento(nome, atendimentoId);
                    medicamento.setId(id);
                    set.add(medicamento);
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return set;
    }
    public String atualizar(Medicamento medicamento){
        String sql = "update medicamento nome = ?, atendimento_id = ? where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,medicamento.getNome());
            preparedStatement.setInt(2,medicamento.getAtendimentoId());
            preparedStatement.setInt(3,medicamento.getId());
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
    public String deletar(Medicamento medicamento){
        String sql = "delete from medicamento where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,medicamento.getId());
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
