package purple.lemon.usecase.editor

import purple.lemon.model.EditorData

interface EditorUseCase {

    fun getEditorData(request: Request): Response
    fun saveEditorData(request: Request)

    data class Request(val userId: Int, val dataToStore: String = "")

    data class Response(val editorData: EditorData) {
        companion object {
            fun emptyResponse(): Response {
                return Response(
                        EditorData.emptyObject()
                )
            }

        }
    }
}