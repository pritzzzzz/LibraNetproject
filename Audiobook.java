public class Audiobook extends LibraryItem implements Playable {
    private int duration; // minutes

    public Audiobook(int id, String title, String author, int duration) {
        super(id, title, author);
        this.duration = duration;
    }

    @Override
    public void play() {
        System.out.println("Playing audiobook: " + title);
    }

    @Override
    public void displayDetails() {
        System.out.println("Audiobook: " + title + " (" + duration + " mins)");
    }
}
