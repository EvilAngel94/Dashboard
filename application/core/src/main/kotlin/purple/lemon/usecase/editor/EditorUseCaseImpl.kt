package purple.lemon.usecase.editor

import purple.lemon.model.EditorData
import purple.lemon.infra.jdbc.EditorRepository

class EditorUseCaseImpl(
        private val editorRepository: EditorRepository
) : EditorUseCase {

    override fun getEditorData(request: EditorUseCase.Request): EditorUseCase.Response {
        val editorRequest = EditorRepository.GetDataRequest(request.userId)
        val response = editorRepository.getEditorData(editorRequest)
        if (response.isPresent) {
            return EditorUseCase.Response(
                    EditorData(
                            id = response.get().userId,
                            data = response.get().editorData
                    )
            )
        }
        return EditorUseCase.Response.emptyResponse()
    }

    override fun saveEditorData(request: EditorUseCase.Request) {
        val editorRequest = EditorRepository.SaveDataRequest(userId = request.userId, content = request.dataToStore)
        editorRepository.saveDataContent(editorRequest)
    }
}