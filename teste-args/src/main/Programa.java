package main;

public class Programa {
    public static void main(String[] args) {
        try {
            if (args[0].equals("p")) {
                System.out.println("parametros");
            } else {
                System.out.println("programa normal");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
