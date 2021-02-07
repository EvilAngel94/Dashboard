package purple.lemon.controller

import org.springframework.web.bind.annotation.*
import purple.lemon.controller.dto.EditorDataDto
import purple.lemon.usecase.editor.EditorUseCase

@CrossOrigin(origins = ["http://localhost:1994"])
@RestController
@RequestMapping("/api/editor")
class EditorController(
        private val editorUseCase: EditorUseCase
) {

    @GetMapping("/content")
    fun getEditorData(): EditorDataDto {
        val foundEditorData = editorUseCase.getEditorData(EditorUseCase.Request(1))
        return EditorDataDto.transform(foundEditorData.editorData)
    }

    @PutMapping("/store")
    fun updateEditorData(@RequestParam(value = "dataToStore") dataToStore: String) {
        if (dataToStore != null || dataToStore != "") {
            editorUseCase.saveEditorData(EditorUseCase.Request(1, dataToStore))
        }
    }
}