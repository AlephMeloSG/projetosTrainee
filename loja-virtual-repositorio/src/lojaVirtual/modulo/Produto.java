package lojaVirtual.modulo;

public class Produto {
    private Integer id;
    private String nome;
    private String  descricao;

    public Produto(Integer id, String nome, String descricao){
        if (descricao != null) {
            this.descricao = descricao;
        }
        this.id = id;
        this.nome = nome;
    }


    @Override
    public String toString() {
        return  "id: " + id + '\n' +
                "nome: " + nome + '\n' +
                "descrição: " + descricao + '\n';
    }
}
