package tag;

import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagAlterarUsuario extends SimpleTagSupport{
    private Usuarios usuarios = new Usuarios();
    private Usuario usuario;
    private String emailAntigo, emailNovo, senha;

    public void setEmailAntigo(String emailAntigo) {
        this.emailAntigo = emailAntigo;
    }

    public void setEmailNovo(String emailNovo) {
        this.emailNovo = emailNovo;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public void doTag() {
        try {
            usuario = Usuarios.getUsuario(emailAntigo);
            if (usuario.getSenha().equals(senha)) {
                usuarios.alterarEmail(usuario, emailNovo);
                this.getJspContext().setAttribute("resultado", "alterou");
            }
            else
                this.getJspContext().setAttribute("resultado", "nalterou");
        } catch(Exception e) {
            this.getJspContext().setAttribute("resultado", "nalterou");
        }
    }
    
}
