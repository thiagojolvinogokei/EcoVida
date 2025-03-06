package br.com.ecovida.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conta {
    private int nConta;
    private double saldo;
    private Usuario usuario;

    private static List<Conta> CONTAS = new ArrayList<>();
    private static Conta contaAutenticada = null;

    public int getnConta() {
        return nConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Conta(int nConta, double saldo, Usuario usuario) {
        this.nConta = nConta;
        this.saldo = saldo;
        this.usuario = usuario;
    }

    public static Conta autenticarConta(String id, String password) {
        for (Conta conta : CONTAS) {
            if (conta.getUsuario().getId().equals(id) && conta.getUsuario().getPassword().equals(password)) {
                contaAutenticada = conta;
                return conta;
            }
        }
        return null;
    }

    static {
        CONTAS.add(new Conta(3567110, 100000.00, Usuario.GAL_COSTA));
        CONTAS.add(new Conta(5432160, 30000.00, Usuario.CAETANO_VELOSO));
        CONTAS.add(new Conta(5472911, 54000.00, Usuario.CHICO_BUARQUE));
    }

    public static void imprimirDetalhes() {
        if (contaAutenticada != null) {
            System.out.println("Número da Conta: " + contaAutenticada.getnConta());
            System.out.println("Saldo: R$ " + contaAutenticada.getSaldo());
        } else {
            System.out.println("Nenhuma conta autenticada.");
        }
    }

    public static void realizarTransferencia() {
        if (contaAutenticada == null) {
            System.out.println("Nenhuma conta autenticada.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu de Transferência");
            System.out.println("1. Efetuar Transferência");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Digite o número da conta de destino: ");
                int contaDestino = scanner.nextInt();
                System.out.print("Digite o valor a transferir: ");
                double valor = scanner.nextDouble();

                Conta destino = null;
                for (Conta conta : CONTAS) {
                    if (conta.getnConta() == contaDestino) {
                        destino = conta;
                        break;
                    }
                }

                if (destino == null) {
                    System.out.println("Conta de destino não encontrada.");
                } else if (valor <= 0 || valor > contaAutenticada.getSaldo()) {
                    System.out.println("Saldo insuficiente ou valor inválido.");
                } else {
                    contaAutenticada.setSaldo(contaAutenticada.getSaldo() - valor);
                    destino.setSaldo(destino.getSaldo() + valor);
                    System.out.println("Transferência realizada com sucesso!");
                    imprimirDetalhes();
                }
            }
        } while (opcao != 2);

        System.out.println("Saindo do menu de transferência.");
    }
}
