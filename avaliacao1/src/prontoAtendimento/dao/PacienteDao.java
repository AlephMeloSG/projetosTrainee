package prontoAtendimento.dao;

import prontoAtendimento.modulo.Paciente;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class PacienteDao {
    Connection connection;

    public PacienteDao(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Paciente paciente){
        String sql = "insert into paciente (nome, documento_id, nome_da_mae, numero_da_carteirinha, cor_da_pulseira) values(?,?,?,?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,paciente.getNome());
            preparedStatement.setInt(2,paciente.getDocumentoId());
            preparedStatement.setString(3,paciente.getNomeDaMae());
            preparedStatement.setInt(4,paciente.getNumeroDaCarterinha());
            preparedStatement.setString(5,paciente.getCorPulseira());
            preparedStatement.execute();
            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                resultSet.next();
                int id = resultSet.getInt("id");
                System.out.println("Item inserido! Codigo: "+id);
                paciente.setId(id);
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public Paciente buscar(Integer id){
        String sql = "select * from paciente where id = ?";
        Paciente paciente = null;
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            connection.commit();
            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next()){
                    String nome = resultSet.getString("nome");
                    int documentoId = resultSet.getInt("documento_id");
                    int numeroDaCarteirinha = resultSet.getInt("numero_da_carteirinha");
                    String corDaPulseira = resultSet.getString("cor_da_pulseira");
                    String nomeDaMae = resultSet.getString("nome_da_mae");
                    paciente = new Paciente(nome, documentoId,nomeDaMae,numeroDaCarteirinha,corDaPulseira);
                    paciente.setId(id);
                }
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
        return paciente;
    }
    public Set<Paciente> buscar(){
        String sql = "select p.*, d.cpf, d.data_de_nascimento from paciente p " +
                "inner join documentos_basicos d on (p.documento_id = d.id)";
        Set<Paciente>set = new HashSet<>();
        Paciente paciente;
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)){
            preparedStatement.execute();
            connection.commit();
            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    int documentoId = resultSet.getInt("documento_id");
                    int numeroDaCarteirinha = resultSet.getInt("numero_da_carteirinha");
                    String corDaPulseira = resultSet.getString("cor_da_pulseira");
                    String nomeDaMae = resultSet.getString("nome_da_mae");
                    String nome = resultSet.getString("nome");
                    paciente = new Paciente(nome, documentoId,nomeDaMae,numeroDaCarteirinha,corDaPulseira);
                    paciente.setId(id);
                    paciente.setCpf(resultSet.getString("cpf"));
                    paciente.setDataNascimento(resultSet.getString("data_de_nascimento"));
                    set.add(paciente);
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return set;
    }
    public String atualizar(Paciente paciente){
        String sql = "update paciente nome = ?, nome_da_mae = ?, numero_da_carteirinha = ?, cor_da_pulseira = ? where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,paciente.getNome());
            preparedStatement.setString(2,paciente.getNomeDaMae());
            preparedStatement.setInt(3,paciente.getNumeroDaCarterinha());
            preparedStatement.setString(4,paciente.getCorPulseira());
            preparedStatement.setInt(5,paciente.getId());
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
    public String deletar(Paciente paciente){
        String sql = "delete from Paciente where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,paciente.getId());
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
