
package pojo;

/**
 *
 * @author VIMAL SUKU
 */
public class KeyboardPOJO {
    private int keyboardId;
    private String connectivity;
    private String systemRequirments;
    private String color;
    private String warrenty;
    private int price;
    private String imageLocation;

    public KeyboardPOJO(int keyboardId, String connectivity, String systemRequirments, String color, String warrenty, int price, String imageLocation) {
        this.keyboardId = keyboardId;
        this.connectivity = connectivity;
        this.systemRequirments = systemRequirments;
        this.color = color;
        this.warrenty = warrenty;
        this.price = price;
        this.imageLocation = imageLocation;
    }

    public KeyboardPOJO(String connectivity, String systemRequirments, String color, String warrenty, int price, String imageLocation) {
        this.connectivity = connectivity;
        this.systemRequirments = systemRequirments;
        this.color = color;
        this.warrenty = warrenty;
        this.price = price;
        this.imageLocation = imageLocation;
    }

    public int getKeyboardId() {
        return keyboardId;
    }

    public void setKeyboardId(int keyboardId) {
        this.keyboardId = keyboardId;
    }

    public String getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(String connectivity) {
        this.connectivity = connectivity;
    }

    public String getSystemRequirments() {
        return systemRequirments;
    }

    public void setSystemRequirments(String systemRequirments) {
        this.systemRequirments = systemRequirments;
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
    
     @Override
    public String toString() {
        return "Laptop{" +
                "keyboardId=" + keyboardId +
                ", connectivity='" + connectivity + '\'' +
                ", systemRequirements='" + systemRequirments + '\'' +
                ", color='" + color + '\'' +
                ", warranty='" + warrenty + '\'' +
                ", price=" + price +
                ", imageLocation='" + imageLocation + '\'' +
                '}';
    }
    
}
