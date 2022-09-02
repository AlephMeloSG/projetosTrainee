public class Tabuada {

    public static void main(String[] args) {

        for (int numero1 = 1; numero1 <= 10; numero1 += 1){
            Function.delay(450);
            if (numero1 < 10){
                System.out.print("Tabuada do 0" + numero1 + ": ");
            } else {
                System.out.print("Tabuada do " + numero1 + ": ");
            }

            for (int numero2 = 1; numero2 <= 10; numero2 += 1) {
                Function.delay(250);
                String resultadoConta;

                if (numero1 * numero2 < 10) {
                    resultadoConta = " " + numero1 * numero2;
                } else {
                    resultadoConta = "" + numero1 * numero2;
                }
                System.out.print(" | " + resultadoConta);


            }
            System.out.println("");
        }
    }
}
