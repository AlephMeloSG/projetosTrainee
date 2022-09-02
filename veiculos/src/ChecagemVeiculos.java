public class ChecagemVeiculos {
    public static void main(String[] args) {
        Carro carro1 = new Carro("Mustang");
        System.out.println(carro1.getNome());
        carro1.liga();

        Moto moto1 = new Moto("Bis");
        System.out.println(moto1.getNome());
        moto1.liga();
    }
}
