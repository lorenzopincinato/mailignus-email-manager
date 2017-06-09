package tag;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagConteudoEmail extends SimpleTagSupport{
    private String emailCadastroNAOUSUARIO, tituloEmail;
    private Email email;
    private Emails emails = new Emails();

    public void setEmailCadastroNAOUSUARIO(String emailCadastroNAOUSUARIO) {
        this.emailCadastroNAOUSUARIO = emailCadastroNAOUSUARIO;
    }

    public void setTituloEmail(String tituloEmail) {
        this.tituloEmail = tituloEmail;
    }
    
    @Override
    public void doTag() {
        ArrayList<String> array = new ArrayList();
        Properties props = new Properties();
        
        try {           
            email = emails.getEmail(emailCadastroNAOUSUARIO);
            
            Session session = Session.getDefaultInstance(props, null);
            Store store;
            
            if (email.getSslLeitura() == 1) 
                store = session.getStore(email.getServidorLeitura().substring(0, 4) + "s");
            else
                store = session.getStore(email.getServidorLeitura().substring(0, 3));
            store.connect(email.getServidorLeitura(), email.getPortaLeitura(), emailCadastroNAOUSUARIO, email.getSenha());            

            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);
            int messageCount = inbox.getMessageCount();

            //System.out.println("Total Messages:- " + messageCount);

            Message[] messages = inbox.getMessages();
            for (int i = messages.length -1; i > 0; i--) {
               if (messages[i].getSubject().equals(tituloEmail)) {
                   array.add(getTextFromMessage(messages[i]));
                   break;
               }
               //System.out.println("Texto:- " + getTextFromMessage(messages[i]));
            }
            inbox.close(true);
            store.close();
            this.getJspContext().setAttribute("resultado", array);
            //this.getJspContext().getOut().write(array + "");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private String getTextFromMessage(Message message) throws Exception {
        String result = "";
        if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }

    private String getTextFromMimeMultipart(
        MimeMultipart mimeMultipart) throws Exception{
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break; // without break same text appears twice in my tests
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart){
                result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
            }
        }
        return result;
    }
}
