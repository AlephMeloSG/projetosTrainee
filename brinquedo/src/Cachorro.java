public class Cachorro extends Animal {

    public Cachorro() {
        super.setSom("Au-Au");
    }

    @Override
    public void emitirSom(){
        System.out.println(super.getSom());
    }
}
