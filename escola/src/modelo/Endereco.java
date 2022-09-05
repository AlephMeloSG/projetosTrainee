package modelo;

public class Endereco {
    private static int totalEndereco;
    private String cidade;
    private String complemento;
    private String cep;
    private String numero;
    private String rua;

    public Endereco(String cidade, String rua, String numero){
        Endereco.totalEndereco += 1;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    public String getCidade(){
        return this.cidade;
    }

    public void setComplemento(String complemento){
        this.complemento = complemento;
    }
    public String getComplemento(){
        return this.complemento;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getCep() {
        return this.cep;
    }

    public void setNumero(String numero){
        this.numero = numero;
    }
    public String getNumero(){
        return this.numero;
    }

    public void setRua(String rua){
        this.rua = rua;
    }
    public String getRua(){
        return this.rua;
    }
    public static int getTotalEndereco(){
        return Endereco.totalEndereco;
    }
}
