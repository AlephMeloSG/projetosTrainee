import calculadorIMC.IMC;
import model.AreaQuadrada;
import model.MinhaIdade;
import modulo.calculadora.Calculadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CaixaFerramentaMain {
    public static void main(String[] args) {
        int escolha = 0;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ferramentas:\n" +
                        "1.Calculadora\n" +
                        "2.IMC\n" +
                        "3.MinhaIdade\n" +
                        "4.AreaQuadrada\n" +
                        "5.Sair\n");

                System.out.print("Digite o número correspondente: ");
                escolha = scanner.nextInt();

                switch (escolha) {
                    case 1: {
                        Calculadora calculadora = new Calculadora();
                        calculadora.calculadora();
                        break;
                    }
                    case 2: {
                        IMC imc = new IMC();
                        imc.abrirIMC();
                        break;
                    }
                    case 3: {
                        MinhaIdade minhaIdade = new MinhaIdade();
                        minhaIdade.calculaIdade();
                        break;
                    }
                    case 4: {
                        AreaQuadrada areaQuadrada = new AreaQuadrada();
                        areaQuadrada.calculaArea();
                        break;
                    }
                    case 5: {
                        break;
                    }
                    default: {
                        System.out.println("valor acima do disponivel");
                        break;
                    }
                }
                if (escolha==5)
                        break;
            } catch (InputMismatchException e) {
                System.out.println("Valor digitado não é um numero!\n");
            }
        }
    }

}

