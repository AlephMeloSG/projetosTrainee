public class Escola {
    private static int totalEscolas;
    private String nomeEscola;
    private String diretor;
    private String horarioEntrada;
    private String horarioSaida;
    private Endereco endereco;


    public Escola(String nomeEscola, Endereco endereco){
        Escola.totalEscolas += 1;
        this.nomeEscola = nomeEscola;
        this.endereco = endereco;
    }


    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public String getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public static int getTotalEscolas(){
        return Escola.totalEscolas;
    }
}
