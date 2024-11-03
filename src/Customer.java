public class Customer {
    private String name;
    private double balance;
    private Cart cart;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
    }

    public void addToCart(Product product, int quantity) {
        cart.addItem(product, quantity);
    }

    public void checkout(ShippingService shippingService) {
        if (cart.isEmpty()) throw new IllegalStateException("Cart is empty");

        double subtotal = cart.calculateSubtotal();
        double shippingFees = shippingService.calculateShippingFees(cart);
        double total = subtotal + shippingFees;

        if (balance < total) throw new IllegalStateException("Insufficient balance");

        for (CartItem item : cart.getItems())
            item.getProduct().reduceQuantity(item.getQuantity());

        balance -= total;

        if (shippingFees > 0)
            shippingService.printShippingNotice(cart);

        System.out.println("**       Checkout receipt      **");
        for (CartItem item : cart.getItems())
            System.out.printf("%2dx %-18s %10.2f\n", item.getQuantity(), item.getProduct().getName(), item.getTotalPrice());
        System.out.println("---------------------------------");
        System.out.printf("%-22s %10.2f\n", "Subtotal", subtotal);
        System.out.printf("%-22s %10.2f\n", "Shipping", shippingFees);
        System.out.printf("%-22s %10.2f\n", "Amount", total);
    }
}
