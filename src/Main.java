import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n======= Library System =======");
                System.out.println("1. Add a Book");
                System.out.println("2. View Books");
                System.out.println("3. Search Book (by ID or Title)");
                System.out.println("4. Update Book");
                System.out.println("5. Remove Book");
                System.out.println("6. Exit");
                System.out.print("Select an option: ");

                int option = scanner.nextInt();
                scanner.nextLine(); // Consume extra newline

                switch (option) {
                    case 1:
                        addBook(scanner, library);
                        break;
                    case 2:
                        library.viewAllBooks();
                        break;
                    case 3:
                        System.out.print("Enter Book ID or Title: ");
                        String searchQuery = scanner.nextLine();
                        library.searchBook(searchQuery);
                        break;
                    case 4:
                        updateBook(scanner, library);
                        break;
                    case 5:
                        System.out.print("Enter Book ID to remove: ");
                        String bookId = scanner.nextLine();
                        library.deleteBook(bookId);
                        break;
                    case 6:
                        System.out.println("Exiting... Have a great day!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please pick a number between 1 and 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Oops! That’s not a valid number. Try again.");
                scanner.nextLine(); // Clear invalid input
            } catch (Exception e) {
                System.out.println("Something unexpected happened: " + e.getMessage());
            }
        }
    }

    private static void addBook(Scanner scanner, LibraryManager library) {
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine().trim();

        String title;
        do {
            System.out.print("Enter Book Title: ");
            title = scanner.nextLine().trim();
            if (title.isEmpty()) {
                System.out.println("Title cannot be blank. Please enter a valid title.");
            }
        } while (title.isEmpty());

        String author;
        do {
            System.out.print("Enter Author: ");
            author = scanner.nextLine().trim();
            if (author.isEmpty()) {
                System.out.println("Author cannot be blank. Please enter a valid author.");
            }
        } while (author.isEmpty());

        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine().trim();

        boolean isAvailable = getAvailability(scanner);
        library.addBook(bookId, title, author, genre, isAvailable);
    }

    private static void updateBook(Scanner scanner, LibraryManager library) {
        System.out.print("Enter Book ID to update: ");
        String bookId = scanner.nextLine().trim();

        System.out.print("New Title (press Enter to keep current): ");
        String newTitle = scanner.nextLine().trim();

        System.out.print("New Author (press Enter to keep current): ");
        String newAuthor = scanner.nextLine().trim();

        System.out.print("New Genre (press Enter to keep current): ");
        String newGenre = scanner.nextLine().trim();

        Boolean newAvailability = getAvailabilityOptional(scanner);

        library.updateBook(bookId, newTitle, newAuthor, newGenre, newAvailability);
    }

    private static boolean getAvailability(Scanner scanner) {
        while (true) {
            System.out.print("Availability (1 for Available, 0 for Checked Out): ");
            String input = scanner.nextLine().trim();

            if (input.equals("1") || input.equalsIgnoreCase("Available")) {
                return true;
            } else if (input.equals("0") || input.equalsIgnoreCase("Checked Out")) {
                return false;
            }
            System.out.println("Invalid input. Enter 1 for Available, or 0 for Checked Out.");
        }
    }

    private static Boolean getAvailabilityOptional(Scanner scanner) {
        while (true) {
            System.out.print("Change Availability? (1 for Available, 0 for Checked Out, -1 to skip): ");
            String input = scanner.nextLine().trim();

            if (input.equals("1") || input.equalsIgnoreCase("Available")) {
                return true;
            } else if (input.equals("0") || input.equalsIgnoreCase("Checked Out")) {
                return false;
            } else if (input.equals("-1")) {
                return null;
            }
            System.out.println("Invalid input. Enter 1, 0, or -1 to skip.");
        }
    }
}
