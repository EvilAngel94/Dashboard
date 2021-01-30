package purple.lemon.repository

import java.util.*

interface EditorRepository {

    fun saveDataContent(request: SaveDataRequest)

    fun getEditorData(request: GetDateRequest): Optional<EditorDataResponse>

    data class SaveDataRequest(
            val id: Int,
            val content: String?
    )

    data class GetDateRequest(
            val id: Int
    )

    data class EditorDataResponse(
            val id: Int,
            val editorData: String
    )
}