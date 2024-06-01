
package model;

import java.sql.*;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
import pojo.AdminPOJO;
import pojo.*;
/**
 *
 * @author VIMAL SUKU
 */
public class AdminModel {
    
    Connection con;

    public AdminModel() {
        con=new SQLConnection().getConnection();
    }
    
    public void updatePrice(String tableName,int productId,int newPrice){
        
        try{
            String query="{call sp_UpdatePrice(?,?,?)}";
            CallableStatement cs=con.prepareCall(query);
            cs.setString(1, tableName);
            cs.setInt(2, productId);
            cs.setInt(3, newPrice);
            cs.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "New Price Updated");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void deleteRow(String tableName,int productId){
        
        try{
            String query="{call sp_DeletePrice(?,?)}";
            CallableStatement cs=con.prepareCall(query);
            cs.setString(1, tableName);
            cs.setInt(2, productId);
            int result=cs.executeUpdate();
            if(result>0){
                JOptionPane.showMessageDialog(null, "Deleted successfully");
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public List<AdminPOJO> customerDataFetch(){
        
        List<AdminPOJO> list=new ArrayList<>();
        
        try{
            
            String query="{call sp_CustomerDataFetch}"; 
            CallableStatement cs=con.prepareCall(query);
            ResultSet rs= cs.executeQuery();
            
            while(rs.next()){
                
                list.add(new AdminPOJO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)));
            }
     
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public List<AdminPOJO> purchaseHistory(int customerID){
        List<AdminPOJO> list=new ArrayList<>();
        try{
            String query="{call sp_PurchaseHistoryFetch(?)}";
            CallableStatement cs=con.prepareCall(query);
            cs.setInt(1, customerID);
            ResultSet rs=cs.executeQuery();
            
            while(rs.next()){
                list.add(new AdminPOJO(rs.getString("product_name"),rs.getInt("price")));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return list;
    }
    
    public void newLaptopObj(List<LaptopPOJO> list){
        
        try{
            String query="{call sp_NewLaptopObject(?,?,?,?,?,?,?,?)}";
            CallableStatement cs=con.prepareCall(query);
            
            int result=0;
            for(LaptopPOJO obj:list){
                cs.setString(1, obj.getModelNo());
                cs.setString(2, obj.getScreenSize());
                cs.setString(3, obj.getProcessor());
                cs.setString(4, obj.getOperatingSystem());
                cs.setString(5, obj.getRam());
                cs.setString(6, obj.getHardDisk());
                cs.setInt(7, obj.getPrice());
                cs.setString(8, obj.getImageLocation());
                result=cs.executeUpdate();
            }
            
            if(result>0){
                JOptionPane.showMessageDialog(null, "Data Inserted Successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void newDesktopObj(List<DesktopPOJO> list){
        
        try{
            String query="{call sp_NewDesktopObject(?,?,?,?,?,?,?,?)}";
            CallableStatement cs=con.prepareCall(query);
            
            int result=0;
            for(DesktopPOJO obj:list){
                cs.setString(1, obj.getModelNo());
                cs.setString(2, obj.getScreenSize());
                cs.setString(3, obj.getProcessor());
                cs.setString(4, obj.getOperatingSystem());
                cs.setString(5, obj.getRam());
                cs.setString(6, obj.getHardDisk());
                cs.setInt(7, obj.getPrice());
                cs.setString(8, obj.getImageLocation());
                result=cs.executeUpdate();
            }
            
            if(result>0){
                JOptionPane.showMessageDialog(null, "Data Inserted Successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void newKeyboardObj(List<KeyboardPOJO> list){
        
        try{
            String query="{call sp_NewKeyboardObject(?,?,?,?,?,?)}";
            CallableStatement cs=con.prepareCall(query);
            
            int result=0;
            for(KeyboardPOJO obj:list){
                cs.setString(1, obj.getConnectivity());
                cs.setString(2, obj.getSystemRequirments());
                cs.setString(3, obj.getColor());
                cs.setString(4, obj.getWarrenty());
                cs.setInt(5, obj.getPrice());
                cs.setString(6, obj.getImageLocation());
                result=cs.executeUpdate();
            }
            
            if(result>0){
                JOptionPane.showMessageDialog(null, "Data Inserted Successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void newMouseObj(List<MousePOJO> list){
        
        try{
            String query="{call sp_NewMouseObject(?,?,?,?,?,?)}";
            CallableStatement cs=con.prepareCall(query);
            
            int result=0;
            for(MousePOJO obj:list){
                cs.setString(1, obj.getModelNo());
                cs.setString(2, obj.getConnectivity());
                cs.setString(3, obj.getColor());
                cs.setString(4, obj.getWarrenty());
                cs.setInt(5, obj.getPrice());
                cs.setString(6, obj.getImageLocation());
                result=cs.executeUpdate();
            }
            
            if(result>0){
                JOptionPane.showMessageDialog(null, "Data Inserted Successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
     public void newMonitorObj(List<MonitorPOJO> list){
        
        try{
            String query="{call sp_NewMonitorObject(?,?,?,?,?,?,?,?)}";
            CallableStatement cs=con.prepareCall(query);
            
            int result=0;
            for(MonitorPOJO obj:list){
                cs.setString(1, obj.getModelNo());
                cs.setString(2, obj.getScreenSize());
                cs.setString(3, obj.getResolution());
                cs.setString(4, obj.getResponseTime());
                cs.setString(5, obj.getDisplayColors());
                cs.setString(6, obj.getDisplayFeatures());
                cs.setInt(7, obj.getPrice());
                cs.setString(8, obj.getImageLocation());
                result=cs.executeUpdate();
            }
            
            if(result>0){
                JOptionPane.showMessageDialog(null, "Data Inserted Successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
     
     public void newPrinterObj(List<PrinterPOJO> list){
        
        try{
            String query="{call sp_NewPrinterObject(?,?,?,?,?,?,?,?)}";
            CallableStatement cs=con.prepareCall(query);
            
            int result=0;
            for(PrinterPOJO obj:list){
                cs.setString(1, obj.getModelNo());
                cs.setString(2, obj.getFunctions());
                cs.setString(3, obj.getPrintColours());
                cs.setString(4, obj.getPrintTechnology());
                cs.setString(5, obj.getWirelessCapability());
                cs.setString(6, obj.getMonthlyVolume());
                cs.setInt(7, obj.getPrice());
                cs.setString(8, obj.getImageLocation());
                result=cs.executeUpdate();
            }
            
            if(result>0){
                JOptionPane.showMessageDialog(null, "Data Inserted Successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
