public class ControleBonificacao {
    private double somaControleBonificacao;

    public double totalBonificacaoFuncionarios(){
        return somaControleBonificacao;
    }
    public void registra(Funcionario funcionario) {
        somaControleBonificacao += funcionario.getBoneficacao();
    }
}
