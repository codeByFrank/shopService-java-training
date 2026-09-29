package de.neuefische;

import java.util.Map;

public interface OrderRepo {

    public void addOrder(Order order);

    public void removeOrderById(int id);

    public Order getOrderById(int id);

    public Map<Integer, Order> getAllOrders();
}
