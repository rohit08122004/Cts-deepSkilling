public class OrderSorting {

    // Order class
    static class Order {
        int orderId;
        String customerName;
        double totalPrice;

        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        public String toString() {
            return "OrderID: " + orderId + ", Customer: " + customerName + ", Total: $" + totalPrice;
        }
    }

    // Bubble Sort: Sort by totalPrice in descending order
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].totalPrice < orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort: Sort by totalPrice in descending order
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    // Partition logic for Quick Sort
    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice >= pivot) { // Descending order
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    // Display all orders
    public static void displayOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    // Copy array (to reuse original data)
    public static Order[] copyOrders(Order[] original) {
        Order[] copy = new Order[original.length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = new Order(original[i].orderId, original[i].customerName, original[i].totalPrice);
        }
        return copy;
    }

    // Main method
    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Alice", 250.00),
            new Order(2, "Bob", 150.00),
            new Order(3, "Charlie", 350.00),
            new Order(4, "Diana", 50.00),
            new Order(5, "Evan", 400.00)
        };

        System.out.println("🔸 Original Orders:");
        displayOrders(orders);

        // Bubble Sort
        Order[] bubbleSorted = copyOrders(orders);
        bubbleSort(bubbleSorted);
        System.out.println("\n🔹 Orders Sorted by Bubble Sort (Descending):");
        displayOrders(bubbleSorted);

        // Quick Sort
        Order[] quickSorted = copyOrders(orders);
        quickSort(quickSorted, 0, quickSorted.length - 1);
        System.out.println("\n🔹 Orders Sorted by Quick Sort (Descending):");
        displayOrders(quickSorted);
    }
}
