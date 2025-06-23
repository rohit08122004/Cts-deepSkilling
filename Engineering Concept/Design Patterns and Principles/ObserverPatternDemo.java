import java.util.*;

// Main class
public class ObserverPatternDemo {

    // Step 2: Subject Interface
    interface Stock {
        void registerObserver(Observer o);
        void removeObserver(Observer o);
        void notifyObservers();
    }

    // Step 4: Observer Interface
    interface Observer {
        void update(String stockName, double newPrice);
    }

    // Step 3: Concrete Subject
    static class StockMarket implements Stock {
        private List<Observer> observers = new ArrayList<>();
        private String stockName;
        private double price;

        public void setStockPrice(String stockName, double newPrice) {
            this.stockName = stockName;
            this.price = newPrice;
            System.out.println("\nStock updated: " + stockName + " = $" + newPrice);
            notifyObservers();
        }

        @Override
        public void registerObserver(Observer o) {
            observers.add(o);
        }

        @Override
        public void removeObserver(Observer o) {
            observers.remove(o);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(stockName, price);
            }
        }
    }

    // Step 5: Concrete Observers
    static class MobileApp implements Observer {
        private String user;

        public MobileApp(String user) {
            this.user = user;
        }

        @Override
        public void update(String stockName, double newPrice) {
            System.out.println("MobileApp [" + user + "] - Stock: " + stockName + ", New Price: $" + newPrice);
        }
    }

    static class WebApp implements Observer {
        private String user;

        public WebApp(String user) {
            this.user = user;
        }

        @Override
        public void update(String stockName, double newPrice) {
            System.out.println("WebApp [" + user + "] - Stock: " + stockName + ", New Price: $" + newPrice);
        }
    }

    // Step 6: Test the Observer Pattern
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer user1Mobile = new MobileApp("Alice");
        Observer user2Web = new WebApp("Bob");

        stockMarket.registerObserver(user1Mobile);
        stockMarket.registerObserver(user2Web);

        stockMarket.setStockPrice("AAPL", 185.50);
        stockMarket.setStockPrice("GOOGL", 2763.75);

        // Unregister one observer and update stock again
        stockMarket.removeObserver(user1Mobile);
        stockMarket.setStockPrice("MSFT", 351.00);
    }
}
