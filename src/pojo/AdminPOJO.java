
package pojo;

/**
 *
 * @author VIMAL SUKU
 */
public class AdminPOJO {
    private int customerId;
    private String name;
    private String mbile;
    private int billAmount;
    private String date;
    private String productName;
    private int price;

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public AdminPOJO(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    public AdminPOJO(int customerId, String name, String mbile, int billAmount, String date) {
        this.customerId = customerId;
        this.name = name;
        this.mbile = mbile;
        this.billAmount = billAmount;
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getMbile() {
        return mbile;
    }

    public int getBillAmount() {
        return billAmount;
    }

    public String getDate() {
        return date;
    }
}
