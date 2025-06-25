package com.agrolance.view;

import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("=========== MENU PRINCIPAL - AGROLANCE ===========");
            System.out.println("1. Cadastro de Clientes");
            System.out.println("2. Agendamento de Leilões");
            System.out.println("3. Controle de Animais e Lotes");
            System.out.println("4. Gerenciar Vendas");
            System.out.println("5. Emissão de Faturas");
            System.out.println("6. Controle de Despesas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Abrir interface gráfica de clientes...");
                    // Aqui futuramente você chama a interface gráfica:
                    // TelaCliente.main(null);
                    break;
                case 2:
                    System.out.println("Funcionalidade de leilões em desenvolvimento...");
                    break;
                case 3:
                    System.out.println("Funcionalidade de animais e lotes em desenvolvimento...");
                    break;
                case 4:
                    System.out.println("Funcionalidade de vendas em desenvolvimento...");
                    break;
                case 5:
                    System.out.println("Funcionalidade de faturas em desenvolvimento...");
                    break;
                case 6:
                    System.out.println("Funcionalidade de despesas em desenvolvimento...");
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}
