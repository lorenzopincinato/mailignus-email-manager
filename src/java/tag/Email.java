package tag;

public class Email {
	private String usuario;
	private String senha;
        private String servidorLeitura, servidorSMTP;
        private int portaLeitura, portaSMTP, sslLeitura;

    public Email(String usuario, String senha, String servidorLeitura, String servidorSMTP, int portaLeitura, int portaSMTP, int sslLeitura) {
        this.usuario = usuario;
        this.senha = senha;
        this.servidorLeitura = servidorLeitura;
        this.servidorSMTP = servidorSMTP;
        this.portaLeitura = portaLeitura;
        this.portaSMTP = portaSMTP;
        this.sslLeitura = sslLeitura;
    }

    public String getServidorLeitura() {
        return servidorLeitura;
    }

    public String getServidorSMTP() {
        return servidorSMTP;
    }

    public int getPortaLeitura() {
        return portaLeitura;
    }

    public int getPortaSMTP() {
        return portaSMTP;
    }

    public int getSslLeitura() {
        return sslLeitura;
    }

    public void setServidorSMTP(String servidorSMTP) {
        this.servidorSMTP = servidorSMTP;
    }

    public void setPortaLeitura(int portaLeitura) {
        this.portaLeitura = portaLeitura;
    }

    public void setPortaSMTP(int portaSMTP) {
        this.portaSMTP = portaSMTP;
    }

    public void setSslLeitura(int sslLeitura) {
        this.sslLeitura = sslLeitura;
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