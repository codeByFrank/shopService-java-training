package de.neuefische;

import java.util.HashMap;
import java.util.Map;


public class ProductRepo {

    private final Map<Integer, Product> allProducts = new HashMap<>();

    public void addProduct(Product product) {
        allProducts.put(product.id(), product);
    }

    public void removeProductById(int id) {
        allProducts.remove(id);
    }

    public Product getProductById(int id) {
        return allProducts.getOrDefault(id, null);
    }

    public Map<Integer, Product> getAllProducts() {
        return allProducts;
    }
}
