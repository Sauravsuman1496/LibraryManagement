

import java.util.*;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private HashMap<Integer, Integer> issuedBooks = new HashMap<>(); // bookId -> userId

    // Add a book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("✅ Book added successfully!");
    }

    // Add a user
    public void addUser(User user) {
        users.add(user);
        System.out.println("✅ User added successfully!");
    }

    // Display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("📚 No books available in the library.");
            return;
        }
        System.out.println("\n--- Book List ---");
        for (Book b : books) b.displayBook();
    }

    // Display all users
    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("👥 No users available.");
            return;
        }
        System.out.println("\n--- User List ---");
        for (User u : users) u.displayUser();
    }

    // Issue a book
    public void issueBook(int bookId, int userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book == null) {
            System.out.println("❌ Book not found!");
            return;
        }
        if (user == null) {
            System.out.println("❌ User not found!");
            return;
        }
        if (book.isIssued) {
            System.out.println("⚠️ Book is already issued!");
            return;
        }

        book.isIssued = true;
        issuedBooks.put(bookId, userId);
        System.out.println("✅ Book issued successfully to " + user.name);
    }

    // Return a book
    public void returnBook(int bookId) {
        Book book = findBookById(bookId);
        if (book == null || !book.isIssued) {
            System.out.println("⚠️ Invalid return operation!");
            return;
        }

        book.isIssued = false;
        issuedBooks.remove(bookId);
        System.out.println("✅ Book returned successfully!");
    }

    // Helper functions
    private Book findBookById(int id) {
        for (Book b : books)
            if (b.id == id)
                return b;
        return null;
    }

    private User findUserById(int id) {
        for (User u : users)
            if (u.id == id)
                return u;
        return null;
    }
}
