public class ShippingService {
    private double pricePerUnitWeight;

    public ShippingService(double pricePerUnitWeight) {
        this.pricePerUnitWeight = pricePerUnitWeight;
    }

    public double calculateShippingFees(Cart cart) {
        double shippingFees = 0;
        for (CartItem item : cart.getItems())
            if (item.getProduct() instanceof Shippable)
                shippingFees += ((Shippable) item.getProduct()).getWeight() * pricePerUnitWeight;
        return shippingFees;
    }

    public void printShippingNotice(Cart cart) {
        System.out.println("**       Shipment notice       **");
        double totalWeight = 0;
        for (CartItem item : cart.getItems())
            if (item.getProduct() instanceof Shippable) {
                double weight = ((Shippable) item.getProduct()).getWeight() * item.getQuantity();
                totalWeight += weight;
                System.out.printf("%2dx %-17s %10.0fg\n", item.getQuantity(), item.getProduct().getName(), weight);
            }
        System.out.printf("Total package weight %10.1fkg\n\n", totalWeight / 1000);
    }
}
