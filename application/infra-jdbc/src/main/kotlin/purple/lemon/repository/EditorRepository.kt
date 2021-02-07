package purple.lemon.repository

import java.util.*

interface EditorRepository {

    fun saveDataContent(request: SaveDataRequest)

    fun getEditorData(request: GetDataRequest): Optional<EditorDataResponse>

    data class SaveDataRequest(
            val id: Int,
            val content: String?
    )

    data class GetDataRequest(
            val userId: Int
    )

    data class EditorDataResponse(
            val id: Int,
            val editorData: String
    )
}