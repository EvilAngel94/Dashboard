package api;

import org.springframework.web.bind.annotation.*;
import purple.lemon.dashboard.model.EditorData;
import purple.lemon.dashboard.model.EditorDataVO;
import purple.lemon.dashboard.repository.EditorRepository;

import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:1994"})
@RestController
@RequestMapping("/api/editor")
public class EditorController {

    final EditorRepository editorRepository;

    public EditorController(EditorRepository editorRepository) {
        this.editorRepository = editorRepository;
    }

    @GetMapping("/content")
    public EditorDataVO getEditorData() {
        Optional<EditorData> optionalEditorData = editorRepository.getEditorData(1);
        return optionalEditorData.map(EditorDataVO::transform).orElseGet(EditorDataVO::empty);
    }

    @PutMapping("/store")
    public void updateEditorData(@RequestParam(value = "dataToStore") String dataToStore) {
        if (dataToStore != null) {
            editorRepository.saveDataContent(1, dataToStore);
        }
    }
}
