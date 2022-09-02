public class Vaca extends Animal {

    public Vaca() {
        super.setSom("muuuuu");
    }

    @Override
    public void emitirSom(){
        System.out.println(super.getSom());
    }
}
