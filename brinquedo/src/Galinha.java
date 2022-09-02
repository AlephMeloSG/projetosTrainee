public class Galinha extends Animal{

    public Galinha() {
        super.setSom("cocó, cocoricó");
    }

    @Override
    public void emitirSom(){
        System.out.println(super.getSom());
    }
}
