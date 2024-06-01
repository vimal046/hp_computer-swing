package controller;


import java.util.*;
import model.DataFetchModel;
import pojo.LaptopPOJO;

/**
 *
 * @author VIMAL SUKU
 */
public class LaptopController {
    
    List<LaptopPOJO> list;
    private int count = 0;
    
    // Constructor
    public LaptopController() {
        list = new DataFetchModel().laptopDataFetch();
       
    }
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }  
    
    public LaptopPOJO lapObject(int index){
         
        LaptopPOJO obj=list.get(index);
        
        return obj;

    }
    
    public int showNextLaptop(){
        setCount((count+1)%list.size());
        return getCount();
    }
    
    public int showPreviousLaptop(){   
        setCount((count-1+list.size())%list.size());
        return getCount();
    }
    
    

}
