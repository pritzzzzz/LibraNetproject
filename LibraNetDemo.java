import java.util.Scanner;

public class LibraNetDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n--- LibraNet Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add Audiobook");
            System.out.println("3. Add E-Magazine");
            System.out.println("4. Show All Items");
            System.out.println("5. Borrow Item");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int idB = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Title: ");
                    String tB = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String aB = sc.nextLine();
                    System.out.print("Enter Page Count: ");
                    int pc = sc.nextInt();
                    lib.addItem(new Book(idB, tB, aB, pc));
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int idA = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Title: ");
                    String tA = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String aA = sc.nextLine();
                    System.out.print("Enter Duration (minutes): ");
                    int dur = sc.nextInt();
                    lib.addItem(new Audiobook(idA, tA, aA, dur));
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int idM = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Title: ");
                    String tM = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String aM = sc.nextLine();
                    System.out.print("Enter Issue Number: ");
                    int issue = sc.nextInt();
                    lib.addItem(new EMagazine(idM, tM, aM, issue));
                    break;

                case 4:
                    lib.showAllItems();
                    break;

                case 5:
                    System.out.print("Enter Item ID to borrow: ");
                    int id = sc.nextInt(); sc.nextLine();
                    LibraryItem item = lib.getItem(id);
                    if (item == null) {
                        System.out.println("Item not found.");
                        break;
                    }
                    if (!item.isAvailable()) {
                        System.out.println("Item already borrowed.");
                        break;
                    }
                    System.out.print("Enter borrow date (dd-MM-yy): ");
                    String borrowDate = sc.nextLine();
                    BorrowRecord record = new BorrowRecord(item, borrowDate);
                    System.out.println("Borrowed! Due on: " + record.getDueDate());

                    System.out.print("Enter return date (dd-MM-yy): ");
                    String returnDate = sc.nextLine();
                    record.returnItem(returnDate);

                    long fine = record.calculateFine(10);
                    System.out.println("Fine: " + fine + " rs");
                    break;

                case 6:
                    System.out.println("Exiting LibraNet. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
