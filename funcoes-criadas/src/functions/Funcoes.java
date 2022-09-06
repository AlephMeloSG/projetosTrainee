package functions;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Funcoes {
    public static String paperRockScissors(String player1, String player2) {
        String resultado = "empate";
        player1 = player1.toLowerCase();
        player2 = player2.toLowerCase();

        if (player1.equals("pedra") && player2.equals("papel")) {
            resultado = "Jogador2 venceu";
        } else if (player1.equals("papel") && player2.equals("pedra")) {
            resultado = "Jogador1 venceu";
        } else if (player1.equals("pedra") && player2.equals("tesoura")) {
            resultado = "Jogador1 venceu";
        } else if (player1.equals("tesoura") && player2.equals("pedra")) {
            resultado = "Jogador2 venceu";
        } else if (player1.equals("tesoura") && player2.equals("papel")) {
            resultado = "Jogador1 venceu";
        } else if (player1.equals("papel") && player2.equals("tesoura")) {
            resultado = "Jogador2 venceu";
        }
        return resultado;
    }

    public static void delay(int milliseconds) {
        Date start = new Date();
        long startLong = start.getTime();

        while (true) {
            Date finish = new Date();
            long finishLong = finish.getTime();
            if (finishLong - startLong > milliseconds) {
                break;
            }
        }
    }

    public static String mes(int numeroMes) {
        String mesPalavra;
        switch (numeroMes) {
            case 1: {
                mesPalavra = "Janeiro";
                break;
            }
            case 2: {
                mesPalavra = "Fevereiro";
                break;
            }
            case 3: {
                mesPalavra = "Março";
                break;
            }
            case 4: {
                mesPalavra = "Abril";
                break;
            }
            case 5: {
                mesPalavra = "Maio";
                break;
            }
            case 6: {
                mesPalavra = "Junho";
                break;
            }
            case 7: {
                mesPalavra = "Julho";
                break;
            }
            case 8: {
                mesPalavra = "Agosto";
                break;
            }
            case 9: {
                mesPalavra = "Setembro";
                break;
            }
            case 10: {
                mesPalavra = "Outubro";
                break;
            }
            case 11: {
                mesPalavra = "Novembro";
                break;
            }
            case 12: {
                mesPalavra = "Dezembro";
                break;
            }
            default:
                mesPalavra = "Desconhecido..";
        }
        return mesPalavra;
    }

    public static int inputInt(String texto) {
        int valor;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(texto);
                valor = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor não é um numero!");
            }
        }

        return valor;
    }
    public static int inputInt(String texto, int min) {
        int valor;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(texto);
                valor = scanner.nextInt();
                if (valor < min) {
                    throw new RuntimeException("Valor abaixo do permitido! mínimo: " + min);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor não é um numero!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        return valor;
    }
    public static int inputInt(String texto, int min, int max) {
        int valor;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(texto);
                valor = scanner.nextInt();
                if (valor < min || valor > max) {
                    throw new RuntimeException("Valor não permitido! mínimo: " + min + " máximo: " + max);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor não é um numero!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        return valor;
    }

    public static double inputDouble(String texto) {
        double valor;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(texto);
                valor = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor não é um numero!");
            }
        }

        return valor;
    }
    public static double inputDouble(String texto, double min) {
        double valor;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(texto);
                valor = scanner.nextDouble();
                if (valor < min) {
                    throw new RuntimeException("Valor abaixo do permitido! mínimo: " + min);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor não é um numero!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        return valor;
    }
    public static double inputDouble(String texto, double min, double max) {
        double valor;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(texto);
                valor = scanner.nextDouble();
                if (valor < min || valor > max) {
                    throw new RuntimeException("Valor não permitido! mínimo: " + min + "máximo: " + max);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor não é um numero!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        return valor;
    }

    public static String inputStr(String texto) {
        System.out.print(texto);
        Scanner scanner = new Scanner(System.in);
        String valor;
        valor = scanner.nextLine();
        return valor;
    }
    public static String inputStr(String texto, String contains) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String valor;
            System.out.print(texto);
            valor = scanner.nextLine();
            if (valor.contains(contains)){
                return valor;
            }
        }
    }

}
