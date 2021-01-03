package purple.lemon.dashboard.model;

public class EditorDataVO {
    private final int id;
    private final String editorData;

    public EditorDataVO(int id, String editorData) {
        this.id = id;
        this.editorData = editorData;
    }

    private EditorDataVO() {
        this.id = 0;
        this.editorData = "";
    }

    public static EditorDataVO empty() {
        return new EditorDataVO();
    }

    public static EditorDataVO transform(EditorData editorData) {
        return new EditorDataVO(
                editorData.getId(),
                editorData.getEditorData()
        );
    }

    public int getId() {
        return id;
    }

    public String getEditorData() {
        return editorData;
    }
}
