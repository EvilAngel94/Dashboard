package purple.lemon.dashboard.repository;

import purple.lemon.dashboard.model.EditorData;

import java.util.Optional;

public interface EditorRepository {

    void saveDataContent(int id, String content);

    Optional<EditorData> getEditorData(int id);
}
