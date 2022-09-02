public class SistemaInterno {
    int senha = 2222;

    public boolean autenticaSenha(Gerente gerente){
        if (gerente.autenticaSenha(this.senha) == true){
            System.out.println("Acesso permitido.");
            return true;
        }
        System.out.println("Senha invalida.");
        return false;
    }
}
