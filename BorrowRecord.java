import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BorrowRecord {
    private LibraryItem item;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private LocalDate dueDate;
    private static final int LOAN_DAYS = 14;
    private static final DateTimeFormatter F = DateTimeFormatter.ofPattern("dd-MM-yy");


    public BorrowRecord(LibraryItem item, String borrowDateStr) {
        this.item = item;
        this.borrowDate = LocalDate.parse(borrowDateStr, F);
        this.dueDate = borrowDate.plusDays(LOAN_DAYS);
        item.borrowItem();
    }

    public void returnItem(String returnDateStr) {
        this.returnDate = LocalDate.parse(returnDateStr, F);
        item.returnItem();
    }

    public long calculateFine(int finePerDay) {
        if (returnDate == null) return 0;
        long overdue = ChronoUnit.DAYS.between(dueDate, returnDate);
        return overdue > 0 ? overdue * finePerDay : 0;
    }

    public LocalDate getDueDate() { return dueDate; }
}
