package purple.lemon.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EditorData {

    @Id
    private int id;
    private String editorData;

    public EditorData(int id, String editorData) {
        this.id = id;
        this.editorData = editorData;
    }

    public EditorData(String editorData) {
        this.id = 100;
        this.editorData = editorData;
    }

    public EditorData() {
    }

    public static EditorData empty() {
        return new EditorData("");
    }

}
