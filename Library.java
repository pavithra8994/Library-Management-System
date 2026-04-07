package library_system;
import java.util.*;
import java.time.temporal.ChronoUnit;

class Library {
    List<Book> books = new ArrayList<>();
    List<User> users = new ArrayList<>();
    List<Transaction> transactions = new ArrayList<>();

    void addBook(Book b) {
        books.add(b);
        System.out.println("Book added!");
    }

    void addUser(User u) {
        users.add(u);
        System.out.println("User registered!");
    }

    void showBooks() {
        for (Book b : books) {
            System.out.println(b.id + " | " + b.title + " | " + b.author + " | Issued: " + b.issued);
        }
    }

    void issueBook(int bookId, int userId) {
        for (Book b : books) {
            if (b.id == bookId && !b.issued) {
                b.issued = true;
                transactions.add(new Transaction(bookId, userId));
                System.out.println("Book issued!");
                return;
            }
        }
        System.out.println("Book not available!");
    }

    void returnBook(int bookId) {
        for (Transaction t : transactions) {
            if (t.bookId == bookId && t.returnDate == null) {
                t.returnDate = java.time.LocalDate.now();

                long days = ChronoUnit.DAYS.between(t.issueDate, t.returnDate);
                long fine = (days > 7) ? (days - 7) * 5 : 0;

                for (Book b : books) {
                    if (b.id == bookId) {
                        b.issued = false;
                    }
                }

                System.out.println("Book returned!");
                System.out.println("Fine: ₹" + fine);
                return;
            }
        }
        System.out.println("Invalid return!");
    }

    void search(String keyword) {
        for (Book b : books) {
            if (b.title.toLowerCase().contains(keyword.toLowerCase()) ||
                b.author.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b.title + " by " + b.author);
            }
        }
    }
}