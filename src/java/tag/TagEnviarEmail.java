package tag;

import java.sql.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagEnviarEmail extends SimpleTagSupport{
    private Emails emails = new Emails();
    private Email email;
    private String emailCadastro, destinatario, mensagem, assunto;

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setEmailCadastro(String emailCadastro) {
        this.emailCadastro = emailCadastro;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    @Override
    public void doTag(){
        try {
            email = emails.getEmail(emailCadastro);
            Properties props = new Properties();
            String uname = "";
            
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", email.getServidorSMTP());
            props.put("mail.smtp.port", email.getPortaSMTP());
            props.put("mail.smtp.socketFactory.port", email.getPortaSMTP());
            if (email.getSslLeitura() == 1)
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(emailCadastro, email.getSenha());
                }});
            
            Message mensagemEmail = new MimeMessage(session);
            mensagemEmail.setFrom(new InternetAddress(emailCadastro));
            mensagemEmail.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            mensagemEmail.setSubject(assunto);
            mensagemEmail.setText(mensagem);
            Transport transport;
            if (email.getSslLeitura() == 1)
                transport = session.getTransport("smtps");
            else
                transport = session.getTransport("smtp");
            transport.connect(email.getServidorSMTP(), Integer.valueOf(email.getPortaSMTP()), emailCadastro, email.getSenha());
            transport.sendMessage(mensagemEmail, mensagemEmail.getAllRecipients());
            transport.close();
            this.getJspContext().setAttribute("resultado", "enviou");
            
        } catch(MessagingException e) {
            this.getJspContext().setAttribute("resultado", "nenviou");
            this.getJspContext().setAttribute("erro", e.getCause());
        } catch(Exception er) {} 
    }
    
}
