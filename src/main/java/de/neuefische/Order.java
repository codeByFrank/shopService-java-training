package de.neuefische;

import lombok.With;

public record Order(int id, Product product, int quantity, @With OrderStatus status) {

    public double getTotalPrice() {
        return product.price() * quantity;
    }


}
