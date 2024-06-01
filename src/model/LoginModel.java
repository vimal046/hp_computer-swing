
package model;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author VIMAL SUKU
 */
public class LoginModel {
    Connection con;

    public LoginModel() {
        con=new SQLConnection().getConnection();
    }
    
    public boolean userAuthendication(String password){
        boolean isValid=false;
        try{
            
            String query="{call sp_LoginAuthendication(?,?,?)}";
            CallableStatement cs=con.prepareCall(query);
            cs.setString(1, "User");
            cs.setString(2, password);
            cs.registerOutParameter(3, Types.BOOLEAN);
            cs.execute();
            isValid=cs.getBoolean(3);
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return isValid;
    }
    
    public boolean adminAuthendication(String password){
        boolean isValid=false;
        try{
            
            String query="{call sp_LoginAuthendication(?,?,?)}";
            CallableStatement cs=con.prepareCall(query);
            cs.setString(1, "Admin");
            cs.setString(2, password);
            cs.registerOutParameter(3, Types.BOOLEAN);
            cs.execute();
            isValid=cs.getBoolean(3);
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return isValid;
    }
    
}
