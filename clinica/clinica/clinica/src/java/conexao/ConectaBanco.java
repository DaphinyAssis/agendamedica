
package conexao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBanco {
    Connection conBanco;
    public boolean abrirConexao(){
        String url="jdbc:mysql://localhost:3306/agenda_medica?user=root&password=";
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conBanco=DriverManager.getConnection(url);
        return true;
    } 
    catch (Exception erro)
    {
        
        return false;
    }    
}  
    public void fecharConexao(){
    try{
        conBanco.close();
        
    }
    catch (SQLException erro){
        erro.printStackTrace();
        
    }
    }
    public Connection obterConexao(){return conBanco;}  
}
