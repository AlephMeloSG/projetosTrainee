package br.com.sgsistemas.sorteio.main;

import model.Sorteio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sorteador {
    public static void main(String[] args) {
        int numeroInicial = 0;
        int numeroFinal = 0;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite um numero de inicio: ");
                numeroInicial = scanner.nextInt();
                System.out.print("Digite um numero do final: ");
                numeroFinal = scanner.nextInt();

                Sorteio sorteio = new Sorteio();
                int resultado = sorteio.sortear(numeroInicial, numeroFinal);
                System.out.println("O número sorteado foi:" + resultado);

            } catch (InputMismatchException e) {
                System.out.println("Valor digitado não é um numero.");
            } catch (IllegalArgumentException e) {
                System.out.println("O numero final não pode ser menor que o inicial: " + numeroInicial + " Final: " + numeroFinal);
            }
            Scanner scanner = new Scanner(System.in);
            System.out.print("Deseja Continuar? (S/N): ");
            String escolha = scanner.next().toLowerCase();
            if(escolha.equals("n")){
                break;
            }
            System.out.println();
        }

    }
}
