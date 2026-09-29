package de.neuefische;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderMapRepo implements OrderRepo  {
    private final HashMap<Integer, Order> orders = new HashMap<>();

    @Override
    public void addOrder(Order order) {
        orders.put(order.id(), order);
    }

    @Override
    public void removeOrderById(int id) {
        orders.remove(id);
    }

    @Override
    public Order getOrderById(int id) {
        return orders.getOrDefault(id, null);
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }
}
