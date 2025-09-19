import java.util.*;

public class Library {
    private Map<Integer, LibraryItem> items = new HashMap<>();

    public void addItem(LibraryItem item) {
        items.put(item.id, item);
    }

    public LibraryItem getItem(int id) {
        return items.get(id);
    }

    public void showAllItems() {
        if (items.isEmpty()) {
            System.out.println("No items in library.");
            return;
        }
        for (LibraryItem item : items.values()) {
            item.displayDetails();
            System.out.println("Available: " + item.isAvailable());
        }
    }
}
