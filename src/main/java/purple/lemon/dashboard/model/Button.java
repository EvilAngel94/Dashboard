package purple.lemon.dashboard.model;

public class Button {

    private final int id;
    private final String pathToPicture;
    private final String pathToGif;
    private final String altText;

    public Button(int id, String pathToPicture, String pathToGif, String altText) {
        this.id = id;
        this.pathToPicture = pathToPicture;
        this.pathToGif = pathToGif;
        this.altText = altText;
    }

    public int getId() {
        return id;
    }

    public String getPathToPicture() {
        return pathToPicture;
    }

    public String getPathToGif() {
        return pathToGif;
    }

    public String getAltText() {
        return altText;
    }
}
