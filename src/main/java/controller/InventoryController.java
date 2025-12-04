package controller;

import java.util.List;
import java.util.Scanner;

import model.Product;
import service.ProductService;

public class InventoryController {

    private ProductService service = new ProductService();
    private Scanner sc = new Scanner(System.in);

    public void menu() {

        while (true) {
            System.out.println("\n------ Inventory Management ------");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    view();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    delete();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void add() {
        System.out.print("Enter Product Name: ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        service.addProduct(new Product(name, price, qty));
    }

    private void view() {
        List<Product> list = service.getAllProducts();
        for (Product p : list)
            System.out.println(p);
    }

    private void search() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product p = service.getProduct(id);

        if (p != null)
            System.out.println(p);
        else
            System.out.println("❌ Product not found!");
    }

    private void update() {
        System.out.print("Enter Product ID to update: ");
        int id = sc.nextInt();

        Product p = service.getProduct(id);
        if (p == null) {
            System.out.println("❌ Product not found!");
            return;
        }

        sc.nextLine();
        System.out.print("Enter new Name: ");
        String name = sc.nextLine();

        System.out.print("Enter new Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter new Quantity: ");
        int qty = sc.nextInt();

        service.updateProduct(new Product(id, name, price, qty));
    }

    private void delete() {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();

        service.deleteProduct(id);
    }
}