package tag;

import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagConsultarEmail extends SimpleTagSupport{
    private String emailCadastro;
    private Email email;
    private Emails emails = new Emails();

    public void setEmailCadastro(String emailCadastro) {
        this.emailCadastro = emailCadastro;
    }
    
    @Override 
    public void doTag() {
        try {
            email = emails.getEmail(emailCadastro);
            this.getJspContext().setAttribute("email", emailCadastro);
            this.getJspContext().setAttribute("senha", email.getSenha());
            this.getJspContext().setAttribute("portaLeitura", email.getPortaLeitura());
            this.getJspContext().setAttribute("portaSMTP", email.getPortaSMTP());
            this.getJspContext().setAttribute("servidorLeitura", email.getServidorLeitura());
            this.getJspContext().setAttribute("servidorSMTP", email.getServidorSMTP());
            this.getJspContext().setAttribute("sslLeitura", email.getSslLeitura());

        } catch (Exception e) {
            this.getJspContext().setAttribute("email", "erro");
            this.getJspContext().setAttribute("senha", "erro");
            this.getJspContext().setAttribute("portaLeitura", "erro");
            this.getJspContext().setAttribute("portaSMTP", "erro");
            this.getJspContext().setAttribute("servidorLeitura", "erro");
            this.getJspContext().setAttribute("servidorSMTP", "erro");
            this.getJspContext().setAttribute("sslLeitura", "erro");
        }
    }
    
}
