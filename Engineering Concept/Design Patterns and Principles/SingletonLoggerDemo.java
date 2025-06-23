public class SingletonLoggerDemo {

    // Singleton Logger class
    static class Logger {
        // Private static instance
        private static Logger instance;

        // Private constructor
        private Logger() {
            System.out.println("Logger initialized.");
        }

        // Public method to provide access to the instance
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        // Logging method
        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    // Main method to test the Singleton
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");

        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same. Singleton verified.");
        } else {
            System.out.println("Logger instances are different. Singleton failed.");
        }
    }
}
