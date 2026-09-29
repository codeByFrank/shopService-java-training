package de.neuefische;

import java.util.HashMap;
import java.util.Map;

public class OrderListRepo implements OrderRepo {
    private final Map<Integer, Order> allOrders = new HashMap<>();

    public void addOrder(Order order) {
        allOrders.put(order.id(), order);
    }

    public void removeOrderById(int id) {
        allOrders.remove(id);
    }

    public Order getOrderById(int id) {
        return allOrders.getOrDefault(id, null);
    }

    public Map<Integer, Order> getAllOrders() {
        return allOrders;
    }
}
