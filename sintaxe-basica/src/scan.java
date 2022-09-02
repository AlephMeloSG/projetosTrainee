import java.util.Scanner;

public class scan {
    public static void main(String[] args) {
        String letra;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite uma letra entre A e D: ");
        letra = entrada.nextLine();

        switch (letra){
            case "a":{
                System.out.println("abacaxi");
                break;
            }
            case "b":{
                System.out.println("buscar");
                break;
            }
            case "c":{
                System.out.println("caminhar");
                break;
            }
            case "d":{
                System.out.println("deitar");
                break;
            }
            case "e":{
                System.out.println("emocao");
                break;
            }

        }
    }
}
