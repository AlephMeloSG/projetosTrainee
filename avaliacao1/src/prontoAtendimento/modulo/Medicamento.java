package prontoAtendimento.modulo;

public class Medicamento {
    private int id;
    private String nome;
    private int atendimentoId;

    public Medicamento(String nome, int atendimentoId) {
        this.nome = nome;
        this.atendimentoId = atendimentoId;
    }

    public String getNome() {
        return nome;
    }

    public int getAtendimentoId() {
        return atendimentoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
