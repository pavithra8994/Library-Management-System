package library_system;
import java.time.LocalDate;

class Transaction {
    int bookId;
    int userId;
    LocalDate issueDate;
    LocalDate returnDate;

    Transaction(int bookId, int userId) {
        this.bookId = bookId;
        this.userId = userId;
        this.issueDate = LocalDate.now();
        this.returnDate = null;
    }
}