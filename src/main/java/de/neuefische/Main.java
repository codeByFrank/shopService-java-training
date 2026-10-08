package de.neuefische;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";

    static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderMapRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        Scanner scanner = new Scanner(System.in);

        productRepo.addProduct(new Product(1, "Lamp", 2.99));
        productRepo.addProduct(new Product(2, "Chair", 19.99));
        productRepo.addProduct(new Product(3, "Book", 7.99));

        try {
            shopService.placeOrder(1, 1, 2);
            shopService.placeOrder(2, 2, 1);
            shopService.placeOrder(3, 3, 4);
        } catch (Exception e) {
            System.out.println(RED + e.getMessage() + RESET);
        }

        for (boolean running = true; running; ) {
            System.out.println("1 : show products");
            System.out.println("2 : add product");
            System.out.println("3 : remove product");
            System.out.println("4 : place order");
            System.out.println("5 : show orders");
            System.out.println("q : close\n");
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
                System.out.println(GREEN + "Product added." + RESET);
            }
            else if (choice.equals("3")) {
                System.out.print("Product id: ");
                int id = Integer.parseInt(scanner.nextLine());

                productRepo.removeProductById(id);
                System.out.println(RED + "Product removed." + RESET);
            }
            else if (choice.equals("4")) {
                System.out.print("Order id: ");
                int orderId = Integer.parseInt(scanner.nextLine());

                System.out.print("Product id: ");
                int productId = Integer.parseInt(scanner.nextLine());

                System.out.print("Quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());

                try {
                    shopService.placeOrder(orderId, productId, quantity);
                    System.out.println(GREEN + "Order was placed." + RESET);
                } catch (Exception e) {
                    System.out.println(RED + e.getMessage() + RESET);
                }
            }
            else if (choice.equals("5")) {
                for (Order order : orderRepo.getAllOrders()) {
                    System.out.println(order);
                }
            }
            else if (choice.equals("q")) {
                running = false;
            }
        }


        scanner.close();
    }
}
