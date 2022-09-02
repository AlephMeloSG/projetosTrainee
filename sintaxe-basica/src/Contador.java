public class Contador {
    public static void main(String[] args) {
        int count = 0;

        while (count <= 10){
            System.out.println("While: " + count);
            count += 1;
        }
        for (int x = 0; x <= 10; x += 1){
            System.out.println("For: " + x);
        }
    }
}
