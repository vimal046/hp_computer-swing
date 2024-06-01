
package pojo;

/**
 *
 * @author VIMAL SUKU
 */
public class MousePOJO {
    private int mouseId;
    private String modelNo;
    private String connectivity;
    private String color;
    private String warrenty;
    private int price;
    private String imageLocation;

    public MousePOJO(int mouseId, String modelNo, String connectivity, String color, String warrenty, int price, String imageLocation) {
        this.mouseId = mouseId;
        this.modelNo = modelNo;
        this.connectivity = connectivity;
        this.color = color;
        this.warrenty = warrenty;
        this.price = price;
        this.imageLocation = imageLocation;
    }

    public MousePOJO(String modelNo, String connectivity, String color, String warrenty, int price, String imageLocation) {
        this.modelNo = modelNo;
        this.connectivity = connectivity;
        this.color = color;
        this.warrenty = warrenty;
        this.price = price;
        this.imageLocation = imageLocation;
    }

    public int getMouseId() {
        return mouseId;
    }

    public void setMouseId(int mouseId) {
        this.mouseId = mouseId;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(String connectivity) {
        this.connectivity = connectivity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWarrenty() {
        return warrenty;
    }

    public void setWarrenty(String warrenty) {
        this.warrenty = warrenty;
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
