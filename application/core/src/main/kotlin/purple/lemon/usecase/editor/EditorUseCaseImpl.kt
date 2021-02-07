package purple.lemon.usecase.editor

import purple.lemon.model.EditorData
import purple.lemon.repository.EditorRepository

class EditorUseCaseImpl(
        private val editorRepository: EditorRepository
) : EditorUseCase {

    override fun getEditorData(request: EditorUseCase.Request): EditorUseCase.Response {
        val createEditorRequest = EditorRepository.GetDataRequest(request.userId)
        val response = editorRepository.getEditorData(createEditorRequest)
        if (response.isPresent) {
            return EditorUseCase.Response(
                    EditorData(
                            id = response.get().id,
                            data = response.get().editorData
                    )
            )
        }
        return EditorUseCase.Response.emptyResponse()
    }

    override fun saveEditorData(request: EditorUseCase.Request) {
        TODO("Not yet implemented")
    }
}