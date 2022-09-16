package prontoAtendimento.modulo;

public class Medico {
    private int id;
    private String nome;
    private int documentoId;
    private int crm;
    private int especialidadeId;
    private String especialidade;
    private String dataNascimento;
    private String cpf;

    public Medico(String nome, int documentoId, int crm, int especialidadeId) {
        this.nome = nome;
        this.documentoId = documentoId;
        this.crm = crm;
        this.especialidadeId = especialidadeId;
    }

    public String getNome() {
        return nome;
    }
    public int getDocumentoId() {
        return documentoId;
    }
    public int getCrm() {
        return crm;
    }
    public int getEspecialidadeID() {
        return especialidadeId;
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

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return  "id: " + id + '\n' +
                "nome: " + nome + '\n' +
                "cpf: " + cpf + '\n' +
                "data de nascimento: " + dataNascimento + '\n' +
                "crm: " + crm + '\n' +
                "especialidade: " + especialidade + '\n';
    }
}
