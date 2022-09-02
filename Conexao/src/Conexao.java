import java.io.Closeable;
import java.io.IOException;

public class Conexao implements Closeable {
    public Conexao(){
        System.out.println("Abrindo conexao");
    }
    public void leDados(){
        System.out.println("Recebendo dados");
        throw new ConexaoException("Falha na recebimento dos dados.");
    }

    @Override
    public void close() throws IOException {
        System.out.println("Fechando conexao");
    }
}
