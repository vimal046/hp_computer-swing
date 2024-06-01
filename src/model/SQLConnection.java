package model;

import java.sql.*;

/**
 *
 * @author VIMAL SUKU
 */
public class SQLConnection {

    private String dbName = "hp_computer_and_laptop_accessories";
    private String uName = "vimal";
    private String pwd = "vimal";
    Connection con = null;

    public Connection getConnection() {

        String url = "jdbc:sqlserver://localhost:1433;database=" + dbName + ";trustServerCertificate=true;";

        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            con=DriverManager.getConnection(url,uName,pwd);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return con;

    }
    
    public static void main(String[] args) {
        Connection con=new SQLConnection().getConnection();
        
        if(con!=null){
            System.out.println("Connection established");
        }else{
            System.out.println("Failed to connect");
        }
        System.out.println(new SQLConnection().getConnection());
    }

}
