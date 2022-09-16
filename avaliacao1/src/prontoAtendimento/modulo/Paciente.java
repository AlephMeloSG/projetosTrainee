package prontoAtendimento.modulo;

public class Paciente {
    private int id;
    private String nome;
    private int documentoId;
    private String nomeDaMae;
    private int numeroDaCarterinha;
    private String corPulseira;
    private String dataNascimento;
    private String cpf;

    public Paciente(String nome, int documentoId, String nomeDaMae, int numeroDaCarterinha, String corPulseira) {
        this.nome = nome;
        this.documentoId = documentoId;
        this.nomeDaMae = nomeDaMae;
        this.numeroDaCarterinha = numeroDaCarterinha;
        this.corPulseira = corPulseira;
    }

    public String getNome() {
        return nome;
    }
    public int getDocumentoId() {
        return documentoId;
    }
    public String getNomeDaMae() {
        return nomeDaMae;
    }
    public int getNumeroDaCarterinha() {
        return numeroDaCarterinha;
    }
    public String getCorPulseira() {
        return corPulseira;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return  "id: " + id + '\n' +
                "nome: " + nome + '\n' +
                "cpf: " + cpf + '\n' +
                "data de nascimento: " + dataNascimento + '\n' +
                "nome Da Mae: " + nomeDaMae + '\n' +
                "numero Da Carterinha: " + numeroDaCarterinha + '\n' +
                "corPulseira: " + corPulseira + '\n';
    }
}
