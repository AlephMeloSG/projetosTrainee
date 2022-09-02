public class Gerente extends Funcionario{
    private static int totalGerentes;

    private int senha;

    public Gerente(){
        Gerente.totalGerentes += 1;
    }


    public boolean autenticaSenha(int senha){
        return this.senha == senha;
    }
    public void setSenha(int senha){
        this.senha = senha;
    }

    public double getBoneficacao(){
        System.out.println("Bonificacao do Gerente.");
        return super.getSalario() * 0.2;
    }
    public static int getTotalGerentes() {
        return totalGerentes;
    }
}
