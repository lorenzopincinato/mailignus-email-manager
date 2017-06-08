package tag;

import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagAlterarEmail extends SimpleTagSupport{
    private Emails emails = new Emails();
    private Email email;
    private String emailCadastro, senhaEmail, usuario, servidorLeitura, servidorSMTP;
    private int portaLeitura, portaSMTP, sslLeitura;

    public void setEmailCadastro(String emailCadastro) {
        this.emailCadastro = emailCadastro;
    }

    public void setSenhaEmail(String senhaEmail) {
        this.senhaEmail = senhaEmail;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setServidorLeitura(String servidorLeitura) {
        this.servidorLeitura = servidorLeitura;
    }

    public void setServidorSMTP(String servidorSMTP) {
        this.servidorSMTP = servidorSMTP;
    }

    public void setPortaLeitura(int portaLeitura) {
        this.portaLeitura = portaLeitura;
    }

    public void setSslLeitura(int sslLeitura) {
        this.sslLeitura = sslLeitura;
    }
    
    @Override
    public void doTag() {
        try {
            emails.excluir(emailCadastro, usuario);
            email = new Email (emailCadastro, senhaEmail, servidorLeitura, servidorSMTP, portaLeitura, portaSMTP, sslLeitura);
            if (emails.cadastrar(email, usuario) != false)
                this.getJspContext().setAttribute("resultado", "alterou");
            else
                this.getJspContext().setAttribute("resultado", "nalterou");
        } catch(Exception e) {
            this.getJspContext().setAttribute("resultado", "nalterou");
        }
    }
}
