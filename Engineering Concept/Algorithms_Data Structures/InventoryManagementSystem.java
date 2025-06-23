import java.util.HashMap;
import java.util.Scanner;

public class InventoryManagementSystem {

    // Product class
    static class Product {
        private int productId;
        private String productName;
        private int quantity;
        private double price;

        public Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String toString() {
            return "ProductID: " + productId + ", Name: " + productName + ", Quantity: " + quantity + ", Price: $" + price;
        }
    }

    // Inventory class
    static class Inventory {
        private HashMap<Integer, Product> products = new HashMap<>();

        public void addProduct(Product product) {
            if (products.containsKey(product.getProductId())) {
                System.out.println("Product already exists. Use updateProduct() to modify it.");
            } else {
                products.put(product.getProductId(), product);
                System.out.println("Product added.");
            }
        }

        public void updateProduct(int productId, String name, Integer quantity, Double price) {
            Product product = products.get(productId);
            if (product != null) {
                if (name != null) product.setProductName(name);
                if (quantity != null) product.setQuantity(quantity);
                if (price != null) product.setPrice(price);
                System.out.println("Product updated.");
            } else {
                System.out.println("Product not found.");
            }
        }

        public void deleteProduct(int productId) {
            if (products.remove(productId) != null) {
                System.out.println("Product deleted.");
            } else {
                System.out.println("Product not found.");
            }
        }

        public void displayInventory() {
            if (products.isEmpty()) {
                System.out.println("Inventory is empty.");
            } else {
                for (Product p : products.values()) {
                    System.out.println(p);
                }
            }
        }
    }

    // Main method with basic menu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        boolean running = true;

        while (running) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Inventory");
            System.out.println("5. Exit");
            System.out.print("Select option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    Product p = new Product(id, name, qty, price);
                    inventory.addProduct(p);
                    break;

                case 2:
                    System.out.print("Enter Product ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter new name (or press enter to skip): ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new quantity (-1 to skip): ");
                    int newQty = scanner.nextInt();
                    System.out.print("Enter new price (-1 to skip): ");
                    double newPrice = scanner.nextDouble();
                    inventory.updateProduct(updateId,
                            newName.isEmpty() ? null : newName,
                            newQty >= 0 ? newQty : null,
                            newPrice >= 0 ? newPrice : null);
                    break;

                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int delId = scanner.nextInt();
                    inventory.deleteProduct(delId);
                    break;

                case 4:
                    inventory.displayInventory();
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}
