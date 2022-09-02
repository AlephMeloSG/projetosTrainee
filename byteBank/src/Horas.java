import java.util.Date;

public class Horas {
    public static void main(String[] args) {

        Date data = new Date();
        long tempo = data.getTime(); // milisegundos
        System.out.println((((tempo/1000)))); // segundos
        System.out.println((tempo/1000)/60); // minutos

    }
}
