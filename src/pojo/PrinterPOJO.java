
package pojo;

/**
 *
 * @author VIMAL SUKU
 */
public class PrinterPOJO {
    
    private int printerId;
    private String modelNo;
    private String functions;
    private String printColours;
    private String printTechnology;
    private String wirelessCapability;
    private String monthlyVolume;
    private int price;
    private String imageLocation;

    public PrinterPOJO(int printerId, String modelNo, String functions, String printColours, String printTechnology, String wirelessCapability, String monthlyVolume, int price, String imageLocation) {
        this.printerId = printerId;
        this.modelNo = modelNo;
        this.functions = functions;
        this.printColours = printColours;
        this.printTechnology = printTechnology;
        this.wirelessCapability = wirelessCapability;
        this.monthlyVolume = monthlyVolume;
        this.price = price;
        this.imageLocation = imageLocation;
    }

    public PrinterPOJO(String modelNo, String functions, String printColours, String printTechnology, String wirelessCapability, String monthlyVolume, int price, String imageLocation) {
        this.modelNo = modelNo;
        this.functions = functions;
        this.printColours = printColours;
        this.printTechnology = printTechnology;
        this.wirelessCapability = wirelessCapability;
        this.monthlyVolume = monthlyVolume;
        this.price = price;
        this.imageLocation = imageLocation;
    }

    public int getPrinterId() {
        return printerId;
    }

    public void setPrinterId(int printerId) {
        this.printerId = printerId;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String functions) {
        this.functions = functions;
    }

    public String getPrintColours() {
        return printColours;
    }

    public void setPrintColours(String printColours) {
        this.printColours = printColours;
    }

    public String getPrintTechnology() {
        return printTechnology;
    }

    public void setPrintTechnology(String printTechnology) {
        this.printTechnology = printTechnology;
    }

    public String getWirelessCapability() {
        return wirelessCapability;
    }

    public void setWirelessCapability(String wirelessCapability) {
        this.wirelessCapability = wirelessCapability;
    }

    public String getMonthlyVolume() {
        return monthlyVolume;
    }

    public void setMonthlyVolume(String monthlyVolume) {
        this.monthlyVolume = monthlyVolume;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }
}
