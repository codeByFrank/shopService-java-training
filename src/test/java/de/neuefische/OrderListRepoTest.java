package de.neuefische;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class OrderListRepoTest {

    @Test
    void addOrder() {
        OrderListRepo orderListRepo = new OrderListRepo();
        Product product = new Product(1, "Lamp", 2.99);
        Order order = new Order(10, product, 2, OrderStatus.PROCESSING, Instant.now());

        orderListRepo.addOrder(order);

        assertEquals(order, orderListRepo.getOrderById(10));
    }

    @Test
    void removeOrderById() {
        OrderListRepo orderListRepo = new OrderListRepo();
        Product product = new Product(1, "Lamp", 2.99);
        Order order = new Order(10, product, 2, OrderStatus.PROCESSING, Instant.now());
        orderListRepo.addOrder(order);

        orderListRepo.removeOrderById(10);

        assertNull(orderListRepo.getOrderById(10));
    }

    @Test
    void getOrderById() {
        OrderListRepo orderListRepo = new OrderListRepo();
        Product product = new Product(1, "Lamp", 2.99);
        Order order = new Order(10, product, 2, OrderStatus.PROCESSING, Instant.now());
        orderListRepo.addOrder(order);

        assertEquals(order, orderListRepo.getOrderById(10));
    }

    @Test
    void getAllOrders() {
        OrderListRepo orderListRepo = new OrderListRepo();
        Product product = new Product(1, "Lamp", 2.99);
        Order firstOrder = new Order(10, product, 2, OrderStatus.PROCESSING, Instant.now());
        Order secondOrder = new Order(11, product, 1, OrderStatus.PROCESSING, Instant.now());

        orderListRepo.addOrder(firstOrder);
        orderListRepo.addOrder(secondOrder);

        assertEquals(2, orderListRepo.getAllOrders().size());
        assertEquals(firstOrder, orderListRepo.getAllOrders().get(0));
        assertEquals(secondOrder, orderListRepo.getAllOrders().get(1));
    }

    @Test
    void updateOrder() {
        OrderListRepo orderListRepo = new OrderListRepo();
        Product product = new Product(1, "Lamp", 2.99);
        Instant orderTimestamp = Instant.now();

        Order originalOrder = new Order(10, product, 2, OrderStatus.PROCESSING, orderTimestamp);
        Order updatedOrder = new Order(10, product, 5, OrderStatus.PROCESSING, orderTimestamp);
        orderListRepo.addOrder(originalOrder);

        orderListRepo.updateOrder(updatedOrder);

        assertEquals(updatedOrder, orderListRepo.getOrderById(10));
    }
}