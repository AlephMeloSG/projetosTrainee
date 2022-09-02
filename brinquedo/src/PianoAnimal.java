import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PianoAnimal {

    public void ligar() {
        Scanner scanner = new Scanner(System.in);
        int numero = 0;
        while (numero != 5) {
            System.out.println();
            System.out.println("Pressione o número do animal para ouvir seu som e pressione enter:");
            System.out.println("1-Gato");
            System.out.println("2-Cachorro");
            System.out.println("3-Vaca");
            System.out.println("4-Galinha");
            System.out.println("5-Desligar Piano");
            System.out.println();
            try {
                numero = scanner.nextInt();
                switch (numero) {
                    case 1: {
                        Gato gato = new Gato();
                        this.tocar(gato);
                        break;
                    }
                    case 2: {
                        Cachorro cachorro = new Cachorro();
                        this.tocar(cachorro);
                        break;
                    }
                    case 3: {
                        Vaca vaca = new Vaca();
                        this.tocar(vaca);
                        break;
                    }
                    case 4: {
                        Galinha galinha = new Galinha();
                        this.tocar(galinha);
                        break;
                    }
                    case 5: {
                        this.desligar();
                        break;
                    } default:{
                        throw new AnimalExcecao("Animal Inexistente");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("O valor digitado não é um numero.\n" + e);
                scanner = new Scanner(System.in);
            } catch (AnimalExcecao e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public void desligar() {
        System.out.println("Tchau-tchau!!!");
    }

    public void tocar(Animal animal) {
        System.out.println("*****");
        animal.emitirSom();
        System.out.println("*****");
    }

}

