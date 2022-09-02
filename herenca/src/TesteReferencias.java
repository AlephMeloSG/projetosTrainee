public class TesteReferencias {
    public static void main(String[] args) {
        Gerente gerente1 = new Gerente();
        gerente1.setNome("TRIBUTO BBA");
        gerente1.setCpf("067399976-64");
        gerente1.setSalario(3000.0);

        Editor funcionario1 = new Editor();
        funcionario1.setNome("Aleph");
        funcionario1.setCpf("067399976-64");
        funcionario1.setSalario(2500.0);

        Editor editor = new Editor();
        editor.setNome("Aleph");
        editor.setCpf("067399976-64");
        editor.setSalario(1500.0);

        Faxineiro faxineiro = new Faxineiro();
        faxineiro.setNome("Guily");
        faxineiro.setCpf("5345687435-49");
        faxineiro.setSalario(2500.0);


        ControleBonificacao controle = new ControleBonificacao();
        controle.registra(funcionario1);
        controle.registra(gerente1);
        controle.registra(editor);
        controle.registra(faxineiro);
    }
}
