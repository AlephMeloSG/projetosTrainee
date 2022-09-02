public class Gato extends Animal {

    public Gato(){
        super.setSom("miau");
    }

    @Override
    public void emitirSom() {
        System.out.println(super.getSom());
    }
}
