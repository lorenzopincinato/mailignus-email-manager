package tag;

import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagLogar extends SimpleTagSupport{
    private Usuarios usuarios = new Usuarios();
    private Usuario usuario;
    private String email, senha, resultado;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
  
    @Override
    public void doTag(){
        try {
            if ((usuario = usuarios.getUsuario(email)) != null) {
                if (usuario.getSenha().equals(senha))
                    //this.getJspContext().getOut().write("Logou");
                    this.getJspContext().setAttribute("resultado", "logou");
                else
                    this.getJspContext().setAttribute("resultado", "nlogou");
            }
                
        } catch (Exception e) {
            this.getJspContext().setAttribute("resultado", "nlogou");
        }
    }        
}
