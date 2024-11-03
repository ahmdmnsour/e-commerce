import java.time.LocalDate;
import java.util.Date;

public class ShippableProduct extends Product implements Shippable {
    private double weight;

    public ShippableProduct(String name, double price, int quantity, boolean isExpiring, LocalDate expiryDate, double weight) {
        super(name, price, quantity, isExpiring, expiryDate);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
