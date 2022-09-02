public class Fluxo {
    public static void main(String[] args) {
        System.out.println("Ini do main");
        metado1();
        System.out.println("Fim do main");
    }

    private static void metado1() {
        System.out.println("Ini do metado1");
        metado2();
        System.out.println("Fim do metado1");
    }

    private static void metado2() {
        System.out.println("Ini do metado2");
        for (int i = 1; i <= 5; i++) {
            try {
                int a = i / 0;
            } catch (ArithmeticException | NullPointerException ex) {
                System.out.println("Erro: " + ex);
            }
            System.out.println(i);
        }
        System.out.println("Fim do metado2");
    }
}
