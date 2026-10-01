package de.neuefische;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderListRepo implements OrderRepo {
    private final List<Order> allOrders = new ArrayList<>();

    @Override
    public void addOrder(Order order) {
        allOrders.add(order);
    }

    @Override
    public void removeOrderById(int id) {
        for (int i = 0; i < allOrders.size(); i++) {
            if (allOrders.get(i).id() == id) {
                allOrders.remove(i);
                return;
            }
        }
    }

    @Override
    public Order getOrderById(int id) {
        for (Order order : allOrders) {
            if (order.id() == id) {
                return order;
            }
        }

        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return allOrders;
    }

    @Override
    public void updateOrder(Order updatedOrder) {
        for (int i = 0; i < allOrders.size(); i++) {
            if (allOrders.get(i).id() == updatedOrder.id()) {
                allOrders.set(i, updatedOrder);
                return;
            }
        }
    }
}
