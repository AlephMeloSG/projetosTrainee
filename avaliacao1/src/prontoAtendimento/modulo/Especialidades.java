package prontoAtendimento.modulo;

public class Especialidades {
    private int id;
    private String nome;

    public Especialidades(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
