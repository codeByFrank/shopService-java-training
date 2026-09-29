package de.neuefische;

public class ShopService {
    private final ProductRepo productRepo;
    private final OrderListRepo orderListRepo;

    public ShopService(ProductRepo productRepo, OrderListRepo orderListRepo) {
        this.productRepo = productRepo;
        this.orderListRepo = orderListRepo;
    }

    public placeOrder(int orderId, int productId, int quantity) {
        Product product = productRepo.getProductById(productId);

        if (product == null) {
            System.out.println("Product not available!");
            return;
        }

        Order order = new Order(orderId, product, quantity);
        orderListRepo.addOrder(order);
    }
}
