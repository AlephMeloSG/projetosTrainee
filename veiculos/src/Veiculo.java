public abstract class Veiculo {
    private String nome;



    public void liga(){
        System.out.println("Ligando veiculo");
    }
    public void desliga(){
        System.out.println("Desligando veiculo.");
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
