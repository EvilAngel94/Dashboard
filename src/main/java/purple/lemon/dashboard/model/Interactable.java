package purple.lemon.dashboard.model;

public class Interactable {

    private final int id;
    private final String placeholderSrc;
    private final String src;
    private final String gif;
    private final String title;

    public Interactable(int id, String placeholderSrc, String src, String gif, String title) {
        this.id = id;
        this.placeholderSrc = placeholderSrc;
        this.src = src;
        this.gif = gif;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getPlaceholderSrc() {
        return placeholderSrc;
    }

    public String getSrc() {
        return src;
    }

    public String getGif() {
        return gif;
    }

    public String getTitle() {
        return title;
    }

}
