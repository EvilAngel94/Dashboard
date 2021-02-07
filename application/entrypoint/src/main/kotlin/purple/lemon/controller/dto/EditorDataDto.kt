package purple.lemon.controller.dto

import purple.lemon.model.EditorData

data class EditorDataDto(
        val id: Int,
        val editorData: String
) {
    companion object {
        fun transform(editorData: EditorData): EditorDataDto {
            return EditorDataDto(
                    id = editorData.id,
                    editorData = editorData.data
            )
        }
    }
}
