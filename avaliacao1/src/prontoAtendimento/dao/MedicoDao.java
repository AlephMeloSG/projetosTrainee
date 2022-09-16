package prontoAtendimento.dao;

import prontoAtendimento.modulo.Medico;

import javax.swing.*;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class MedicoDao {
    Connection connection;

    public MedicoDao(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Medico medico){
        String sql = "insert into medico (nome,documento_id,crm,especialidade_id) values(?,?,?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,medico.getNome());
            preparedStatement.setInt(2,medico.getDocumentoId());
            preparedStatement.setInt(3,medico.getCrm());
            preparedStatement.setInt(4,medico.getEspecialidadeID());
            preparedStatement.execute();
            connection.commit();
            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                resultSet.next();
                int id = resultSet.getInt("id");
                System.out.println("Item inserido! Codigo: "+id);
                medico.setId(id);
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
        String sql = "select m.*, d.cpf, d.data_de_nascimento, e.nome from medico m " +
                "inner join documentos_basicos d on (d.id = m.documento_id) " +
                "inner join especialidades e on (e.id = m.especialidade_id)";
        Set<Medico>set = new HashSet<>();
        Medico medico;
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)){
            preparedStatement.execute();
            connection.commit();
            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("m.nome");
                    int documentoId = resultSet.getInt("documento_id");
                    int crm = resultSet.getInt("crm");
                    int especialidadeId = resultSet.getInt("especialidade_id");
                    medico = new Medico(nome, documentoId,crm,especialidadeId);
                    medico.setId(id);
                    medico.setCpf(resultSet.getString("cpf"));
                    medico.setDataNascimento(resultSet.getString("data_de_nascimento"));
                    medico.setEspecialidade(resultSet.getString("e.nome"));
                    set.add(medico);
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return set;
    }
    public String atualizar(Medico medico){
        String sql = "update medico nome = ?, documento_id = ?, crm = ?, especialidade_id = ? where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,medico.getNome());
            preparedStatement.setInt(2,medico.getDocumentoId());
            preparedStatement.setInt(3,medico.getCrm());
            preparedStatement.setInt(4,medico.getEspecialidadeID());
            preparedStatement.setInt(5,medico.getId());
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
    public String deletar(Medico medico){
        String sql = "delete from medico where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,medico.getId());
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
