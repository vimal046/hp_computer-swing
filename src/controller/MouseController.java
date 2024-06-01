
package controller;

import java.util.List;
import model.DataFetchModel;
import pojo.MousePOJO;
/**
 *
 * @author VIMAL SUKU
 */
public class MouseController {
    private List<MousePOJO> list;
    private int count=0;

    public MouseController() {
        list=new DataFetchModel().mouseDataFetch();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public MousePOJO mouseObj(int index){
        MousePOJO obj=list.get(index);
        return obj;
    }
    
    public int showNextMouse(){
        setCount((count+1)%list.size());
        return getCount();
    }
    
    public int showPreviousMouse(){
        setCount((count-1+list.size())%list.size());
        return getCount();
    }
    
}
