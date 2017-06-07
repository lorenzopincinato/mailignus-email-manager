package tag;

import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagExcluirEmail extends SimpleTagSupport{
    private Emails emails = new Emails();
    private Email email;
    private String emailCadastro, usuario;

    public void setEmailCadastro(String emailCadastro) {
        this.emailCadastro = emailCadastro;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public void doTag(){
        try {
            emails.excluir(emailCadastro, usuario);
            this.getJspContext().setAttribute("resultado", "excluiu");
        } catch(Exception e) {
            this.getJspContext().setAttribute("resultado", "nexcluiu");
        }
    }
}
