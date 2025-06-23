import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ProductSearchSystem {

    // Product class
    static class Product {
        private int productId;
        private String productName;
        private String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public String getProductName() {
            return productName;
        }

        public String toString() {
            return "ID: " + productId + ", Name: " + productName + ", Category: " + category;
        }
    }

    // Linear Search
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product p : products) {
            if (p.getProductName().equalsIgnoreCase(targetName)) {
                return p;
            }
        }
        return null;
    }

    // Sort products by name (needed for binary search)
    public static void sortProductsByName(Product[] products) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midName = products[mid].getProductName();

            int comparison = midName.compareToIgnoreCase(targetName);
            if (comparison == 0) return products[mid];
            else if (comparison < 0) left = mid + 1;
            else right = mid - 1;
        }

        return null;
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample product data
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(103, "Camera", "Electronics"),
            new Product(104, "T-Shirt", "Fashion"),
            new Product(105, "Mouse", "Electronics")
        };

        System.out.println("Enter product name to search:");
        String searchName = scanner.nextLine();

        // Linear Search
        System.out.println("\n🔍 Linear Search Result:");
        Product foundLinear = linearSearch(products, searchName);
        System.out.println(foundLinear != null ? foundLinear : "Product not found.");

        // Binary Search (requires sorted array)
        sortProductsByName(products);
        System.out.println("\n🔍 Binary Search Result:");
        Product foundBinary = binarySearch(products, searchName);
        System.out.println(foundBinary != null ? foundBinary : "Product not found.");

        scanner.close();
    }
}
