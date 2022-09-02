
public class Cliente implements Autenticavel {

	private AutenticavelUtil autenticavelUtil;

    public Cliente(){
        this.autenticavelUtil = new AutenticavelUtil();
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
