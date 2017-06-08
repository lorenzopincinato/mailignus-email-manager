package tag;

import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagCadastrarEmail extends SimpleTagSupport{
    private Emails emails = new Emails();
    private Email email;
    private String emailCadastro, senhaEmail, usuario, servidorLeitura, servidorSMTP;
    private int portaLeitura, portaSMTP, sslLeitura;

    public void setServidorLeitura(String servidorLeitura) {
        this.servidorLeitura = servidorLeitura;
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

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setEmailCadastro(String emailCadastro) {
        this.emailCadastro = emailCadastro;
    }

    public void setSenhaEmail(String senha) {
        this.senhaEmail = senha;
    }
    
    @Override
    public void doTag() {
        try {
            email = new Email(emailCadastro, senhaEmail, servidorLeitura, servidorSMTP, portaLeitura, portaSMTP, sslLeitura);
            if (emails.cadastrar(email, usuario) != false)
                this.getJspContext().setAttribute("resultado", "cadastrou");
            else
                this.getJspContext().setAttribute("resultado", "ncadastrou");
        } catch(Exception e) {
            this.getJspContext().setAttribute("resultado", "ncadastrou");
        }
    }
    
}
