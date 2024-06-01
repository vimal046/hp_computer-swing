
package pojo;

/**
 *
 * @author VIMAL SUKU
 */
public class MonitorPOJO {
    
    private int monitorId;
    private String modelNo;
    private String screenSize;
    private String resolution;
    private String responseTime;
    private String displayColors;
    private String displayFeatures;
    private int price;
    private String imageLocation;

    public MonitorPOJO(int monitorId, String modelNo, String screenSize, String resolution, String responseTime, String displayColors, String displayFeatures, int price, String imageLocation) {
        this.monitorId = monitorId;
        this.modelNo = modelNo;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.responseTime = responseTime;
        this.displayColors = displayColors;
        this.displayFeatures = displayFeatures;
        this.price = price;
        this.imageLocation = imageLocation;
    }

    public MonitorPOJO(String modelNo, String screenSize, String resolution, String responseTime, String displayColors, String displayFeatures, int price, String imageLocation) {
        this.modelNo = modelNo;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.responseTime = responseTime;
        this.displayColors = displayColors;
        this.displayFeatures = displayFeatures;
        this.price = price;
        this.imageLocation = imageLocation;
    }

    public int getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(int monitorId) {
        this.monitorId = monitorId;
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

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getDisplayColors() {
        return displayColors;
    }

    public void setDisplayColors(String displayColors) {
        this.displayColors = displayColors;
    }

    public String getDisplayFeatures() {
        return displayFeatures;
    }

    public void setDisplayFeatures(String displayFeatures) {
        this.displayFeatures = displayFeatures;
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
