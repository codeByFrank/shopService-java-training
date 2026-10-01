package de.neuefische;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void placeOrder() {
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderMapRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        Product product = new Product(1, "Lamp", 2.99);
        productRepo.addProduct(product);

        shopService.placeOrder(10, 1, 2);

        assertEquals(new Order(10, product, 2), orderRepo.getOrderById(10));
    }

    @Test
    void updateOrderQuantity() {
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderMapRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        Product product = new Product(1, "Lamp", 2.99);
        productRepo.addProduct(product);
        shopService.placeOrder(10, 1, 2);

        shopService.updateOrderQuantity(10, 5);

        assertEquals(new Order(10, product, 5), orderRepo.getOrderById(10));
    }
}