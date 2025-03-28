import java.util.*;

public class LibraryManager {
    private Map<String, Book> books;

    public LibraryManager() {
        books = new HashMap<>();
    }

    public void addBook(String id, String title, String author, String genre, boolean isAvailable) {
        if (books.containsKey(id)) {
            System.out.println("⚠️ A book with this ID already exists. Try a different ID.");
            return;
        }

        Book newBook = new Book(id, title, author, genre, isAvailable);
        books.put(id, newBook);
        System.out.println("✅ Book added successfully!");
    }

    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("📚 No books available in the catalog.");
            return;
        }
        System.out.println("\n======= Book Catalog =======");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public void searchBook(String query) {
        List<Book> results = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.getId().equalsIgnoreCase(query) || book.getTitle().equalsIgnoreCase(query)) {
                results.add(book);
            }
        }

        if (results.isEmpty()) {
            System.out.println("⚠️ No matching book found.");
        } else {
            System.out.println("\n📖 Search Results:");
            for (Book book : results) {
                System.out.println(book);
            }
        }
    }

    public void updateBook(String id, String newTitle, String newAuthor, String newGenre, Boolean newAvailability) {
        if (!books.containsKey(id)) {
            System.out.println("⚠️ No book found with the given ID.");
            return;
        }

        Book book = books.get(id);

        if (!newTitle.isBlank()) {
            book.setTitle(newTitle);
        }
        if (!newAuthor.isBlank()) {
            book.setAuthor(newAuthor);
        }
        if (!newGenre.isBlank()) {
            book.setGenre(newGenre);
        }
        if (newAvailability != null) {
            book.setAvailability(newAvailability);
        }

        System.out.println("✅ Book details updated successfully!");
    }

    public void deleteBook(String id) {
        if (books.remove(id) != null) {
            System.out.println("✅ Book deleted successfully.");
        } else {
            System.out.println("⚠️ No book found with the given ID.");
        }
    }
}
