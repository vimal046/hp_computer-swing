
package pojo;

/**
 *
 * @author VIMAL SUKU
 */
public class DesktopPOJO {
    
    private int desktopId;
    private String modelNo;
    private String screenSize;
    private String processor;
    private String operatingSystem;
    private String ram;
    private String hardDisk;
    private String imageLocation;
    private int price;

    public DesktopPOJO(int desktopId, String modelNo, String screenSize, String processor, String operatingSystem, String ram, String hardDisk, String imageLocation, int price) {
        this.desktopId = desktopId;
        this.modelNo = modelNo;
        this.screenSize = screenSize;
        this.processor = processor;
        this.operatingSystem = operatingSystem;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.imageLocation = imageLocation;
        this.price = price;
    }

    public DesktopPOJO(String modelNo, String screenSize, String processor, String operatingSystem, String ram, String hardDisk, String imageLocation, int price) {
        this.modelNo = modelNo;
        this.screenSize = screenSize;
        this.processor = processor;
        this.operatingSystem = operatingSystem;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.imageLocation = imageLocation;
        this.price = price;
    }

    public int getDesktopId() {
        return desktopId;
    }

    public void setDesktopId(int desktopId) {
        this.desktopId = desktopId;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
