
package pojo;

import java.util.Objects;

/**
 *
 * @author VIMAL SUKU
 */
public class LaptopPOJO {

    
    
    private int laptopId;
    private String modelNo;
    private String screenSize;
    private String processor;
    private String operatingSystem;
    private String ram;
    private String hardDisk;
    private int price;
    private String imageLocation;

    public LaptopPOJO(String modelNo, String screenSize, String processor, String operatingSystem, String ram, String hardDisk, int price, String imageLocation) {
        this.modelNo = modelNo;
        this.screenSize = screenSize;
        this.processor = processor;
        this.operatingSystem = operatingSystem;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.price = price;
        this.imageLocation = imageLocation;
    }
    

    public LaptopPOJO(int laptopId,String modelNo, String screenSize, String processor, String operatingSystem, String ram, String hardDisk, int price, String imageLocation) {
        this.laptopId=laptopId;
        this.modelNo = modelNo;
        this.screenSize = screenSize;
        this.processor = processor;
        this.operatingSystem = operatingSystem;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.price = price;
        this.imageLocation = imageLocation;
    }
    
    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
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
    
     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LaptopPOJO laptop = (LaptopPOJO) obj;
        return price == laptop.price && laptopId==laptop.laptopId &&
               Objects.equals(modelNo, laptop.modelNo) &&
               Objects.equals(screenSize, laptop.screenSize) &&
               Objects.equals(processor, laptop.processor) &&
               Objects.equals(operatingSystem, laptop.operatingSystem) &&
               Objects.equals(ram, laptop.ram) &&
               Objects.equals(hardDisk, laptop.hardDisk) &&
               Objects.equals(imageLocation, laptop.imageLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelNo, screenSize, processor, operatingSystem, ram, hardDisk, price, imageLocation);
    }
     @Override
    public String toString() {
        return "LaptopPOJO{" +
                "laptopId=" + laptopId +
                ", modelNo='" + modelNo + '\'' +
                ", screenSize='" + screenSize + '\'' +
                ", processor='" + processor + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", ram='" + ram + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                ", price=" + price +
                ", imageLocation='" + imageLocation + '\'' +
                '}';
    }
}
