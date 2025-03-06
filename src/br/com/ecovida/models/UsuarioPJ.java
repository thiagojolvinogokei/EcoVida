package br.com.ecovida.models;

import java.util.ArrayList;
import br.com.ecovida.model.Endereco; // Importando a classe Endereco

public class UsuarioPJ extends Usuario {
    private String razaoSocial;
    private String cnpj;
    private String email;
    private ArrayList<String> nomesSocios; // Lista de nomes dos sócios
    private String dataCriacao; // Data de criação da empresa
    private ArrayList<Endereco> enderecos; // Lista de endereços associados à pessoa jurídica

    // Construtor
    public UsuarioPJ(String id, String senha, String razaoSocial, String cnpj, String email, String dataCriacao, ArrayList<String> nomesSocios) {
        super(id, senha); // Chama o construtor da classe pai (Usuario) para inicializar id e senha
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.email = email;
        this.dataCriacao = dataCriacao;
        this.nomesSocios = nomesSocios;
        this.enderecos = new ArrayList<>(); // Inicializa a lista de endereços
    }

    // Getters e Setters
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getNomesSocios() {
        return nomesSocios;
    }

    public void setNomesSocios(ArrayList<String> nomesSocios) {
        this.nomesSocios = nomesSocios;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
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

    // Usuários PJ com dados de Gal Costa e banda Tropicalia
    public static final UsuarioPJ GAL_COSTA = new UsuarioPJ(
            "gal.costa", "SampaVibe22!", "Banda Tropicalia", "12.345.678/0001-90", "gal@exemplo.com", "1967-01-01",
            new ArrayList<String>() {{
                add("Caetano Veloso");
                add("Gilberto Gil");
                add("Maria Bethânia");
                add("Gal Costa");
            }}
    );
}
