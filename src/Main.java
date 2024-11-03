import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Product cheese = new Product("Cheese", 10.0, 10, true, LocalDate.of(2025, Calendar.NOVEMBER, 10));
        Product tv = new ShippableProduct("TV", 5300.0, 5, false, null, 3000.0);
        Product scratchCard = new Product("Scratch Card", 5.0, 50, false, null);

        Customer ayman = new Customer("Ayman", 10000.0);

        ShippingService shippingService = new ShippingService(.05);

        ayman.addToCart(cheese, 2);
        ayman.addToCart(tv, 1);
        ayman.addToCart(scratchCard, 10);

        ayman.checkout(shippingService);
    }
}