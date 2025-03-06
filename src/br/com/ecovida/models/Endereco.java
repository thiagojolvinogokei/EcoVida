package br.com.ecovida.model;

public class Endereco {
    private String destinatarioEndereco;
    private String logradouroEndereco;
    private String numeroEndereco;
    private String bairroEndereco;
    private String cidadeEndereco;
    private String estadoEndereco;
    private String cepEndereco;

    // Construtor
    public Endereco(String destinatarioEndereco, String logradouroEndereco, String numeroEndereco,
                    String bairroEndereco, String cidadeEndereco, String estadoEndereco, String cepEndereco) {
        this.destinatarioEndereco = destinatarioEndereco;
        this.logradouroEndereco = logradouroEndereco;
        this.numeroEndereco = numeroEndereco;
        this.bairroEndereco = bairroEndereco;
        this.cidadeEndereco = cidadeEndereco;
        this.estadoEndereco = estadoEndereco;
        this.cepEndereco = cepEndereco;
    }

    // Getters e setters
    public String getDestinatarioEndereco() { return destinatarioEndereco; }
    public void setDestinatarioEndereco(String destinatarioEndereco) { this.destinatarioEndereco = destinatarioEndereco; }

    public String getLogradouroEndereco() { return logradouroEndereco; }
    public void setLogradouroEndereco(String logradouroEndereco) { this.logradouroEndereco = logradouroEndereco; }

    public String getNumeroEndereco() { return numeroEndereco; }
    public void setNumeroEndereco(String numeroEndereco) { this.numeroEndereco = numeroEndereco; }

    public String getBairroEndereco() { return bairroEndereco; }
    public void setBairroEndereco(String bairroEndereco) { this.bairroEndereco = bairroEndereco; }

    public String getCidadeEndereco() { return cidadeEndereco; }
    public void setCidadeEndereco(String cidadeEndereco) { this.cidadeEndereco = cidadeEndereco; }

    public String getEstadoEndereco() { return estadoEndereco; }
    public void setEstadoEndereco(String estadoEndereco) { this.estadoEndereco = estadoEndereco; }

    public String getCepEndereco() { return cepEndereco; }
    public void setCepEndereco(String cepEndereco) { this.cepEndereco = cepEndereco; }
}
