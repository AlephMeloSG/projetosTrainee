package lojaVirtual.modulo;

import java.util.Objects;

public class Produto {
    private Integer id;
    private String nome;
    private String  descricao;

    public Produto(String nome, String descricao){
        if (descricao != null) {
            this.descricao = descricao.toLowerCase();
        }
        this.nome = nome.toLowerCase();
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao.toLowerCase();
    }

    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return  "id: " + id + '\n' +
                "nome: " + nome + '\n' +
                "descrição: " + descricao + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome) && Objects.equals(descricao, produto.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }
}
