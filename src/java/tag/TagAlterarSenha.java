package tag;

import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagAlterarSenha extends SimpleTagSupport{
    private Usuarios usuarios = new Usuarios();
    private Usuario usuario;
    private String email, senhaAntiga, senhaNova;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenhaAntiga(String senhaAntiga) {
        this.senhaAntiga = senhaAntiga;
    }

    public void setSenhaNova(String senhaNova) {
        this.senhaNova = senhaNova;
    }
    
    @Override
    public void doTag() {
        try {
            usuario = Usuarios.getUsuario(email);
            if (usuario.getSenha().equals(senhaAntiga)) {
                usuarios.alterarSenha(usuario, senhaNova);
                this.getJspContext().setAttribute("resultado", "alterou");
            }
            else
                this.getJspContext().setAttribute("resultado", "nalterou");
        } catch(Exception e) {
            this.getJspContext().setAttribute("resultado", "nalterou");
        }
    }
    
}
