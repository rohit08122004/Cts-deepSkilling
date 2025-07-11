public class MVCPatternDemo {

    // Step 2: Model Class
    static class Student {
        private String name;
        private int id;
        private String grade;

        public Student(String name, int id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    // Step 3: View Class
    static class StudentView {
        public void displayStudentDetails(String name, int id, String grade) {
            System.out.println("Student Details:");
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Grade: " + grade);
        }
    }

    // Step 4: Controller Class
    static class StudentController {
        private Student model;
        private StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void setStudentName(String name) {
            model.setName(name);
        }

        public String getStudentName() {
            return model.getName();
        }

        public void setStudentId(int id) {
            model.setId(id);
        }

        public int getStudentId() {
            return model.getId();
        }

        public void setStudentGrade(String grade) {
            model.setGrade(grade);
        }

        public String getStudentGrade() {
            return model.getGrade();
        }

        public void updateView() {
            view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
        }
    }

    // Step 5: Test the MVC Implementation
    public static void main(String[] args) {
        // Create model object
        Student student = new Student("John Doe", 101, "A");

        // Create view object
        StudentView view = new StudentView();

        // Create controller object
        StudentController controller = new StudentController(student, view);

        // Display initial details
        controller.updateView();

        // Update model data via controller
        controller.setStudentName("Jane Smith");
        controller.setStudentGrade("A+");

        // Display updated details
        System.out.println("\nAfter update:");
        controller.updateView();
    }
}
