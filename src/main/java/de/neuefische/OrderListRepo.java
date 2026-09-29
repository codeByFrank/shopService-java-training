package de.neuefische;

import java.util.HashMap;
import java.util.Map;

public class OrderListRepo {
    private final Map<Integer, Order> allOrders = new HashMap<>();

    public void addProduct(Order order) {
        allOrders.put(order.id(), order);
    }

    public void removeProductById(int id) {
        allOrders.remove(id);
    }

    public Order getOrderById(int id) {
        return allOrders.getOrDefault(id, null);
    }

    public Map<Integer, Order> getAllOrders() {
        return allOrders;
    }
}
