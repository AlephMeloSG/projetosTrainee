public class Moto extends Veiculo{
    public Moto(String nome){
        super.setNome(nome);
    }
    @Override
    public void liga() {
        System.out.println("Ligando moto " + "\"" + getNome() +  "\"");;
    }
}
