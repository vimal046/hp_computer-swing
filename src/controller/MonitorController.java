
package controller;

import java.util.List;
import model.DataFetchModel;
import pojo.MonitorPOJO;

/**
 *
 * @author VIMAL SUKU
 */
public class MonitorController {
    private List<MonitorPOJO> list;
    private int count=0;

    public MonitorController() {
        list=new DataFetchModel().monitorDataFetch();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public MonitorPOJO  monitorObj(int index){
        MonitorPOJO obj=list.get(index);
        return obj;
    }
    
    public int showNextMonitor(){
        setCount((count+1)%list.size());
        return getCount();
    }
    
    public int showPreviousMonitor(){
        setCount((count-1+list.size())%list.size());
        return getCount();
    }
    
}
