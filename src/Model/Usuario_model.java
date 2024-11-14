package Model;

public class Usuario_model {
     int id_usuario;
     String nome;
     String localizacao;
     TipoConsumo tipoConsumo;

    public Usuario_model() {
    }

    public Usuario_model(int id_usuario, String nome, String localizacao, TipoConsumo tipoConsumo) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.localizacao = localizacao;
        this.tipoConsumo = tipoConsumo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public TipoConsumo getTipoConsumo() {
        return tipoConsumo;
    }

    public void setTipoConsumo(TipoConsumo tipoConsumo) {
        this.tipoConsumo = tipoConsumo;
    }

    public void cadastrarUsuario(){
        System.out.println("Usuário " + nome + " cadastrado com sucesso");

    }

}
