package main;

import modulo.*;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        int escolha;
        Integer

        Produto produto = new Produto("Carne", 9.50);
        Produto produto2 = new Produto("Arroz", 14.10);
        Produto produto3 = new Produto("Feijao", 12.55);
        Produto produto4 = new Produto("Tomate", 4.32);

        while (true) {
            Scanner entrada = new Scanner(System.in);
            Cliente cliente;

            System.out.print("Nome/Codigo:");
            String nome = entrada.nextLine();
            if (nome.equals("m64")) {
                cliente = new Cliente("Aleph Costa Melo", "111.111.111-32");
            } else {
                System.out.print("CPF:");
                String cpf = entrada.nextLine();
                cliente = new Cliente(nome, cpf);
            }
            System.out.println();
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            Carrinho carrinho = new Carrinho(cliente);

            while (true) {
                Scanner entrada2 = new Scanner(System.in);
                System.out.println();
                System.out.println("Mercadinho são paulo");
                System.out.println("----------------------------------------------------------");
                System.out.println("1.Adicionar Produto");
                System.out.println("2.Remover Produto");
                System.out.println("3.Ver Carrinho");
                System.out.println("4.Finalizar Compra");
                ;

                System.out.print("Numero correspondente:");
                escolha = entrada2.nextInt();

                switch (escolha) {
                    case 1: {
                        System.out.println("----------------------------------------------------------");
                        Mercado.listaProdutos();
                        System.out.println("----------------------------------------------------------");
                        System.out.print("Codigo Produto: ");
                        int codigo = entrada2.nextInt();
                        System.out.print("Quantia: ");
                        int quantia = entrada2.nextInt();
                        carrinho.addProduto(codigo, quantia);
                        System.out.println();
                        break;
                    }
                    case 2: {
                        System.out.println("----------------------------------------------------------");
                        carrinho.verCarrinho();
                        System.out.println("----------------------------------------------------------");
                        System.out.print("Codigo Produto: ");
                        int codigo = entrada2.nextInt();
                        System.out.print("Quantia: ");
                        int quantia = entrada2.nextInt();
                        carrinho.removerProduto(codigo, quantia);
                        System.out.println();
                        break;
                    }
                    case 3: {
                        System.out.println("----------------------------------------------------------");
                        carrinho.verCarrinho();
                        System.out.println("----------------------------------------------------------");
                        break;
                    }
                    case 4: {
                        Recibo recibo = new Recibo();
                        recibo.mostrarcompra(carrinho,cliente);
                        break;
                    }
                }
                if (escolha == 4) {
                    break;
                }
            }
            String continuar = "s";
            if (escolha == 4) {
                System.out.print("Continuar? (S/N): ");
                continuar = entrada.nextLine().toLowerCase();
            }
            if (continuar.equals("n")){
                break;
            }
        }
    }
}
