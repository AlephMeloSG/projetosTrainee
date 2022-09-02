public class Carro extends Veiculo{
    public Carro(String nome){
        super.setNome(nome);
    }
    @Override
    public void liga() {
        System.out.println("Ligando carro " + "\"" + getNome() +  "\"");;
    }
}
