package de.neuefische;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderMapRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        Scanner scanner = new Scanner(System.in);

        productRepo.addProduct(new Product(1, "Lamp", 2.99));

        for (boolean running = true; running; ) {
            System.out.println("1 : show products");
            System.out.println("2 : add product");
            System.out.println("3 : remove product");
            System.out.println("q : close");
            System.out.print("choice: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                for (Product product : productRepo.getAllProducts()) {
                    System.out.println(product);
                }
            }
            else if (choice.equals("2")) {
                System.out.print("Product id: ");
                int id = Integer.parseInt(scanner.nextLine());

                System.out.print("Product name: ");
                String name = scanner.nextLine();

                System.out.print("Product price: ");
                double price = Double.parseDouble(scanner.nextLine());

                productRepo.addProduct(new Product(id, name, price));
                System.out.println("Product added");
            }
            else if (choice.equals("3")) {
                System.out.print("Product id: ");
                int id = Integer.parseInt(scanner.nextLine());

                productRepo.removeProductById(id);
                System.out.println("Product removed");
            }
            else if (choice.equals("q")) {
                running = false;
            }
        }


        scanner.close();
    }
}
