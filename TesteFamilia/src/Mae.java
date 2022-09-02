/*
extends - herda da classe mae ou pai
final - não permite as classes herdam a classe/atributos/metados
implements - contrato.
 */

public class Mae {
    private String nome;
    private final String receitaFamilia =
            "2 colheres (sopa) de manteiga\n" +
            "2 xícaras (chá) de açúcar\n" +
            "4 ovos\n" +
            "1 xícara (chá) de leite\n" +
            "2 xícaras (chá) de fubá\n" +
            "1/2 xícara (chá) de farinha de trigo\n" +
            "1 colher (sopa) de fermento em pó\n" +
            "Margarina e farinha de trigo para untar";


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getReceitaFamilia() {
        return receitaFamilia;
    }

    public final int calculoDeComissao(){
        return 10;
    }

}
