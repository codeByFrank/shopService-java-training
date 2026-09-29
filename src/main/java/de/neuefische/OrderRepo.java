package de.neuefische;

import java.util.List;
import java.util.Map;

public interface OrderRepo {

    public void addOrder(Order order);

    public void removeOrderById(int id);

    public Order getOrderById(int id);

    public List<Order> getAllOrders();
}
