public class Pessoa {

    String nome;
    String endereco;
    String complemento;
    String numero;
    String telefone;
    short idade;
    short idade2;
    double Peso;
    String dataNascimento;

    public String Basico() {
        return "Pessoa{" +
                "nome:'" + nome + 
                ", endereco:'" + endereco + 
                ", numero:'" + numero + 
                '}';
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", numero='" + numero + '\'' +
                ", telefone='" + telefone + '\'' +
                ", idade=" + idade +
                ", idade2=" + idade2 +
                ", Peso=" + Peso +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
    }
    public String FullInfo() {
        return
                "nome:'" + nome + 
                ", endereco:'" + endereco + 
                ", complemento:'" + complemento + 
                ", numero:'" + numero + 
                ", telefone:'" + telefone + 
                ", idade:" + idade +
                ", Peso:" + Peso +
                ", dataNascimento:'" + dataNascimento;
    }
}
