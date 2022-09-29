package br.com.sgsistemas.trainee.buscaCep.modelo;

public class Dominio {
    String cep;
    String logradouro;
    String complemento;
    String bairro;
    String localidade;
    String uf;
    String ibge;
    String gia;
    String ddd;
    String siafi;


    public Dominio(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, String ibge, String gia, String ddd, String siafi) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ibge = ibge;
        this.gia = gia;
        this.ddd = ddd;
        this.siafi = siafi;
    }

    @Override
    public String toString() {
        return  "cep: " + cep + '\n' +
                "logradouro: " + logradouro + '\n' +
                "complemento: " + complemento + '\n' +
                "bairro: " + bairro + '\n' +
                "localidade: " + localidade + '\n' +
                "uf: " + uf + '\n' +
                "ibge: " + ibge + '\n' +
                "gia: " + gia + '\n' +
                "ddd: " + ddd + '\n' +
                "siafi: " + siafi + '\n';
    }
}
