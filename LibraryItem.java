public abstract class LibraryItem {
    protected int id;
    protected String title;
    protected String author;
    protected boolean available = true;

    public LibraryItem(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public void borrowItem() { available = false; }
    public void returnItem() { available = true; }
    public boolean isAvailable() { return available; }

    public abstract void displayDetails();
}
