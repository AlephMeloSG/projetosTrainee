//Gerente eh um Funcionario, Gerente herda da class Funcionario, assina o contrato Autenticavel, eh um Autenticavel
public class Gerente extends Funcionario implements Autenticavel {
    private AutenticavelUtil autenticavelUtil;

    public Gerente(){
        this.autenticavelUtil = new AutenticavelUtil();
    }

	public double getBonificacao() {
		System.out.println("Chamando o método de bonificacao do GERENTE");
		return super.getSalario();
	}

    @Override
    public void setSenha(int senha){
        this.autenticavelUtil.setSenha(senha);
    }

    @Override
    public boolean autentica(int senha) {
        return this.autenticavelUtil.autentica(senha);
    }

}
