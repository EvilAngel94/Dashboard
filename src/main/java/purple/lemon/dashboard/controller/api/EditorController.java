package purple.lemon.dashboard.controller.api;

import org.springframework.web.bind.annotation.*;
import purple.lemon.dashboard.model.EditorData;

@CrossOrigin(origins = {"http://localhost:1994"})
@RestController
@RequestMapping("/api/editor")
public class EditorController {

    @GetMapping("/data")
    public EditorData getEditorData() {
        return new EditorData("Dit is een test");
    }

    @PutMapping("/store")
    public void updateEditorData(@RequestParam(value = "dataToStore") String dataToStore) {
        //save the data in the h2 database
    }
}
