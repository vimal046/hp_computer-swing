package pojo;

import java.util.Objects;

/**
 *
 * @author VIMAL SUKU
 */
public class BillPair {
    
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public BillPair(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
     @Override
    public String toString() {
        return "Name: " + name + ", Price: " + price;
    }
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillPair other = (BillPair) o;
        return Objects.equals(name, other.name) && price == other.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
