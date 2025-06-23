public class DependencyInjectionDemo {

    // Step 2: Repository Interface
    interface CustomerRepository {
        Customer findCustomerById(int id);
    }

    // Simple Customer model class
    static class Customer {
        private int id;
        private String name;

        public Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() { return id; }
        public String getName() { return name; }
    }

    // Step 3: Concrete Repository Implementation
    static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public Customer findCustomerById(int id) {
            // Simulate DB lookup
            System.out.println("Fetching customer with ID " + id + " from repository.");
            // Returning a dummy customer for demonstration
            return new Customer(id, "Customer #" + id);
        }
    }

    // Step 4 & 5: Service Class with Constructor Injection
    static class CustomerService {
        private CustomerRepository repository;

        // Constructor Injection
        public CustomerService(CustomerRepository repository) {
            this.repository = repository;
        }

        public void printCustomerDetails(int id) {
            Customer customer = repository.findCustomerById(id);
            if (customer != null) {
                System.out.println("Customer ID: " + customer.getId());
                System.out.println("Customer Name: " + customer.getName());
            } else {
                System.out.println("Customer not found.");
            }
        }
    }

    // Step 6: Test the Dependency Injection Implementation
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject repository dependency into service
        CustomerService service = new CustomerService(repository);

        // Use service to find and print customer details
        service.printCustomerDetails(42);
    }
}
