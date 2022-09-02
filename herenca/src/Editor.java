public class Editor extends Funcionario{
    private static int totalEditor;

    public Editor(){
        totalEditor += 1;
    }

    public double getBoneficacao(){
        System.out.println("Bonificacao do Editor.");
        return super.getSalario() * 0.3;
    }
    public static int getTotalEditor() {
        return totalEditor;
    }
}
