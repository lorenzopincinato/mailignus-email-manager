package tag;

import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagListarEmails extends SimpleTagSupport{
    private Emails emails = new Emails();
    private String usuario;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    @Override 
    public void doTag() {
        try {
            this.getJspContext().setAttribute("resultado", emails.getEmails(usuario));
        } catch (Exception e) {
            this.getJspContext().setAttribute("resultado", "erro");
        }
        
    }
}
