package br.com.ecovida.models;

import java.util.Scanner;

public class Login {

    private String username;
    private String password;
    private boolean acesso = false;
    private static final Scanner scanner = new Scanner(System.in);
    private Conta contaAutenticada; // Variável para armazenar a conta autenticada

    // Construtor Padrão
    public Login() {}

    // Construtor com Parâmetros
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Método para autenticar o login
    public static boolean autenticar(String id, String password) {
        // Verifica se o id e a senha correspondem a algum usuário existente
        return (id.equals(UsuarioPF.CHICO_BUARQUE.getId()) && password.equals(UsuarioPF.CHICO_BUARQUE.getPassword())) ||
                (id.equals(UsuarioPJ.GAL_COSTA.getId()) && password.equals(UsuarioPJ.GAL_COSTA.getPassword())) ||
                (id.equals(UsuarioPF.CAETANO_VELOSO.getId()) && password.equals(UsuarioPF.CAETANO_VELOSO.getPassword()));
    }

    // Método para realizar o login com tentativas
    public void doLogin() {
        if (this.username == null) {
            System.out.println("Seja bem-vindo à EcoVida!");
            System.out.println("------".repeat(10));
            System.out.print("Digite seu nome de usuário: ");
            this.username = scanner.nextLine();
        }

        int tentativas = 0; // Contador de tentativas

        while (tentativas < 3) {
            if (this.password == null) {
                System.out.print("Digite sua senha: ");
                this.password = scanner.nextLine();
            }

            // Verifica as credenciais usando a classe `DadosUsuarios`
            if (autenticar(this.username, this.password)) {
                System.out.println("Acesso efetuado com sucesso para o usuário " + this.username);
                this.acesso = true;

                // Define a conta autenticada
                this.contaAutenticada = Conta.autenticarConta(this.username, this.password);

                // Exibir mensagem de boas-vindas e dados do usuário
                exibirDadosUsuario(this.username);
                return; // Sai do método após o login bem-sucedido
            } else {
                System.out.println("Seu nome de usuário ou senha estão incorretos!");
                tentativas++;

                if (tentativas < 3) {
                    while (true) { // Loop para garantir uma resposta válida
                        System.out.print("Esqueceu sua senha? (s/n): ");
                        String resposta = scanner.nextLine().trim().toLowerCase();

                        if (resposta.equals("s")) {
                            recuperarSenha(username);
                            tentativas = 0;  // Reseta tentativas após redefinição de senha
                            return;
                        } else if (resposta.equals("n")) {
                            this.password = null; // Resetando senha para nova tentativa
                            break; // Sai do loop e continua para a próxima tentativa
                        } else {
                            System.out.println("Opção inválida! Digite 's' para sim ou 'n' para não.");
                        }
                    }
                }
            }
        }

        System.out.println("Seu cadastro foi bloqueado. Entre em contato com o suporte!");
    }

    // Método que retorna se o usuário tem acesso ou não
    public boolean temAcesso() {
        return this.acesso;
    }

    // Método para recuperar a senha
    private void recuperarSenha(String username) {
        System.out.println("Recuperação de senha iniciada para o usuário: " + username);
        System.out.println("Verifique seu e-mail para instruções sobre como redefinir sua senha.");
    }

    // Método para exibir os dados do usuário após o login
    private void exibirDadosUsuario(String username) {
        System.out.println("\nOlá, " + username + "! Você tem acesso ao sistema.\n");

        // Verifica se o usuário é PF ou PJ e exibe os dados correspondentes
        if (username.equals(UsuarioPF.CHICO_BUARQUE.getId())) {
            UsuarioPF usuario = UsuarioPF.CHICO_BUARQUE;
            System.out.println("Dados do Usuário (Pessoa Física):");
            System.out.println("Nome: " + usuario.getRazaoSocial());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Data de Nascimento: " + usuario.getDataNascimento());
            System.out.println("CPF: " + usuario.getCpf());
        } else if (username.equals(UsuarioPF.CAETANO_VELOSO.getId())) {
            UsuarioPF usuario = UsuarioPF.CAETANO_VELOSO;
            System.out.println("Dados do Usuário (Pessoa Física):");
            System.out.println("Nome: " + usuario.getRazaoSocial());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Data de Nascimento: " + usuario.getDataNascimento());
            System.out.println("CPF: " + usuario.getCpf());
        } else if (username.equals(UsuarioPJ.GAL_COSTA.getId())) {
            UsuarioPJ usuario = UsuarioPJ.GAL_COSTA;
            System.out.println("Dados do Usuário (Pessoa Jurídica):");
            System.out.println("Razão Social: " + usuario.getRazaoSocial());
            System.out.println("CNPJ: " + usuario.getCnpj());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Data de Criação: " + usuario.getDataCriacao());
            System.out.println("Sócios: " + String.join(", ", usuario.getNomesSocios()));
        } else {
            System.out.println("Dados do usuário não encontrados.");
        }
    }

    // Método para retornar o usuário autenticado
    public Usuario getUsuarioAutenticado() {
        if (this.username.equals(UsuarioPF.CHICO_BUARQUE.getId())) {
            return UsuarioPF.CHICO_BUARQUE;
        } else if (this.username.equals(UsuarioPF.CAETANO_VELOSO.getId())) {
            return UsuarioPF.CAETANO_VELOSO;
        } else if (this.username.equals(UsuarioPJ.GAL_COSTA.getId())) {
            return UsuarioPJ.GAL_COSTA;
        } else {
            return null;
        }
    }

    // Método para retornar a conta autenticada
    public Conta getContaAutenticada() {
        return this.contaAutenticada;
    }
}
