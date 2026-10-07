package de.neuefische;

import java.util.List;

public class ShopService {
    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public void placeOrder(int orderId, int productId, int quantity) {
        Product product = productRepo.getProductById(productId);

        if (product == null) {
            return;
        }

        Order order = new Order(orderId, product, quantity, OrderStatus.PROCESSING);
        orderRepo.addOrder(order);
    }

    public void updateOrderQuantity(int orderId, int newQuantity) {
        Order order = orderRepo.getOrderById(orderId);

        if (order == null) {
            return;
        }

        Order updatedOrder = new Order(order.id(), order.product(), newQuantity, order.status());
        orderRepo.updateOrder(updatedOrder);
    }

    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orderRepo.getAllOrders()
                .stream()
                .filter(order -> order.status() == status)
                .toList();
    }
}
