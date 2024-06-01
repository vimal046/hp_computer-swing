
package controller;

import java.util.List;
import model.DataFetchModel;
import pojo.DesktopPOJO;


/**
 *
 * @author VIMAL SUKU
 */
public class DesktopController {
    
    private List<DesktopPOJO> list;
    private int count=0;

    public DesktopController() {  
        list=new DataFetchModel().desktopDataFetch();
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
    
    public DesktopPOJO desktopObj(int index){
        DesktopPOJO obj=list.get(index);
        return obj;
    }
    
    public int showNextDesktop(){
        setCount((count+1)%list.size());
        return getCount();
    }
    
    public int showPreviousDesktop(){
        setCount((count-1+list.size())%list.size());
        return getCount();
    }
}
