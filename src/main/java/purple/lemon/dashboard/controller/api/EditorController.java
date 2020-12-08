package purple.lemon.dashboard.controller.api;

import org.springframework.web.bind.annotation.*;
import purple.lemon.dashboard.model.EditorData;
import purple.lemon.dashboard.repository.EditorDataRepository;

import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:1994"})
@RestController
@RequestMapping("/api/editor")
public class EditorController {

    final EditorDataRepository repository;

    public EditorController(EditorDataRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/data")
    public EditorData getEditorData() {
        Optional<EditorData> optionalEditorData = repository.findById(1);
        return optionalEditorData.orElseGet(EditorData::empty);
    }

    @PutMapping("/store")
    public void updateEditorData(@RequestParam(value = "dataToStore") String dataToStore) {
        Optional<EditorData> optionalEditorData = repository.findById(1);
        if (optionalEditorData.isPresent()) {
            repository.save(new EditorData(1, dataToStore));
        }
        repository.save(new EditorData(dataToStore));
    }
}
