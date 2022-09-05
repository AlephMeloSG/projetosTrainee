package modulo;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private static int codigo;
    private Carrinho carrinho;

    public Cliente(String nome, String cpf){
        codigo ++;
        this.nome = nome;
        this.cpf = cpf;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public String getNome() {
        return nome;
    }

    public static int getCodigo() {
        return codigo;
    }

    public String getCpf() {
        return cpf;
    }
}
