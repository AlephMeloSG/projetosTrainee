
public class Administrador extends Funcionario implements Autenticavel{
    private AutenticavelUtil autenticavelUtil;

    public Administrador(){
        this.autenticavelUtil = new AutenticavelUtil();
    }

	@Override
	public double getBonificacao() {
		return 50;
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
