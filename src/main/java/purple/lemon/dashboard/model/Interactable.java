package purple.lemon.dashboard.model;

public class Interactable {

    private final int id;
    private final String redirectionUrl;
    private final String placeholderSrc;
    private final String src;
    private final String slug;
    private final String gif;
    private final String title;

    public Interactable(int id,
                        String redirectionUrl,
                        String placeholderSrc,
                        String src,
                        // represent the URL page which should be loaded.
                        String slug,
                        String gif,
                        String title) {
        this.id = id;
        this.redirectionUrl = redirectionUrl;
        this.placeholderSrc = placeholderSrc;
        this.slug = slug;
        this.src = src;
        this.gif = gif;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getRedirectionUrl() {
        return redirectionUrl;
    }

    public String getPlaceholderSrc() {
        return placeholderSrc;
    }

    public String getSrc() {
        return src;
    }

    public String getSlug() {
        return slug;
    }

    public String getGif() {
        return gif;
    }

    public String getTitle() {
        return title;
    }
}
