package de.neuefische;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void placeOrder() throws Exception {
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderMapRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        Product product = new Product(1, "Lamp", 2.99);
        productRepo.addProduct(product);

        shopService.placeOrder(10, 1, 2);

        assertEquals(new Order(10, product, 2, OrderStatus.PROCESSING), orderRepo.getOrderById(10));
    }

    @Test
    void updateOrderQuantity() throws Exception {
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderMapRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        Product product = new Product(1, "Lamp", 2.99);
        productRepo.addProduct(product);
        shopService.placeOrder(10, 1, 2);

        shopService.updateOrderQuantity(10, 5);

        assertEquals(new Order(10, product, 5, OrderStatus.PROCESSING), orderRepo.getOrderById(10));
    }

    @Test
    void getOrdersByStatus_shouldReturnOnlyOrdersWithMatchingStatus() {
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderMapRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        Product product = new Product(1, "Lamp", 2.99);
        Order processingOrder =
                new Order(10, product, 2, OrderStatus.PROCESSING);
        Order completedOrder =
                new Order(11, product, 1, OrderStatus.COMPLETED);

        orderRepo.addOrder(processingOrder);
        orderRepo.addOrder(completedOrder);

        assertEquals(
                List.of(processingOrder),
                shopService.getOrdersByStatus(OrderStatus.PROCESSING)
        );
    }

    @Test
    void placeOrder_shouldThrowException_whenProductDoesNotExist() {
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderMapRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        assertThrows(Exception.class, () -> shopService.placeOrder(10, 999, 2));
    }

    @Test
    void updateOrder_shouldChangeStatus() {
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderMapRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        Product product = new Product(1, "Lamp", 2.99);
        Order order = new Order(10, product, 2, OrderStatus.PROCESSING);
        orderRepo.addOrder(order);

        shopService.updateOrder(10, OrderStatus.IN_DELIVERY);

        assertEquals(
                new Order(10, product, 2, OrderStatus.IN_DELIVERY),
                orderRepo.getOrderById(10)
        );
    }
}