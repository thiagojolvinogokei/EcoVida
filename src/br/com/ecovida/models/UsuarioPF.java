package br.com.ecovida.models;

import java.util.ArrayList;
import br.com.ecovida.model.Endereco;

public class UsuarioPF extends Usuario {
    private String razaoSocial;
    private String email;
    private String dataNascimento;
    private int cpf;
    private ArrayList<Endereco> enderecos; // Lista de endereços associados ao usuário

    // Construtor
    public UsuarioPF(String id, String senha, String razaoSocial, String email, String dataNascimento, int cpf) {
        super(id, senha); // Passando id como String para o construtor da classe pai
        this.razaoSocial = razaoSocial;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.enderecos = new ArrayList<>(); // Inicializa a lista de endereços
    }

    // Getters e Setters
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setNome(String nome) {
        this.razaoSocial = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    // Método para adicionar um endereço à lista de endereços
    public void adicionarEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }

    // Usuário PF com dados de Chico Buarque
    public static final UsuarioPF CHICO_BUARQUE = new UsuarioPF(
            "chico.buarque", "AguasDeMarco2025!", "Chico Buarque", "chico@exemplo.com", "1939-06-19", 123456789
    );

    //Usuário PF com dados de Caetano Veloso
    public static final UsuarioPF CAETANO_VELOSO = new UsuarioPF(
            "caetano.veloso", "OLeaozinho23!", "Caetano Veloso", "caetano@exemplo.com", "1942-08-07", 987654321
    );
}
