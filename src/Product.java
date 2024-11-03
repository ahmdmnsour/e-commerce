import java.time.LocalDate;
import java.util.Date;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private boolean isExpiring;
    private LocalDate expiryDate;

    public Product() {}

    public Product(String name, double price, int quantity, boolean isExpiring, LocalDate expiryDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isExpiring = isExpiring;
        this.expiryDate = isExpiring ? expiryDate : null;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
