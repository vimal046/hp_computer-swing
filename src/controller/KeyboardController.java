
package controller;

import java.util.List;
import model.DataFetchModel;
import pojo.KeyboardPOJO;

/**
 *
 * @author VIMAL SUKU
 */
public class KeyboardController {
    
    private List<KeyboardPOJO> list;
    private int count=0;

    public KeyboardController() {
        list=new DataFetchModel().keyboardDataFetch();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public KeyboardPOJO keyboardObj(int index){
        KeyboardPOJO obj=list.get(index);
        return obj;
    }
    
    public int showNextKeyBoard(){
        setCount((count+1)%list.size());
        return getCount();
    }
    
    public int showPreviousKeyboard(){
        setCount((count-1+list.size())%list.size());
        return getCount();
    }
    
}
