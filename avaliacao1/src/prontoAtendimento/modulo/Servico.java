package prontoAtendimento.modulo;

public class Servico {
    private int id;
    private String nome;
    private int atendimentoId;

    public Servico(String nome, int atendimento_id) {
        this.nome = nome;
        this.atendimentoId = atendimento_id;
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
