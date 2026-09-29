package de.neuefische;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductRepo {

    private final List<Product> allProducts = new ArrayList<>();

    public void addProduct(Product product) {
        allProducts.add(product);
    }

    public void removeProductById(int id) {
        for (int i = 0; i < allProducts.size(); i++) {
            if (allProducts.get(i).id() == id) {
                allProducts.remove(i);
                return;
            }
        }
    }

    public Product getProductById(int id) {
        for (Product product : allProducts) {
            if (product.id() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getAllProducts() {
        return allProducts;
    }
}
