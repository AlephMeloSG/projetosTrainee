public class Fluxo2 {
    public static void main(String[] args) {
        System.out.println("Ini do main");
        try {
            metado1();
        } catch (ArithmeticException e){
            System.out.println(e);
        }

        System.out.println("Fim do main");
    }

    private static void metado1() {
        System.out.println("Ini do metado1");
        metado2();
        System.out.println("Fim do metado1");
    }

    private static void metado2() {
        System.out.println("Ini do metado2");
        throw new ArithmeticException("falha");
        //System.out.println("Fim do metado2");
    }
}
