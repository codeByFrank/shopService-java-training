package de.neuefische;

public record Order(int id, Product product, int quantity, OrderStatus status) {

    public double getTotalPrice() {
        return product.price() * quantity;
    }


}
