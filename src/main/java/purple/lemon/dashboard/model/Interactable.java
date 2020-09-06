package purple.lemon.dashboard.model;

public class Interactable {

    private final int id;
    private final String source;
    private final String title;
    private final String onClickEvent;

    public Interactable(int id, String source, String title, String onClickEvent) {
        this.id = id;
        this.source = source;
        this.title = title;
        this.onClickEvent = onClickEvent;
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

    public String getOnClickEvent() {
        return onClickEvent;
    }
}
