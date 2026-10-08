package de.neuefische;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    @Test
    void addProduct() {
        ProductRepo productRepo = new ProductRepo();
        Product product = new Product(1, "Lamp", 2.99);

        productRepo.addProduct(product);

        assertEquals(Optional.of(product), productRepo.getProductById(1));
    }

    @Test
    void removeProductById() {
        ProductRepo productRepo = new ProductRepo();
        productRepo.addProduct(new Product(1, "Lamp", 2.99));

        productRepo.removeProductById(1);

        assertEquals(Optional.empty(), productRepo.getProductById(1));
    }

    @Test
    void getProductById() {
        ProductRepo productRepo = new ProductRepo();
        Product product = new Product(1, "Lamp", 2.99);
        productRepo.addProduct(product);

        assertEquals(Optional.of(product), productRepo.getProductById(1));
    }

    @Test
    void getProductById_shouldReturnEmpty_whenProductDoesNotExist() {
        ProductRepo productRepo = new ProductRepo();

        assertEquals(Optional.empty(), productRepo.getProductById(999));
    }

    @Test
    void getAllProducts() {
        ProductRepo productRepo = new ProductRepo();
        Product firstProduct = new Product(1, "Lamp", 2.99);
        Product secondProduct = new Product(2, "Chair", 19.99);

        productRepo.addProduct(firstProduct);
        productRepo.addProduct(secondProduct);

        assertEquals(2, productRepo.getAllProducts().size());
        assertEquals(firstProduct, productRepo.getAllProducts().get(0));
        assertEquals(secondProduct, productRepo.getAllProducts().get(1));
    }
}