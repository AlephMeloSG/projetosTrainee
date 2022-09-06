package main;

import exceptions.AddProdutoException;
import exceptions.RemoverProdutoException;
import exceptions.SelecaoException;
import modulo.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        int escolha;

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

                while (true) {
                    try {
                        entrada2 = new Scanner(System.in);
                        System.out.print("Numero correspondente:");
                        escolha = entrada2.nextInt();
                        if (escolha <= 0 || escolha >= 5) {
                            throw new SelecaoException("Opção inexistente");
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Valor digitado não é um numero");
                    } catch (SelecaoException e) {
                        System.out.println(e.getMessage());
                    }
                }


                switch (escolha) {
                    case 1: {
                        System.out.println("----------------------------------------------------------");
                        Mercado.listaProdutos();
                        System.out.println("----------------------------------------------------------");
                        while (true) {
                            try {
                                entrada2 = new Scanner(System.in);
                                System.out.print("Codigo Produto: ");
                                int codigo = entrada2.nextInt();
                                System.out.print("Quantia: ");
                                int quantia = entrada2.nextInt();
                                if (quantia <= 0) {
                                    throw new AddProdutoException("Valor não pode ser 0/negativo.");
                                }
                                carrinho.addProduto(codigo, quantia);
                                System.out.println();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Valor digitado não é um numero");
                            } catch (AddProdutoException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("----------------------------------------------------------");
                        carrinho.verCarrinho();
                        System.out.println("----------------------------------------------------------");
                        while (true) {
                            try {
                                entrada2 = new Scanner(System.in);
                                System.out.print("Codigo Produto: ");
                                int codigo = entrada2.nextInt();
                                if (escolha <= 0) {
                                    throw new RemoverProdutoException("Valor não pode ser 0/negativo.");
                                }
                                System.out.print("Quantia: ");
                                int quantia = entrada2.nextInt();
                                carrinho.removerProduto(codigo, quantia);
                                System.out.println();
                                break;
                            } catch (RemoverProdutoException e) {
                                System.out.println(e.getMessage());
                            } catch (InputMismatchException e) {
                                System.out.println("Valor digitado não é um numero");
                            }
                        }
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
                        recibo.mostrarcompra(carrinho, cliente);
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
            if (continuar.equals("n")) {
                break;
            }
        }
    }
}
