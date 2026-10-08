package de.neuefische;

import lombok.With;

import java.time.Instant;

public record Order(int id, Product product, int quantity, @With OrderStatus status, Instant timestamp) {

    public double getTotalPrice() {
        return product.price() * quantity;
    }


}
