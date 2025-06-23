public class AdapterPatternDemo {

    // Step 2: Target Interface
    interface PaymentProcessor {
        void processPayment(double amount);
    }

    // Step 3: Adaptee Classes (Third-party payment gateways)
    static class PayPal {
        public void makePayment(double amount) {
            System.out.println("Paid " + amount + " using PayPal.");
        }
    }

    static class Stripe {
        public void pay(double amountInDollars) {
            System.out.println("Paid " + amountInDollars + " using Stripe.");
        }
    }

    static class Razorpay {
        public void doPayment(double value) {
            System.out.println("Paid " + value + " using Razorpay.");
        }
    }

    // Step 4: Adapter Classes for each gateway
    static class PayPalAdapter implements PaymentProcessor {
        private PayPal payPal;

        public PayPalAdapter(PayPal payPal) {
            this.payPal = payPal;
        }

        @Override
        public void processPayment(double amount) {
            payPal.makePayment(amount);
        }
    }

    static class StripeAdapter implements PaymentProcessor {
        private Stripe stripe;

        public StripeAdapter(Stripe stripe) {
            this.stripe = stripe;
        }

        @Override
        public void processPayment(double amount) {
            stripe.pay(amount);
        }
    }

    static class RazorpayAdapter implements PaymentProcessor {
        private Razorpay razorpay;

        public RazorpayAdapter(Razorpay razorpay) {
            this.razorpay = razorpay;
        }

        @Override
        public void processPayment(double amount) {
            razorpay.doPayment(amount);
        }
    }

    // Step 5: Test Class
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPal());
        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        PaymentProcessor razorpayProcessor = new RazorpayAdapter(new Razorpay());

        // Processing payments through adapters
        paypalProcessor.processPayment(100.00);
        stripeProcessor.processPayment(200.00);
        razorpayProcessor.processPayment(300.00);
    }
}
