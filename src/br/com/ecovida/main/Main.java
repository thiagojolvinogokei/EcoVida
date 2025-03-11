package br.com.ecovida.main;

import br.com.ecovida.model.Endereco;
import br.com.ecovida.model.Login;
import br.com.ecovida.model.Conta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        login.doLogin();

        if (login.temAcesso()) {
            System.out.println("\nVocê tem acesso ao sistema!");
            System.out.println("------".repeat(10));
            Conta contaAutenticada = login.getContaAutenticada();

            if (contaAutenticada != null) {
                System.out.println("Número da Conta: " + contaAutenticada.getnConta());
                System.out.println("Saldo: R$ " + contaAutenticada.getSaldo());
                System.out.println("------".repeat(10));

                menuPrincipal(contaAutenticada); // Chama o menu de opções
            } else {
                System.out.println("Nenhuma conta autenticada.");
            }
        } else {
            System.out.println("Acesso negado.");
        }
    }


    public static void menuPrincipal(Conta contaAutenticada) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar Endereço");
            System.out.println("2. Ver Endereços");
            System.out.println("3. Realizar Transferência");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1 -> {
                    // Adiciona um endereço
                    System.out.print("Rua: ");
                    String rua = scanner.nextLine();
                    System.out.print("Número: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine(); // Consumir quebra de linha
                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();
                    System.out.print("Estado: ");
                    String estado = scanner.nextLine();
                    System.out.print("CEP: ");
                    String cep = scanner.nextLine();

                    Endereco novoEndereco = new Endereco(rua, numero, cidade, estado, cep);
                    contaAutenticada.adicionarEndereco(novoEndereco);
                }
                case 2 -> {
                    // Exibe todos os endereços
                    contaAutenticada.listarEnderecos();
                }
                case 3 -> {
                    // Realiza transferência
                    Conta.realizarTransferencia();
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

}
