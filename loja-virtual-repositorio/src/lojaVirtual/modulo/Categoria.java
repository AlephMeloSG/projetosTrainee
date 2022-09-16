package lojaVirtual.modulo;

public class Categoria {
    int id;
    String nome;

    public Categoria(String nome) {
        this.nome = nome.toLowerCase();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
}
