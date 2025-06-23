public class ProxyPatternDemo {

    // Step 2: Subject Interface
    interface Image {
        void display();
    }

    // Step 3: Real Subject Class
    static class RealImage implements Image {
        private String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromRemoteServer();
        }

        private void loadFromRemoteServer() {
            System.out.println("Loading image from remote server: " + filename);
            try {
                Thread.sleep(1000); // Simulate network delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void display() {
            System.out.println("Displaying image: " + filename);
        }
    }

    // Step 4: Proxy Class with Lazy Initialization and Caching
    static class ProxyImage implements Image {
        private String filename;
        private RealImage realImage;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename); // Lazy loading
            } else {
                System.out.println("Image already loaded (from cache): " + filename);
            }
            realImage.display();
        }
    }

    // Step 5: Test the Proxy Implementation
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        System.out.println("First display of photo1:");
        image1.display(); // Loads from remote

        System.out.println("\nSecond display of photo1:");
        image1.display(); // Uses cached version

        System.out.println("\nDisplay of photo2:");
        image2.display(); // Loads from remote
    }
}
