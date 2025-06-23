public class DecoratorPatternDemo {

    // Step 2: Component Interface
    interface Notifier {
        void send(String message);
    }

    // Step 3: Concrete Component
    static class EmailNotifier implements Notifier {
        @Override
        public void send(String message) {
            System.out.println("Sending EMAIL: " + message);
        }
    }

    // Step 4: Abstract Decorator
    static abstract class NotifierDecorator implements Notifier {
        protected Notifier wrappedNotifier;

        public NotifierDecorator(Notifier notifier) {
            this.wrappedNotifier = notifier;
        }

        @Override
        public void send(String message) {
            wrappedNotifier.send(message); // Delegates to wrapped notifier
        }
    }

    // Step 4: Concrete Decorators

    static class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        @Override
        public void send(String message) {
            super.send(message);
            sendSMS(message);
        }

        private void sendSMS(String message) {
            System.out.println("Sending SMS: " + message);
        }
    }

    static class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        @Override
        public void send(String message) {
            super.send(message);
            sendSlack(message);
        }

        private void sendSlack(String message) {
            System.out.println("Sending Slack message: " + message);
        }
    }

    // Step 5: Test the Decorator Pattern
    public static void main(String[] args) {
        // Base notifier: Email
        Notifier emailNotifier = new EmailNotifier();

        // Add SMS notification on top of Email
        Notifier smsAndEmail = new SMSNotifierDecorator(emailNotifier);

        // Add Slack notification on top of SMS and Email
        Notifier allChannels = new SlackNotifierDecorator(smsAndEmail);

        System.out.println("Sending via Email + SMS + Slack:");
        allChannels.send("System update scheduled at 10 PM.");

        System.out.println("\nSending via Email only:");
        emailNotifier.send("Welcome to our service!");
    }
}
