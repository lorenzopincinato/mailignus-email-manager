package tag;

public class Usuario {
	private String usuario;
	private String senha;
	
    public Usuario (String user, String pass) {
        this.setUsuario(user);
        this.setSenha(pass);
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }	
}
