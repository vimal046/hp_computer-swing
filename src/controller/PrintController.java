
package controller;

import java.util.List;
import model.DataFetchModel;
import pojo.PrinterPOJO;

/**
 *
 * @author VIMAL SUKU
 */
public class PrintController {
    
    private List<PrinterPOJO> list;
    private int count=0;

    public PrintController() {
        list=new DataFetchModel().printDataFetch();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public PrinterPOJO printerObj(int index){
        PrinterPOJO obj=list.get(index);
        return obj;
    }
    public int showNextPrinter(){
        setCount((count+1)%list.size());
        return getCount();
    }
    public int showPreviousPrinter(){
        setCount((count-1+list.size())%list.size());
        return getCount();
    }
}
