package de.neuefische;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<Product> getProductById(int id) {
        for (Product product : allProducts) {
            if (product.id() == id) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public List<Product> getAllProducts() {
        return allProducts;
    }
}
