package br.com.ecovida.main;

import br.com.ecovida.models.Login;
import br.com.ecovida.models.Conta;

public class Main {
    public static void main(String[] args) {
        // Cria um objeto Login
        Login login = new Login();

        // Chama o método de login para autenticação
        login.doLogin();

        // Verifica se o login foi bem-sucedido
        if (login.temAcesso()) {
            System.out.println("\nVocê tem acesso ao sistema!");
            System.out.println("------".repeat(10));

            // Obtém a conta autenticada
            Conta contaAutenticada = login.getContaAutenticada();

            if (contaAutenticada != null) {
                // Imprime os detalhes da conta autenticada
                System.out.println("Número da Conta: " + contaAutenticada.getnConta());
                System.out.println("Saldo: R$ " + contaAutenticada.getSaldo());

                System.out.println("------".repeat(10));

                // Adiciona a opção de transferência
                Conta.realizarTransferencia();
            } else {
                System.out.println("Nenhuma conta autenticada.");
            }
        } else {
            System.out.println("Acesso negado.");
        }
    }
}
