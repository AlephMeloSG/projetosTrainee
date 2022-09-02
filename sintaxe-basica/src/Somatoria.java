import java.math.BigDecimal;
import java.util.Scanner;

public class Somatoria {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int numero;

        System.out.print("Somatoria! \nDe 0 até ? ");
        numero = entrada.nextInt();

        int soma = 0;

        for(int contador = 0; contador <= numero; contador += 1){
            soma += contador;
        }
        System.out.println("O resultado final da soma foi: " + soma);

    }
}
