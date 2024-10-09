package ifmt.cba.fabrica;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Incluir {
    public static void main(String[] args) {
        Connection conexao = null;
        Statement comando = null;
        System.out.println("");
        String nome = JOptionPane.showInputDialog("Forneca o nome do grupo de produto");
        float promocao = Float.parseFloat(JOptionPane.showInputDialog("Forneca o percentual de promocao do grupo de produto"));
        float margem = Float.parseFloat(JOptionPane.showInputDialog("Forneca o percentual da margem de lucro do grupo de produto"));
        String sql = "INSERT INTO grupoproduto( nome, promocao, margemlucro ) VALUES ";
        sql += "('" + nome + "', " + promocao + ", " + margem + ")";
        try {
            conexao = FabricaConexao.obterConexao();
            comando = conexao.createStatement();
            comando.executeUpdate(sql);
            System.out.println("Inclusão realizada com sucesso");
        } catch (Exception ex) {
            System.out.println("Erro ao incluir grupo de produto" + ex.toString());
        } finally {
            try{
                comando.close();
                conexao.close();
            } catch (SQLException ex){
                System.out.println("Erro ao desconectar" + ex.toString());
            }
        }
    }    
}
