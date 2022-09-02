import java.util.Scanner;

public class scanners {
    public static void main(String[] args) {

        while (true) {
            try {
                Scanner entrada = new Scanner(System.in);

                String nome;
                int idade;

                System.out.println("Digite seu nome:");
                nome = entrada.nextLine();
                System.out.println("Digite sua idade:");
                idade = entrada.nextInt();
                System.out.println("Bem vindo " + nome + ". Sua idade é " + idade + ".");
                break;
            } catch (Exception e) {
                System.out.println("Idade Invalida.");
            }
        }

    }
}
