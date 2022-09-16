package prontoAtendimento.dao;

import prontoAtendimento.modulo.Documento;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
public class DocumentoDao {
    Connection connection;
    public DocumentoDao(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Documento documento){
        String sql = "insert into documentos_basicos (cpf, data_de_nascimento) values(?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            preparedStatement.setString(1,documento.getCpf());
            preparedStatement.setString(2, simpleDateFormat.format(documento.getDataNascimento()));
            preparedStatement.execute();
            connection.commit();
            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                resultSet.next();
                int id = resultSet.getInt("id");
                System.out.println("Item inserido! Codigo: "+id);
                documento.setId(id);
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
        String sql = "select * from documentos_basicos";
        Set<Documento>set = new HashSet<>();
        Documento documento;
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)){
            preparedStatement.execute();
            connection.commit();
            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    java.util.Date dataDeNascimento = resultSet.getDate("data_de_nascimento");
                    String cpf = resultSet.getString("cpf");
                    documento = new Documento(dataDeNascimento,cpf);
                    documento.setId(id);
                    set.add(documento);
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            try {
                connection.rollback();
            }catch (SQLException ex){
                System.out.println("Falha ao cancelar a execução com o banco");
            }
        }
        return set;
    }
    public String atualizar(Documento documento){
        String sql = "update documentos_basicos cpf = ?, data_de_nascimento = ? where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,documento.getCpf());
            preparedStatement.setDate(2, (Date) documento.getDataNascimento());
            preparedStatement.setInt(3,documento.getId());
            preparedStatement.execute();
            connection.commit();
            return "modificados: " + preparedStatement.getUpdateCount();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public String deletar(Documento documento){
        String sql = "delete from documentos_basicos where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,documento.getId());
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
