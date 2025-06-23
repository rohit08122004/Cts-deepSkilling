public class ComputerBuilderDemo {

    // Step 1 & 2: Define the Product class
    static class Computer {
        private String CPU;
        private String RAM;
        private String storage;
        private boolean hasGraphicsCard;
        private boolean hasBluetooth;

        // Step 4: Private constructor to enforce building through Builder
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.hasGraphicsCard = builder.hasGraphicsCard;
            this.hasBluetooth = builder.hasBluetooth;
        }

        // Step 3: Static nested Builder class
        public static class Builder {
            private String CPU;
            private String RAM;
            private String storage;
            private boolean hasGraphicsCard;
            private boolean hasBluetooth;

            public Builder(String CPU, String RAM) {
                this.CPU = CPU;
                this.RAM = RAM;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCard(boolean hasGraphicsCard) {
                this.hasGraphicsCard = hasGraphicsCard;
                return this;
            }

            public Builder setBluetooth(boolean hasBluetooth) {
                this.hasBluetooth = hasBluetooth;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }

        // Display method
        public void showConfig() {
            System.out.println("=== Computer Configuration ===");
            System.out.println("CPU: " + CPU);
            System.out.println("RAM: " + RAM);
            System.out.println("Storage: " + (storage != null ? storage : "Not specified"));
            System.out.println("Graphics Card: " + (hasGraphicsCard ? "Yes" : "No"));
            System.out.println("Bluetooth: " + (hasBluetooth ? "Yes" : "No"));
            System.out.println();
        }
    }

    // Step 5: Testing the Builder Pattern
    public static void main(String[] args) {
        // Create a high-performance gaming PC
        Computer gamingPC = new Computer.Builder("AMD Ryzen 9", "32GB")
                .setStorage("1TB NVMe SSD")
                .setGraphicsCard(true)
                .setBluetooth(true)
                .build();

        // Create a simple office PC
        Computer officePC = new Computer.Builder("Intel i3", "8GB")
                .setStorage("256GB SSD")
                .setGraphicsCard(false)
                .setBluetooth(false)
                .build();

        // Display both configurations
        gamingPC.showConfig();
        officePC.showConfig();
    }
}
