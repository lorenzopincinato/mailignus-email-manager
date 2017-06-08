package tag;

import core.MeuResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Emails {
    public static boolean cadastrar(Email user, String login) throws Exception {
        if (user == null)
            throw new Exception ("Usuario não fornecido.");
        if (cadastrado(user.getUsuario())) 
            return false;
        else {
            try {
                String sql;

                sql = "insert into Emails values(?, ?, ?, ?, ?, ?, ?)";

                DAOs.getBD().prepareStatement (sql);

                DAOs.getBD().setString (1, user.getUsuario());
                DAOs.getBD().setString (2, user.getSenha());
                DAOs.getBD().setString (3, user.getServidorLeitura());
                DAOs.getBD().setInt (4, user.getPortaLeitura());
                DAOs.getBD().setInt (5, user.getSslLeitura());
                DAOs.getBD().setString (6, user.getServidorSMTP());
                DAOs.getBD().setInt (7, user.getPortaSMTP());

                DAOs.getBD().executeUpdate ();
                DAOs.getBD().commit        ();
                DAOs.getBD().clearParameters();
                
                int primeiro = getCodCadastro(login);
                int segundo = getCodEmail(user.getUsuario());
                
                sql = "insert into ConecLoginEmail values("+ primeiro +", "+segundo+")";
                // por algum motivo o set int nao tava funcionando nesse caso
                
                /*sql = "insert into ConecLoginEmail values(? , ?)";
                DAOs.getBD().setInt (1, primeiro);
                DAOs.getBD().setInt (2, segundo);*/

                DAOs.getBD().prepareStatement (sql);

                DAOs.getBD().executeUpdate ();
                DAOs.getBD().commit        ();
                return true;
            }

            catch (SQLException erro) {
                throw new Exception ("Erro ao cadastrar usuario.");
            }
        }
        
    }
	
	
    public static boolean cadastrado (String email) throws Exception {
        boolean retorno = false;

        try {
            String sql;

            sql = "SELECT * " +
                  "FROM Emails " +
                  "WHERE email = ?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setString (1, email);

            MeuResultSet resultado = (MeuResultSet)DAOs.getBD().executeQuery ();

            retorno = resultado.first();
        }
        
        catch (SQLException erro) {
            throw new Exception ("Erro ao procurar email.");
        }

        return retorno;
    }
	
	
    public static void excluir (String email, String user) throws Exception {
        if (!cadastrado (email))
            throw new Exception ("Usuario não cadastrado.");

        try {
            String sql;
            
            int primeiro = getCodCadastro(user);
            int segundo = getCodEmail(email);
            
            sql = "DELETE FROM ConecLoginEmail " +
                  "WHERE codUsuario = "+ primeiro + " and codEmail = " + segundo;

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().executeUpdate ();
            DAOs.getBD().commit        (); 

            sql = "DELETE FROM Emails " +
                  "WHERE email = "+ email;

            DAOs.getBD().prepareStatement (sql);

            //DAOs.getBD().setString(1, email);

            DAOs.getBD().executeUpdate ();
            DAOs.getBD().commit        (); 
        } 
        
        catch (SQLException erro) {
            	throw new Exception ("Erro ao excluir usuario.");
        }	
    }
	
    public static Email getEmail (String email) throws Exception {
        Email user = null;

        try {
            String sql;

            sql = "SELECT * " +
                  "FROM Emails " +
                  "WHERE email = ?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setString (1, email);

            MeuResultSet resultado = (MeuResultSet)DAOs.getBD().executeQuery ();

            if (!resultado.first())
                throw new Exception ("Usuario não cadastrado.");

            user = new Email (resultado.getString("email"), resultado.getString("senha"), resultado.getString("servidorLeitura"), resultado.getString("servidorSMTP"), resultado.getInt("portaLeitura"), resultado.getInt("portaSMTP"), resultado.getInt("sslLeitura"));
        }
        catch (SQLException erro) {
            throw new Exception ("Erro ao procurar usuario.");
        }

        return user;
    }
    
    public static ArrayList getEmails(String usuario) throws Exception {
        ArrayList<String> emails = new ArrayList();
        ArrayList<Integer> codigos = new ArrayList();
        String sql;
        try {
            int codigoUser = getCodCadastro(usuario);
            
            sql = "select * from ConecLoginEmail where codUsuario = " + codigoUser;
            DAOs.getBD().prepareStatement (sql);

            MeuResultSet resultado = (MeuResultSet)DAOs.getBD().executeQuery ();
            
            if (!resultado.first())
                throw new Exception ("Usuario não cadastrado.");
            
            while (!resultado.isAfterLast()) {
                codigos.add(resultado.getInt("codEmail"));
                resultado.next();
            } 
            
            for (int i = 0; i < codigos.size(); i++) {
                sql = "select * from Emails where codigo = "+ codigos.get(i);
                DAOs.getBD().prepareStatement (sql);
                
                resultado = (MeuResultSet)DAOs.getBD().executeQuery ();
                
                if (!resultado.first())
                    throw new Exception ("Erro.");
                
                emails.add(resultado.getString("email"));
            }
            
            
        } catch(SQLException erro) {
            throw new Exception ("Erro");
        }
        
        return emails;
    }
    
    public static int getCodCadastro(String usuario) throws Exception{
        int codigo = 0;
        String nsei = "";
        try {
            String sql;
            sql = "SELECT * " +
                  "FROM LoginEmail " +
                  "WHERE email = ?";
            
            DAOs.getBD().prepareStatement(sql);
            
            DAOs.getBD().setString (1, usuario);
            
            MeuResultSet resultado = (MeuResultSet)DAOs.getBD().executeQuery ();
            
            if (!resultado.first())
                throw new Exception ("Não cadastrado.");
            
            codigo = resultado.getInt("codigo");
        } catch(SQLException erro) {
            throw new Exception ("Erro ao procurar usuario.");
        }
        return codigo;
    }
    
    public static int getCodEmail(String email) throws Exception{
        int codigo = 0;
        try {
            String sql;
            sql = "select codigo from Emails where email = ?";
            
            DAOs.getBD().prepareStatement(sql);
            
            DAOs.getBD().setString(1, email);
            
            MeuResultSet resultado = (MeuResultSet)DAOs.getBD().executeQuery();
            
            if (!resultado.first())
                throw new Exception ("Não cadastrado.");
            
            codigo = resultado.getInt("codigo");
        } catch(SQLException erro) {
            throw new Exception ("Erro ao procurar usuario.");
        }
        return codigo;
    }
}
