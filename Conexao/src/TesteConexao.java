import java.io.IOException;

public class TesteConexao {
    public static void main(String[] args) {
        try(Conexao conexao = new Conexao()){
            conexao.leDados();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}