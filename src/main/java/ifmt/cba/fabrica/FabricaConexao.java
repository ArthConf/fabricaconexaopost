package ifmt.cba.fabrica;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class FabricaConexao {

        private static final String DRIVE = "org.postgresql.Driver";
        private static final String URL = "jdbc:postgresql://localhost:5432/produtos";
        private static final String USR = "postgres";
        private static final String PASS = "25032022";
    
        public static Connection obterConexao() throws Exception{
            Connection conexao = null;

            try {
                Class.forName(DRIVE);
                conexao = DriverManager.getConnection(URL, USR, PASS);
            } catch (ClassNotFoundException cnf) {
                throw new Exception("Driver não encontrado - "+cnf.getMessage());

            } catch (SQLException sqle){
                throw new Exception ("Erro ao conectar no banco - "+sqle.getMessage());
            }
            return conexao;
    }
}

