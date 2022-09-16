package prontoAtendimento.dao;

import prontoAtendimento.modulo.Especialidades;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EspecialidadesDao {
    Connection connection;

    public EspecialidadesDao(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Especialidades especialidade) {
        String sql = "insert into especialidades (nome) values(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, especialidade.getNome());
            preparedStatement.execute();
            connection.commit();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                resultSet.next();
                int id = resultSet.getInt("id");
                System.out.println("Item inserido! Codigo: " + id);
                especialidade.setId(id);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
                ArrayList<Especialidades> jaExiste = new ArrayList<>();
                jaExiste.addAll(buscar());
                for (Especialidades especialidades : jaExiste) {
                    if(especialidades.getNome().equals(especialidade.getNome())){
                        especialidade.setId(especialidades.getId());
                    }
                }
            } catch (SQLException ex) {
                System.out.println("Falha ao cancelar a execução com o banco");
            }
        }
    }

    public Set<Especialidades> buscar() {
        String sql = "select * from especialidades";
        Set<Especialidades> set = new HashSet<>();
        Especialidades especialidade;
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.execute();
            connection.commit();
            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    especialidade = new Especialidades(nome);
                    especialidade.setId(id);
                    set.add(especialidade);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return set;
    }

    public String atualizar(Especialidades especialidade) {
        String sql = "update especialidades nome = ? where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, especialidade.getNome());
            preparedStatement.setInt(3, especialidade.getId());
            preparedStatement.execute();
            connection.commit();
            return "modificados: " + preparedStatement.getUpdateCount();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println("Falha ao cancelar a execução com o banco");
            }
        }
        return null;
    }

    public String deletar(Especialidades especialidade) {
        String sql = "delete from especialidades where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, especialidade.getId());
            preparedStatement.execute();
            connection.commit();
            return "modificados: " + preparedStatement.getUpdateCount();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println("Falha ao cancelar a execução com o banco");
            }
        }
        return null;
    }
}
