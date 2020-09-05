package purple.lemon.dashboard.model;

public class Interactable {

    private final int id;
    private final String source;
    private final String title;

    public Interactable(int id, String source, String title) {
        this.id = id;
        this.source = source;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public String getTitle() {
        return title;
    }
}
