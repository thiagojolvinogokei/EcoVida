package br.com.ecovida.model;

public class Usuario {
    protected String id;
    protected String password;

    // Construtor
    public Usuario(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // Usuários e senhas criados
    public static final Usuario CHICO_BUARQUE = new Usuario("chico.buarque", "AguasDeMarco2025!");
    public static final Usuario GAL_COSTA = new Usuario("gal.costa", "SampaVibe22!");
    public static final Usuario CAETANO_VELOSO = new Usuario("caetano.veloso", "OLeaozinho23!");
}
