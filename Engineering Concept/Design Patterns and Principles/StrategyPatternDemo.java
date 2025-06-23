public class StrategyPatternDemo {

    // Step 2: Strategy Interface
    interface PaymentStrategy {
        void pay(double amount);
    }

    // Step 3: Concrete Strategies
    static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;
        private String cardHolderName;
        private String cvv;

        public CreditCardPayment(String cardNumber, String cardHolderName, String cvv) {
            this.cardNumber = cardNumber;
            this.cardHolderName = cardHolderName;
            this.cvv = cvv;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paid $" + amount + " using Credit Card.");
            System.out.println("Card Holder: " + cardHolderName);
        }
    }

    static class PayPalPayment implements PaymentStrategy {
        private String email;
        private String password;

        public PayPalPayment(String email, String password) {
            this.email = email;
            this.password = password;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paid $" + amount + " using PayPal.");
            System.out.println("PayPal account: " + email);
        }
    }

    // Step 4: Context Class
    static class PaymentContext {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void payAmount(double amount) {
            if (paymentStrategy == null) {
                System.out.println("Payment method not selected!");
            } else {
                paymentStrategy.pay(amount);
            }
        }
    }

    // Step 5: Test the Strategy Pattern
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay with Credit Card
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432", "John Doe", "123"));
        context.payAmount(250.75);

        System.out.println();

        // Pay with PayPal
        context.setPaymentStrategy(new PayPalPayment("john.doe@example.com", "password123"));
        context.payAmount(89.99);
    }
}
