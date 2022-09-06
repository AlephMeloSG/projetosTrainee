package main;

import modulo.*;
import functions.*;

public class Programa {
    public static void main(String[] args) {
        int escolha;

        Produto produto = new Produto("Carne", 9.50);
        Produto produto2 = new Produto("Coco", 6.25);
        Produto produto3 = new Produto("Arroz", 14.10);
        Produto produto4 = new Produto("Feijao", 12.55);
        Produto produto5 = new Produto("Tomate", 5.32);
        Produto produto6 = new Produto("Lingüiça de Frango", 13.20);
        Produto produto7 = new Produto("Batata", 7.17);
        Produto produto8 = new Produto("Alface", 9.55);
        Produto produto9 = new Produto("Melão", 3.32);
        Produto produto10 = new Produto("Mamão", 4.32);

        while (true) {
            Cliente cliente;

            String nome = Funcoes.inputStr("Nome/Codigo:");
            if (nome.equals("m64")) {
                cliente = new Cliente("Aleph Costa Melo", "111.111.111-32");
            } else {
                String cpf = Funcoes.inputStr("CPF: ");
                cliente = new Cliente(nome, cpf);
            }
            System.out.println();
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            Carrinho carrinho = new Carrinho(cliente);

            while (true) {
                System.out.println();
                System.out.println("Mercadinho são paulo");
                Funcoes.printTimes("-",60);
                System.out.println("1.Adicionar Produto");
                System.out.println("2.Remover Produto");
                System.out.println("3.Ver Carrinho");
                System.out.println("4.Finalizar Compra");
                ;
                escolha = Funcoes.inputInt("Numero correspondente:", 1, 4);


                switch (escolha) {
                    case 1: {
                        Funcoes.printTimes("-",60);
                        Mercado.listaProdutosString();
                        Funcoes.printTimes("-",60);

                        int codigo = Funcoes.inputInt("Codigo Produto: ",1,Produto.getUltimoCodigo());
                        int quantia = Funcoes.inputInt("Quantia: ", 1);
                        carrinho.addProduto(codigo, quantia);
                        System.out.println();
                        break;
                    }
                    case 2: {
                        Funcoes.printTimes("-",60);
                        carrinho.verCarrinho();
                        Funcoes.printTimes("-",60);
                        int codigo = Funcoes.inputInt("Codigo Produto: ",1,Produto.getUltimoCodigo());
                        int quantia = Funcoes.inputInt("Quantia: ", 1);
                        carrinho.removerProduto(codigo, quantia);
                        System.out.println();
                        break;
                    }
                    case 3: {
                        Funcoes.printTimes("-",60);
                        carrinho.verCarrinho();
                        Funcoes.printTimes("-",60);
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
                continuar = Funcoes.inputStr("Continuar? (S/N): ").toLowerCase();
            }
            if (continuar.equals("n")) {
                break;
            }
        }
    }
}
