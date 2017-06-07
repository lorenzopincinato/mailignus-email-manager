package tag;

import core.MeuPreparedStatement;

public class DAOs {
    private static MeuPreparedStatement bd;

    private static Usuarios usuarios;

    static {
        try {
            DAOs.bd = new MeuPreparedStatement (
                      "com.microsoft.sqlserver.jdbc.SQLServerDriver",
                      "jdbc:sqlserver://REGULUS:1433;databasename=BD15158",
                      "BD15158", "almondega");

            DAOs.usuarios = new Usuarios ();
        }
        
        catch (Exception erro) {
            System.err.println ("Problemas de conexão com o banco de dados.");
            System.exit(0);
        }
    }

    
    public static MeuPreparedStatement getBD () {
        return DAOs.bd;
    }

    
    public static Usuarios getPugs () {
        return DAOs.usuarios;
    }
}