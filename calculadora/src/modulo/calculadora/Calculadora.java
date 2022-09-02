package modulo.calculadora;

import modulo.Exceptions.CalculadoraException;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Calculadora {
    private double numero1 = 0;
    private double numero2 = 0;

    private int escolha = 0;

    public double calculadora() {
        while (true) {
            while (true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Digite o primeiro numero: ");
                    this.numero1 = scanner.nextDouble();
                    System.out.println("Tipo de calculo:\n" +
                            "1.Mais(+)\n" +
                            "2.Subtracao(-)\n" +
                            "3.Vezes(*)\n" +
                            "4.Divisao(/)");
                    System.out.print("Numero Correspondente: ");
                    escolha = scanner.nextInt();
                    if (escolha > 4) {
                        throw new CalculadoraException("Numero acima do disponivel!");
                    }
                    System.out.print("Digite o Segundo numero: ");
                    this.numero2 = scanner.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Valor digitado não é um número!");
                } catch (CalculadoraException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Resultado da conta foi: " + calculo());
            Scanner scanner = new Scanner(System.in);
            System.out.print("Continuar?(S/N): ");
            String entrada = scanner.nextLine().toLowerCase();
            if (entrada.equals("n")){
                break;
            }
        }
        return calculo();
    }

    private double calculo() {
        if (escolha == 1) {
            return numero1 + numero2;
        } else if (escolha == 2) {
            return numero1 - numero2;

        } else if (escolha == 3) {
            return numero1 * numero2;
        }
        return numero1 / numero2;
    }
}
