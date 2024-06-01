package model;

import java.sql.*;
import pojo.*;
import java.util.*;

/**
 *
 * @author VIMAL SUKU
 */
public class DataFetchModel {

    Connection con = null;

    public DataFetchModel() {

        con = new SQLConnection().getConnection();
        
    }

    public List<LaptopPOJO> laptopDataFetch() {
        List<LaptopPOJO> list = new ArrayList<>();
        String query = "{call sp_fetchLaptopTable}";
        
        try {
            CallableStatement cs = con.prepareCall(query);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()) {
                list.add(new LaptopPOJO(rs.getInt(2), rs.getString("model_no"), rs.getString("screen_size"), rs.getString("processor"), rs.getString("operating_system"), rs.getString("ram"), rs.getString("hard_disk"), rs.getInt("price"), rs.getString("image_location")));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        
        
        return list;

    }
    
   public List<KeyboardPOJO> keyboardDataFetch(){
       List<KeyboardPOJO> list=new ArrayList<>();
       String query="{call sp_fetchKeyboardTable}";
       
       try{
           CallableStatement cs=con.prepareCall(query);
           ResultSet rs=cs.executeQuery();
           
           while(rs.next()){
          
               list.add(new KeyboardPOJO(rs.getInt(2),rs.getString("connectivity"),rs.getString("minimum_system_requirments"),rs.getString("colour"),rs.getString("warrenty"),rs.getInt("price"),rs.getString("image_location")));
           }
           
       }catch(SQLException e){
           e.printStackTrace();
       }
       
      
       
       return list;
   } 
    
    public List<MonitorPOJO> monitorDataFetch(){
        
        List<MonitorPOJO> list=new ArrayList<>();
        String query="{call sp_fetchMonitorTable}";
        
        try{
            
           CallableStatement cs=con.prepareCall(query);
           ResultSet rs=cs.executeQuery();
           
           while(rs.next()){
               
    
               list.add(new MonitorPOJO(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10)));
           }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return list;
    }
    
    public List<MousePOJO> mouseDataFetch(){
        List<MousePOJO> list=new ArrayList<>();
        String query="{call sp_fetchMouseTable}";
        
        try{
            CallableStatement cs=con.prepareCall(query);
            ResultSet rs=cs.executeQuery();
            
            while(rs.next()){
                
                
                list.add(new MousePOJO(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8)));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return list;
    }
    
    public List<PrinterPOJO> printDataFetch(){
        List<PrinterPOJO> list=new ArrayList<>();
        String query="{call sp_fetchPrinterTable}";
        
        try{
            CallableStatement cs=con.prepareCall(query);
            ResultSet rs=cs.executeQuery();
            
            while(rs.next()){
  
                
               list.add(new PrinterPOJO(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10)));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public List<DesktopPOJO> desktopDataFetch(){
        List<DesktopPOJO> list=new ArrayList<>();
        String query="{call sp_fetchDesktopTable}";
        
        try{
            CallableStatement cs=con.prepareCall(query);
            ResultSet rs=cs.executeQuery();
            
            while(rs.next()){
            
 list.add(new DesktopPOJO(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(10),rs.getInt(9)));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
  

}
