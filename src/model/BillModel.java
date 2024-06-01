package model;

import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;
import pojo.BillPair;

/**
 *
 * @author VIMAL SUKU
 */
public class BillModel {

    Connection con;

    public BillModel() {

        con = new SQLConnection().getConnection();

    }

    public void placeOrder(String name, String mobile,int total,String dateTime, Stack<BillPair> stack) {
       
        
        try{
            String query="{call sp_CustomerDataInsert(?,?,?,?,?)}";
            CallableStatement cs=con.prepareCall(query);
            cs.setString(1, name);
            cs.setString(2, mobile);
            cs.setInt(3, total);
            cs.setString(4, dateTime);
            cs.registerOutParameter(5, java.sql.Types.INTEGER);
            cs.executeUpdate();
            int customerId=cs.getInt(5);
            
            String query1="{call sp_CustomerPurchaseList(?,?,?,?,?)}";
            CallableStatement cs1=con.prepareCall(query1);
            
            int itemNo=1;
            for(BillPair obj:stack){
               cs1.setInt(1, customerId);
               cs1.setInt(2,itemNo);
               cs1.setString(3, obj.getName());
               cs1.setString(4,dateTime);
               cs1.setInt(5, obj.getPrice());
               cs1.executeUpdate();
               itemNo++;
            }
            
            JOptionPane.showMessageDialog(null, "Order Placed SuccessFully");
            
        }catch(SQLException e){
            e.printStackTrace();
        }


    }

    
}
