package tag;

import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagCadastrar extends SimpleTagSupport{
    private Usuarios usuarios = new Usuarios();
    private Usuario usuario;
    private String email, senha;


    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    @Override
    public void doTag() {
        try {
            usuario = new Usuario(email, senha);
            if (usuarios.cadastrar(usuario) != false)
                this.getJspContext().setAttribute("resultado", "cadastrou");
            else
                this.getJspContext().setAttribute("resultado", "ncadastrou");
        } catch(Exception e) {
            this.getJspContext().setAttribute("resultado", "ncadastrou");
        }
    }
    
}
