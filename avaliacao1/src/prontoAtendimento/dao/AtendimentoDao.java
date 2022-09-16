package prontoAtendimento.dao;

import prontoAtendimento.modulo.Atendimento;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

public class AtendimentoDao {
    Connection connection;

    public AtendimentoDao(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Atendimento atendimento){
        String sql = "insert into atendimentos (data, paciente_id, medico_id) values(?,?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            preparedStatement.setString(1, simpleDateFormat.format(atendimento.getData()));
            preparedStatement.setInt(2,atendimento.getPacienteId());
            preparedStatement.setInt(3,atendimento.getMedicoId());
            preparedStatement.execute();
            connection.commit();
            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                resultSet.next();
                int id = resultSet.getInt("id");
                System.out.println("Item inserido! Codigo: "+id);
                atendimento.setId(id);
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
        String sql = "select a.*, p.nome, m.nome, md.nome, s.nome from atendimentos a " +
                "inner join paciente p on (p.id = a.paciente_id)" +
                "inner join medico m on (m.id = a.medico_id)" +
                "inner join medicamento md on (md.atendimento_id = a.id)" +
                "inner join servicos s on (s.atendimento_id = a.id)";
        Set<Atendimento>set = new HashSet<>();
        Atendimento atendimento;
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)){
            preparedStatement.execute();
            connection.commit();
            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next()){
                    String data = resultSet.getString("a.data");
                    int pacienteId = resultSet.getInt("a.paciente_id");
                    int medicoId = resultSet.getInt("a.medico_id");
                    int id = resultSet.getInt("a.id");
                    atendimento = new Atendimento(data, pacienteId,medicoId);
                    atendimento.setId(id);
                    atendimento.setPacienteNome(resultSet.getString("p.nome"));
                    atendimento.setMedicoNome(resultSet.getString("m.nome"));
                    atendimento.addMedicamentos(resultSet.getString("md.nome"));
                    atendimento.addServicos(resultSet.getString("s.nome"));
                    set.add(atendimento);
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return set;
    }
    public String atualizar(Atendimento atendimento){
        String sql = "update atendimentos data = ?, paciente_id = ?, medico_id = ? where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setDate(1, (Date) atendimento.getData());
            preparedStatement.setInt(2,atendimento.getPacienteId());
            preparedStatement.setInt(3,atendimento.getMedicoId());
            preparedStatement.setInt(6,atendimento.getId());
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
    public String deletar(Atendimento atendimento){
        String sql = "delete from atendimentos where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,atendimento.getId());
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
