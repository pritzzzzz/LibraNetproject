public class EMagazine extends LibraryItem {
    private int issueNumber;

    public EMagazine(int id, String title, String author, int issueNumber) {
        super(id, title, author);
        this.issueNumber = issueNumber;
    }

    public void archiveIssue() {
        System.out.println("Archiving issue " + issueNumber);
    }

    @Override
    public void displayDetails() {
        System.out.println("E-Magazine: " + title + " (Issue " + issueNumber + ")");
    }
}
