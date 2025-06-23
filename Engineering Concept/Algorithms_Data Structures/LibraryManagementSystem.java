import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LibraryManagementSystem {

    // Book class
    static class Book {
        int bookId;
        String title;
        String author;

        Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book ID: " + bookId + ", Title: \"" + title + "\", Author: " + author;
        }
    }

    // Linear search by title
    static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary search by title (books must be sorted by title)
    static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample books
        Book[] books = {
            new Book(1, "The Hobbit", "J.R.R. Tolkien"),
            new Book(2, "1984", "George Orwell"),
            new Book(3, "To Kill a Mockingbird", "Harper Lee"),
            new Book(4, "Pride and Prejudice", "Jane Austen"),
            new Book(5, "Moby Dick", "Herman Melville")
        };

        // Sort books by title for binary search
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));

        System.out.println("Books available (sorted by title):");
        for (Book book : books) {
            System.out.println(book);
        }

        boolean running = true;
        while (running) {
            System.out.println("\nSearch options:");
            System.out.println("1. Linear Search by Title");
            System.out.println("2. Binary Search by Title");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1 -> {
                    System.out.print("Enter title to search (Linear): ");
                    String title = scanner.nextLine();
                    Book result = linearSearch(books, title);
                    System.out.println(result != null ? "Found: " + result : "Book not found.");
                }
                case 2 -> {
                    System.out.print("Enter title to search (Binary): ");
                    String title = scanner.nextLine();
                    Book result = binarySearch(books, title);
                    System.out.println(result != null ? "Found: " + result : "Book not found.");
                }
                case 3 -> {
                    running = false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid option, try again.");
            }
        }

        scanner.close();
    }
}

/*
Analysis:

- Linear Search:
  * Time Complexity: O(n)
  * Works on unsorted or sorted data
  * Simple but slower for large datasets

- Binary Search:
  * Time Complexity: O(log n)
  * Requires sorted data
  * Much faster for large datasets

Use linear search when the dataset is small or unsorted.
Use binary search when the dataset is large and sorted.
*/
