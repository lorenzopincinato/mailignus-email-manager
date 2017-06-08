package tag;

import core.MeuResultSet;
import java.sql.*;

public class Usuarios {

    public static boolean cadastrar(Usuario user) throws Exception {
        if (user == null)
            throw new Exception ("Usuario não fornecido.");
        if (cadastrado(user.getUsuario())) 
            return false;
        else {
            try {
                String sql;

                sql = "insert into LoginEmail values(?, ?)";

                DAOs.getBD().prepareStatement (sql);

                DAOs.getBD().setString (1, user.getUsuario());
                DAOs.getBD().setString (2, user.getSenha());

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
                  "FROM LoginEmail " +
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
	
	
    public static void excluir (String email) throws Exception {
        if (!cadastrado (email))
            throw new Exception ("Usuario não cadastrado.");

        try {
            String sql;

            sql = "DELETE FROM LoginEmail " +
                  "WHERE email = ?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setString(1, email);

            DAOs.getBD().executeUpdate ();
            DAOs.getBD().commit        (); 
        } 
        
        catch (SQLException erro) {
            	throw new Exception ("Erro ao excluir usuario.");
        }	
    }
	
	
    public static void alterarEmail (Usuario user, String novoUser) throws Exception {
        if (user == null)
            throw new Exception ("Usuario não fornecido.");

        if (!cadastrado (user.getUsuario()))
            throw new Exception ("Usuario não cadastrado.");

        try {
            String sql;

            sql = "UPDATE LoginEmail " +
                  "SET email = ? " +
                  "WHERE email = ?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setString (1, novoUser);
            DAOs.getBD().setString (2, user.getUsuario());

            DAOs.getBD().executeUpdate ();
            DAOs.getBD().commit        ();
        }
        
        catch (SQLException erro) {
            throw new Exception ("Erro ao atualizar dados de usuario.");
        }
    }
    
    public static void alterarSenha (Usuario user, String novaSenha) throws Exception {
        if (user == null)
            throw new Exception ("Usuario não fornecido.");

        if (!cadastrado (user.getUsuario()))
            throw new Exception ("Usuario não cadastrado.");

        try {
            String sql;

            sql = "UPDATE LoginEmail " +
                  "SET senha = ? " +
                  "WHERE email = ?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setString (1, novaSenha);
            DAOs.getBD().setString (2, user.getUsuario());

            DAOs.getBD().executeUpdate ();
            DAOs.getBD().commit        ();
        }
        
        catch (SQLException erro) {
            throw new Exception ("Erro ao atualizar dados de usuario.");
        }
    }
	
	
    public static Usuario getUsuario (String email) throws Exception {
        Usuario user = null;

        try {
            String sql;

            sql = "SELECT * " +
                  "FROM LoginEmail " +
                  "WHERE email = ?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setString (1, email);

            MeuResultSet resultado = (MeuResultSet)DAOs.getBD().executeQuery ();

            if (!resultado.first())
                throw new Exception ("Usuario não cadastrado.");

            user = new Usuario (resultado.getString("email"), resultado.getString("senha"));
        }
        catch (SQLException erro) {
            throw new Exception ("Erro ao procurar usuario.");
        }

        return user;
    }
    
}
